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
	
	public Game() {
		new Window(WIDTH,HEIGHT,"BBansRun",this);
		
		handler = new Handler();
		hud = new HUD();
		
		shop = new Shop(handler,hud);
		menu = new Menu(this,handler,hud);
		this.addKeyListener(new KeyInput(handler));		//키매니저
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
		this.requestFocus();		//프로그램을 돌리자마자 이곳으로 포커스를 잡아준다
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
				tick();				//쓰레드를 사용해서 특정시간마다 업데이트를 돌려준다
				delta--;
			}
			if(running)
				render();			//마찬가지로 특정시간마다 렌더를 돌려준다
			
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
			spawner.render(g);			//나중에 지우기
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
