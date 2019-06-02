package MainGame;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

//이 클래스를 활용해서 알파값을 줄여가며 잔상을 만든다
public class Trail extends GameObject{

	private float alpha = 1;
	private Handler handler;
	private Color color;
	
	private int width,height;
	private double life;
	
	//life = 0.01 - 0.1
	
	public Trail(int x, int y, Color color, int width, int height, double life,Handler handler, ID id) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
	}

	@Override
	public void tick() {
		
		if(alpha > life){
			alpha -= (life - 0.0001f);
		}
		else handler.removeObject(this);
		
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect((int)x, (int)y, width, height); 
		
		g2d.setComposite(makeTransparent(1));
	}
	
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
	}

	@Override
	public Rectangle getBounds() {
		
		return null;
	}
	

}
