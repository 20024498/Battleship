package model;

import java.io.Serializable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 
 * 
 * @author Gili_Patera
 *
 */
@SuppressWarnings("serial")
public class Countdown implements Serializable{
	
	private int time;
	
	public Countdown(int playerTime) {
		
		time = playerTime*60;
	}
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}

