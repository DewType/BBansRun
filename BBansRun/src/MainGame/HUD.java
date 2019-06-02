package MainGame;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	public int bounds = 0;
	public static int HEALTH = 100;
	
	public int greenValue = 100;
	
	private int score = 0;
	public static int level = 1;
	
	public void tick()
	{
		HEALTH = (int) MyUtility.clamp(HEALTH, 0, 100 + bounds /2);
		
		greenValue = (int) MyUtility.clamp(greenValue, 0, 255);
		
		greenValue = (HEALTH * 2) + 55;
		
		score++;
	}
	
	public void render(Graphics g)
	{
		g.setColor(new Color(128, 128, 128,155));			//체력바 테두리
		g.fillRect(15, 15, 200 + bounds, 32);
		
		g.setColor(new Color(100, greenValue, 0, 155));		//체력바
		g.fillRect(15, 15, HEALTH * 2, 32);
		
		g.setColor(new Color(255, 255, 255,155));			//플레이어
		g.drawRect(15, 15, 200 + bounds, 32);
		
		g.drawString("Score : " + score, 15, 64);
		g.drawString("Level : " + level, 15, 80);
		g.drawString("스페이스바로 상점 이동", 20, 96);
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
