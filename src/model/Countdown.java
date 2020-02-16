package model;
/**
 * 
 * 
 * @author Gili_Patera
 *
 */
import java.util.Observable;

public class Countdown {
	
	int time;
	
	public Countdown(int playerTime){
		
		time = playerTime*60;
		
		
//		timer.scheduleAtFixedRate(new Runnable()  {
//
//			private boolean thereIsTime = true;
//
//			@Override
//			public void run() {
//			
//				while(thereIsTime) {
//					
//					if(playerTime >= 0) {
//						
//						if(sec == 0) {
//							sec= 59;
//							min--;
//						}
//						else
//							sec--;
//						
//						if(min == 0 && sec == 0)
//							thereIsTime = false;
//					}
//				}
//			}
//			
//		}, 0, playerTime*60, TimeUnit.SECONDS);
	}

	public void updateTime() {
		if(time > 0) {
			
			time--;
				
	}
		
		
	
//	public int getpTime() {
//		return pTime;
//	}
//
//	public void setpTime(int pTime) {
//		this.pTime = pTime;
//	}
	
//	public String toStringTime() {
//		
//		String s = null;
//		
//		if(min < 10 && sec < 10)
//			s = String.format("0%d : 0%d", min, sec);
//		else if(min >= 10 && sec >= 10)
//			s = String.format("%d : %d", min, sec);
//		else if(min >= 10 && sec < 10)
//			s = String.format("%d : 0%d", min, sec);
//		else if(min < 10 && sec >= 10)
//			s = String.format("0%d : %d", min, sec);
//		
//		return s;
//	}
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


