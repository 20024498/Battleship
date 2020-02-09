package Model;

import java.awt.Point;

public class Game {

	
	private HumanPlayer player;
	private Computer cpu;
	private Countdown timer;
	
	public Game (Boolean hard) {
		
		timer= new Countdown();
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
			cpu.setHit(p.x, p.y);
		}
		
	}
	
	public void cpuMove() {
		Point p;
		do {
			p = cpu.declareCoord();
		} while(cpu.getOppGrid().isHit(p.x, p.y));
		 
		cpu.getOppGrid().hit(p.x, p.y);
		player.getMyGrid().hit(p.x, p.y);
		if(player.hasHit(p.x, p.y)) {
			player.setHit(p.x, p.y);
		}
		
	}
	
	
}
