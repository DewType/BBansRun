package MainGame.GameEnmy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import MainGame.Game;
import MainGame.GameObject;
import MainGame.Handler;
import MainGame.ID;
import MainGame.Trail;

public class EnemyBossBullet extends GameObject{
	
	private Handler handler;
	Random r = new Random();

	public EnemyBossBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = r.nextInt(5 - -5) + -5;
		velY = 5;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,16,16);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if(y >= Game.HEIGHT) handler.removeObject(this);
		
		//if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		//if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		handler.addObject(new Trail((int)x, (int)y, Color.red, 16, 16, 0.02, handler, ID.Trail));
	}

	@Override
	public void render(Graphics g) {
		
		//Graphics2D g2d = (Graphics2D) g;
		
		//g.setColor(Color.green);
		//g2d.draw(getBounds());
		
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

}
