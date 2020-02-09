package Model;

import java.awt.Point;

public class Game {

	
	private HumanPlayer player;
	private Computer cpu;
	private Timer timer;
	
	public Game (Boolean hard) {
		
		timer= new Timer();
		player = new HumanPlayer();

		if(hard)
			cpu = new SmartComputer();
		else
			cpu = new Computer();
	}
	
	public void playerMove() {
		Point p;
		do {
			p = player.declareCoord();
		} while(player.getOppGrid().isHit(p.x, p.y));
		 
		player.getOppGrid().hit(p.x, p.y);
		cpu.getMyGrid().hit(p.x, p.y);
		if(cpu.hasHit(p.x, p.y)) {
			//cpu.
		}
		
	}
	
	public void cpuMove() {}
	
	
}
