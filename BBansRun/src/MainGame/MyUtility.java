package MainGame;

import java.util.Random;

public class MyUtility {
	static Random rand = new Random();
	
	//렉트가 max, min으로 설정한 수치를 넘기지 않도록 고정하는 메소드
	//(안쪽 렉트가 테두리 렉트 바깥으로 삐져나가지 않도록)
	public static float clamp(int var, int min, int max) 
	{
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		
		return var;
	}
	
	//min ~ max 까지의 렌덤 숫자
	public static int RandomTo(int min,int max)
	{
		int randomNum = rand.nextInt(max - min + 1) + min;
		
		return randomNum;
	}
	
	//두 점 사이에 거리
	public static int distance(int start_X, int start_Y, int destination_X, int destination_Y)
	{
		float distance = (float) Math.sqrt((start_X - destination_X)*(start_X - destination_X) + 
				(start_Y - destination_Y)*(start_Y - destination_Y));
		
		return (int) distance;
	}
	
	public static float distance(float start_X, float start_Y, float destination_X, float destination_Y)
	{
		float distance = (float) Math.sqrt((start_X - destination_X)*(start_X - destination_X) + 
				(start_Y - destination_Y)*(start_Y - destination_Y));
		
		return distance;
	}
}
