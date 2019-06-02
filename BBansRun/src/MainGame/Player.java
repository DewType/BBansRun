package MainGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player extends GameObject {

	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,32,32);
	}
	
	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		x =  MyUtility.clamp((int)x, 0, Game.WIDTH - 48);
		y =  MyUtility.clamp((int)y, 0, Game.HEIGHT - 64);
		
		
		collision();
	}
	
	//충돌했을때 
	private void collision()
	{
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy ||
			   tempObject.getId() == ID.FestEnemy ||
			   tempObject.getId() == ID.SmartEnemy ||
			   tempObject.getId() == ID.StraightEnemy)
			{
				//만약 플레이어의 범위(바운스)와 아이디가 에너미인 렉트의 바운스가 인터셉트(겹쳐지다)했다면
				if(getBounds().intersects(tempObject.getBounds()))	
				{
					HUD.HEALTH -= 2;		//HEATH는 public static으로 만들어둬서 접근가능
				}
			}
				
		}
	}

	@Override
	public void render(Graphics g) {
		//Graphics2D g2d = (Graphics2D) g;
		//g.setColor(Color.red);
		//g2d.draw(getBounds());
		
		
		if(id == ID.Player)g.setColor(Color.white);
		g.fillRect((int)x,(int)y,32,32);
		
		//g.fillRoundRect((int)x, (int)y, 32, 32, 50, 50);	//원 그리기
	}

	
}
