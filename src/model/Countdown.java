package model;

import java.io.Serializable;

/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public class Countdown implements Serializable{
	
	private static final long serialVersionUID = 1L;
	int time;
	
	public Countdown(int playerTime){
		
		time = playerTime*60;
	}

	public void updateTime() {
		if(time > 0) 
			time--;			
	}	

	public int getSec() {
		return time;
	}

	public void setSec(int sec) {
		this.time = sec;
	}
	
	@Override
	public String toString() {
		int sec = time%60;
		int min = time/60;
		String s = null;
		
		if(min < 10 && sec < 10)
			s = String.format("0%d : 0%d", min, sec);
		else if(min >= 10 && sec >= 10)
			s = String.format("%d : %d", min, sec);
		else if(min >= 10 && sec < 10)
			s = String.format("%d : 0%d", min, sec);
		else if(min < 10 && sec >= 10)
			s = String.format("0%d : %d", min, sec);
		
		return s;
	}	
}


