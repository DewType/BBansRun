package MainGame.GameEnmy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import MainGame.Game;
import MainGame.GameObject;
import MainGame.HUD;
import MainGame.Handler;
import MainGame.ID;
import MainGame.Trail;

public class FestEnemy extends GameObject{
	
	private Handler handler;

	public FestEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 2;
		velY = 9;
		
		velX = (float) (velX + (HUD.level));
		velY = (float) (velY + (HUD.level));
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,16,16);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		handler.addObject(new Trail(
				(int)x,
				(int)y,
				Color.cyan,
				16, 16, 0.02,
				handler,
				ID.Trail));
	}

	@Override
	public void render(Graphics g) {
		
		//Graphics2D g2d = (Graphics2D) g;
		
		//g.setColor(Color.green);
		//g2d.draw(getBounds());
		
		g.setColor(Color.CYAN);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

}
