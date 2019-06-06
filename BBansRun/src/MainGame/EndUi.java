package MainGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import MainGame.Game.STATE;
import MainGame.GameEnmy.BasicEnemy;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private Random r = new Random();
	private HUD hud;
	private MenuParticle MP;
	
	public Menu(Game game, Handler handler,HUD hud) {
		this.game = game;
		this.hud = hud;
		this.handler = handler;	
		
		MP = new MenuParticle(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),
				ID.MenuParticle,handler);
	}
	
	public void mousePressed(MouseEvent e)
	{
		int mx = e.getX();
		int my = e.getY();
		
		if(game.gameState == STATE.Menu) {
			
			//play 버튼
			if(mouseOver(mx,my,210,150,200,64)) {
				game.gameState = STATE.Game;
				
				handler.clearEnemys();
				
				handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32,
						ID.Player, handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),
						ID.BasicEnemy,handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),
						ID.BasicEnemy,handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),
						ID.BasicEnemy,handler));
			}
			
			//help 버튼
			if(mouseOver(mx,my,210,250,200,64))
			{
				game.gameState = STATE.Help;
			}
			
			//quit 버튼
			if(mouseOver(mx,my,210,350,200,64)) {
				System.exit(1);
			}
			
		}
	
		//help의 back버튼
		if(game.gameState == STATE.Help) {
			if(mouseOver(mx,my,210,350,200,64)) {
				game.gameState = STATE.Menu;
				return;
			}
		}
		
		//다시하기 버튼
		if(game.gameState == STATE.End) {
			if(mouseOver(mx,my,210,350,200,64)) {
				game.gameState = STATE.Game;
				hud.setLevel(1);
				hud.setScore(0);
				
				handler.addObject(new Player(Game.WIDTH/2-32,
						Game.HEIGHT/2-32, ID.Player, handler));
				
				handler.clearEnemys();
				
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),
						r.nextInt(Game.HEIGHT),ID.BasicEnemy,handler));
				
			}
		}
		
	}
	
	public void mouseReleased(MouseEvent e)
	{
		
	}
	
	private boolean mouseOver(int mx, int my,int x, int y, int width, int height)
	{
		if(mx > x && mx < x + width)
		{
			if(my > y && my < y + height)
			{
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick()
	{
		MP.tick();
	}
	public void render(Graphics g) 
	{
		if(game.gameState == STATE.Menu)
		{
			MP.render(g);
			Font fnt = new Font("arial", 1 , 50);
			Font fnt2 = new Font("arial", 1 , 50);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("BBansRun",200,70);
			
			g.setFont(fnt2);
			g.drawRect(210, 150, 200, 64);
			g.drawString("Play", 270, 190);
			
			
			g.drawRect(210, 250, 200, 64);
			g.drawString("Help", 270, 290);
			
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Quit", 270, 390);
			
		}else if(game.gameState == STATE.Help) {
			Font fnt = new Font("arial", 1 , 50);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help",240,70);
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 390);
		}else if(game.gameState == STATE.End) {
			Font fnt = new Font("arial", 1 , 50);
			Font fnt2 = new Font("arial", 1 , 30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over",200,70);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("You lost with a score of : " + hud.getScore(),100,270);
			
			g.drawRect(210, 350, 200, 64);
			g.drawString("Try Again", 250, 390);
		}
		
	}
	

}
