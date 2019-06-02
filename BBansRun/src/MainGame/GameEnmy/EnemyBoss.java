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

public class EnemyBoss extends GameObject{
	
	private Handler handler;
	Random r = new Random();
	
	private int timer = 80; 
	private int timer2 = 50;

	
	public EnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velX = 0;
		velY = 2;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,96,96);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if(timer <= 0)
			velY = 0;
		else
			timer--;
		
		if(timer <= 0 )
			timer2--;
		if(timer2 <= 0)
		{
			if(velX == 0) 
				velX = 2;
			
			if(velX > 0) 
				velX += 0.005f;		//점점 더 빠르게 가로로 왔다갔다
			else if(velX < 0) 
				velX -= 0.005f;		
				
			velX = MainGame.MyUtility.clamp((int)velX, -10, 10);
			
			int spawn = r.nextInt(10);
			if(spawn == 0) 
				handler.addObject(new EnemyBossBullet((int)x + 48, (int)y + 48, ID.BasicEnemy, handler));
		}
		
		//if(y <= 0 || y >= Game.HEIGHT - 96) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 96) velX *= -1;
		
		//handler.addObject(new Trail((int)x, (int)y, Color.red, 96, 96, 0.02, handler, ID.Trail));
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 96, 96);
		
	}

}
