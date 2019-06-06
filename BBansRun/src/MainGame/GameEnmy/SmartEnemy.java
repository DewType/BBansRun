package MainGame.GameEnmy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import MainGame.GameObject;
import MainGame.InGameUi;
import MainGame.ObjectManager;
import MainGame.ID;
import MainGame.MyUtility;
import MainGame.Trail;

public class SmartEnemy extends GameObject{
	
	private ObjectManager handler;
	private GameObject player;
	
	private int greenAlpha = 255;
	private boolean alpha = false;
	
	public SmartEnemy(float x, float y, ID id, ObjectManager handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		for(int i=0;i<handler.object.size();i++)
		{
			if(handler.object.get(i).getId() == ID.Player)
			{
				player = handler.object.get(i);
			}
		}
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,16,16);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;	
		 
		float distance = MyUtility.distance(x, y, player.getX(), player.getY());
		
		velX = (float) ((-1.0/distance) * diffX);
		velY = (float) ((-1.0/distance) * diffY);
		
		if(greenAlpha >= 255)
			alpha = true;
		else if(greenAlpha <= 0)
			alpha = false;
		
		if(alpha)
			greenAlpha--;
		else
			greenAlpha++;
		
		
		handler.addObject(new Trail((int)x, (int)y, new Color(0, 255, 0, greenAlpha), 16, 16, 0.02, handler, ID.Trail));
	}

	@Override
	public void render(Graphics g) {
		
		//Graphics2D g2d = (Graphics2D) g;
		
		//g.setColor(Color.green);
		//g2d.draw(getBounds());
		
		
		g.setColor(new Color(0, 255, 0, greenAlpha));
		
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

}
