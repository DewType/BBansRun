package MainGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import MainGame.Game.STATE;

public class KeyInput extends KeyAdapter {
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler handler)
	{
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		for(int i =0; i< handler.object.size(); i++)		//핸들러가 만든 모든 오브젝트가 실행되도록하는것
		{
			GameObject tempObject = handler.object.get(i);	//핸들러가 만든 모든 오브젝트가 실행되도록하는것
			
			if(tempObject.getId() == ID.Player)
			{
				//플레이어1을 위한 키이벤트
				if(key == KeyEvent.VK_W)
					{tempObject.setVelY(-handler.speed); keyDown[0]=true;}
				if(key == KeyEvent.VK_S)
					{tempObject.setVelY(handler.speed); keyDown[1]=true;}
				if(key == KeyEvent.VK_D)
					{tempObject.setVelX(handler.speed); keyDown[2]=true;}
				if(key == KeyEvent.VK_A)
					{tempObject.setVelX(-handler.speed); keyDown[3]=true;}
			}
			
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1); //esc로 종료
		
		if(key == KeyEvent.VK_SPACE) {
			if(Game.gameState == STATE.Game)
				Game.gameState = STATE.Shop;
			else if(Game.gameState == STATE.Shop)
				Game.gameState = STATE.Game;
		}
		
	}
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		for(int i = 0; i< handler.object.size(); i++)		//핸들러가 만든 모든 오브젝트가 실행되도록하는것
		{
			GameObject tempObject = handler.object.get(i);	//핸들러가 만든 모든 오브젝트가 실행되도록하는것
			
			if(tempObject.getId() == ID.Player)
			{
				//플레이어1을 위한 키이벤트
				if(key == KeyEvent.VK_W)
					keyDown[0] =false;
				if(key == KeyEvent.VK_S)
					keyDown[1] =false;
				if(key == KeyEvent.VK_D)
					keyDown[2] =false;
				if(key == KeyEvent.VK_A)
					keyDown[3] =false;
				
				//수직 움직임
				if(!keyDown[0] && !keyDown[1])
					tempObject.setVelY(0);
				//수평 움직임
				if(!keyDown[2] && !keyDown[3])
					tempObject.setVelX(0);
			}
			
		}
	}
}
