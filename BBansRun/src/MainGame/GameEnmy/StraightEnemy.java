package MainGame.GameEnmy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import MainGame.Game;
import MainGame.GameObject;
import MainGame.HUD;
import MainGame.Handler;
import MainGame.ID;
import MainGame.Trail;

public class StraightEnemy extends GameObject{
	
	private Handler handler;
	
	private float MaxSpeed = 7.f;
	
	public StraightEnemy(float x, float y, float velX, float velY, ID id, Handler handler) {
		super(x, y, id);
		this.velX = velX;
		this.velY = velY;
		
		this.velX = (float) (velX + (HUD.level));
		this.velY = (float) (velY + (HUD.level));
		
		if(this.velX >= MaxSpeed || this.velY >= MaxSpeed)
		{
			this.velX = MaxSpeed;
			this.velY = MaxSpeed;
		}
		
		this.handler = handler;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,16,16);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
	
		
		//if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		//if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		handler.addObject(new Trail((int)x, (int)y, Color.red, 16, 16, 0.02, handler, ID.Trail));
	}

	@Override
	public void render(Graphics g) {
		
		//Graphics2D g2d = (Graphics2D) g;
		
		//g.setColor(Color.green);
		//g2d.draw(getBounds());
		
		g.setColor(Color.MAGENTA);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

}
