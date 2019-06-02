package MainGame;

import java.awt.Graphics;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import MainGame.Game.STATE;
import MainGame.GameEnmy.BasicEnemy;
import MainGame.GameEnmy.FestEnemy;
import MainGame.GameEnmy.SmartEnemy;
import MainGame.GameEnmy.StraightEnemy;

//스폰(적 또는 아이템등이 나타나는것)에 관련된 클래스
public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	private Timer Timer = new Timer();
	
	private int scoreKeep = 0;
	
	public int wave = 1;
	
	public Spawn(Handler handler, HUD hud)
	{
		this.handler = handler;
		this.hud = hud;
		
		if(Game.gameState == STATE.Game)
		{
			this.handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32,
					ID.Player, handler));
			this.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),
					ID.BasicEnemy,handler));
			this.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),
					ID.BasicEnemy,handler));
			this.handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),
					ID.BasicEnemy,handler));
		}
	}
	
	public void render(Graphics g)		//나중에 지우기
	{
		//g.drawString("wave : " + wave, 15, 96);
	}
	
	public void tick()
	{
		scoreKeep++;
		
		if(scoreKeep >= 500)
		{
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			if(hud.getLevel() == 2)
			{
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),
						ID.BasicEnemy,handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),
						ID.BasicEnemy,handler));
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),
						ID.BasicEnemy,handler));
				handler.addObject(new FestEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),
						ID.FestEnemy,handler));
				handler.addObject(new FestEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),
						ID.FestEnemy,handler));
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),
						ID.SmartEnemy,handler));
			}
			else if(hud.getLevel() == 3)
			{
				handler.clearEnemys();
				
				StraightE(14,7,13,false);			//가로 
				
				TimerTask timerTask = new TimerTask() {
					public void run() {
						StraightE(10,5,9,true);		//세로
					}};
				TimerTask timerTask2 = new TimerTask() {
					public void run() {
						StraightE(14,7,13,false);	//가로
					}};
				TimerTask timerTask3 = new TimerTask() {
					public void run() {
						StraightE(10,5,9,true);		//세로
					}};
				Timer.schedule(timerTask, 1000);
				Timer.schedule(timerTask2, 2000);
				Timer.schedule(timerTask3, 3000);
			}
			else if(hud.getLevel() == 1)
			{
				//handler.clearEnemys();
				//handler.addObject(new EnemyBoss((Game.WIDTH / 2) - 48,-120,
				//		ID.EnemyBoss,handler));
				
			}
		}
	}
	
	public void StraightE(int num, int ranMin, int ranMax, boolean VorH) {
		//객체배열로 스트레이트 에너미를 생성후 렌덤으로 하나를 골라서 지워주는 것으로 돌파구를 만들어준다.
			StraightEnemy straight [] = new StraightEnemy[num];
			
			int temp = 0;
			
			for(int i = -1; i < straight.length; i++)
			{
				if(i == -1){
					temp = MyUtility.RandomTo(ranMin, ranMax);
					continue;
				}
				else {
					//에너미 생성
					if(VorH == true)		//가로에너미
						straight[i] = new StraightEnemy(0,(i * 50) - 50, 3, -HUD.level,
							ID.StraightEnemy,handler);
					else if(VorH == false)	//세로에너미
						straight[i] = new StraightEnemy((i * 50) - 50, 0, -HUD.level, 3,
							ID.StraightEnemy,handler);
					
					handler.addObject(straight[i]);
					
					//렌덤값과 i가 같거나 화면끝에 다다랐을 경우 에너미를 삭제 
					if(i == temp)
						handler.removeObject(straight[i]);
				}
			}
		}
}
