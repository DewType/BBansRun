package MainGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6894136355153987721L;

	public static final int WIDTH = 640, HEIGHT = 480;
	
	private Thread thread;
	private boolean running = false;
	
	private Random r = new Random();
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private Shop shop;
	
	public enum STATE {
		Menu,
		Help,
		Game,
		Shop,
		End
	};
	
	public static STATE gameState = STATE.Menu;
	
	public static void Han() {
		main(null);
	}
	
	public Game() {
		new Window(WIDTH,HEIGHT,"BBansRun",this);
		
		handler = new Handler();
		hud = new HUD();
		
		shop = new Shop(handler,hud);
		menu = new Menu(this,handler,hud);
		this.addKeyListener(new KeyInput(handler));		//�궎留ㅻ땲��
		this.addMouseListener(menu);
		this.addMouseListener(shop);
		
		spawner = new Spawn(handler, hud);
		
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop() {
		try{
			thread.join();
			running = false;
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		this.requestFocus();		//�봽濡쒓렇�옩�쓣 �룎由ъ옄留덉옄 �씠怨녹쑝濡� �룷而ㅼ뒪瑜� �옟�븘以��떎
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();				//�벐�젅�뱶瑜� �궗�슜�빐�꽌 �듅�젙�떆媛꾨쭏�떎 �뾽�뜲�씠�듃瑜� �룎�젮以��떎
				delta--;
			}
			if(running)
				render();			//留덉갔媛�吏�濡� �듅�젙�떆媛꾨쭏�떎 �젋�뜑瑜� �룎�젮以��떎
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		
		if(gameState == STATE.Game)
		{
			hud.tick();
			spawner.tick();
			
			if(HUD.HEALTH <= 0) {
				HUD.HEALTH = 100;
				gameState = STATE.End;
				handler.clearEnemys();
			}
			
		}else if(gameState == STATE.Menu || gameState == STATE.End)
		{
			menu.tick();
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		//============================================
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		
		if(gameState == STATE.Game)
		{
			hud.render(g);
			handler.render(g);
			spawner.render(g);			//�굹以묒뿉 吏��슦湲�
		}else if(gameState == STATE.Shop){
			shop.render(g);
		}else if(gameState == STATE.Menu ||
				 gameState == STATE.Help||
				 gameState == STATE.End) {
			menu.render(g);
			handler.render(g);
		}
		
		//=============================================
		g.dispose();
		bs.show();
	}


	public static void main(String[] args) {
		new Game();
	}
	
	
}
