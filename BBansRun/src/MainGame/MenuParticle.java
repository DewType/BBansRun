package MainGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject{
	
	private Handler handler;
	Random r = new Random();
	
	private Color col;
	

	
	public MenuParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = r.nextInt(5 - -5) + -5;
		velY = r.nextInt(5 - -5) + -5;
		if(velX == 0) velX = 1;
		if(velY == 0) velY = 1;
		
		col = new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255),150);
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,16,16);
	}

	@Override
	public void tick() {
		
		for(int i = 0;i < 10; i++)
		handler.addObject(new Trail(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),
				col, 16, 16, 0.02, handler, ID.Trail));
	}

	@Override
	public void render(Graphics g) {
		
		//Graphics2D g2d = (Graphics2D) g;
		
		//g.setColor(Color.green);
		//g2d.draw(getBounds());
		
		g.setColor(col);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

}
