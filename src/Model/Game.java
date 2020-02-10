package Model;

import java.awt.Point;

public class Game {

	
	private HumanPlayer player;
	private Computer cpu;
	private Countdown timer;
	private PlayerState pState;
	
	
	public Game (Boolean hard, int time) {
		
		player = new HumanPlayer();
		pState = PlayerState.DEFAULT;

		if(hard)
			cpu = new SmartComputer();
		else
			cpu = new Computer();
		
		timer= new Countdown(time);
		/*start timer*/
	}
	
	
	public MoveResult playerMove(int x, int y) {
		
		player.hitOppGrid(x, y);
		cpu.hitOwnGrid(x, y);
		
		if(cpu.isShipOnCell(x, y)) {
			ShipState s = cpu.hitShip(x, y);
			
			if(cpu.getShipsAlive()==0)
				pState=PlayerState.VITTORIA;
			
			if(s.equals(ShipState.AFFONDATA))
				return MoveResult.AFFONDATA;
			else
				return MoveResult.COLPITA;
		}
		
		else
			return MoveResult.MANCATA;
		
	}
	
	public MoveResult  cpuMove() {
		
		Point p = cpu.declareCoord();
		
		cpu.hitOppGrid(p.x, p.y);
		player.hitOwnGrid(p.x, p.y);
		
		if(player.isShipOnCell(p.x, p.y)) {
			ShipState s = player.hitShip(p.x, p.y);
			
			if(cpu instanceof SmartComputer) {
				if(((SmartComputer) cpu).getState().equals(SmartComputerState.SEEK))
					((SmartComputer) cpu).setState(SmartComputerState.DESTROY);
				((SmartComputer) cpu).getHitCells().add(p);
			}
				
			if(player.getShipsAlive()==0)
				pState=PlayerState.SCONFITTA;
			
			if(s.equals(ShipState.AFFONDATA))
				return MoveResult.AFFONDATA;
			else
				return MoveResult.COLPITA;
		}
		
		else
			return MoveResult.MANCATA;
		
	}


	public HumanPlayer getPlayer() {
		return player;
	}


	public Computer getCpu() {
		return cpu;
	}


	public Countdown getTimer() {
		return timer;
	}


	public PlayerState getpState() {
		return pState;
	}
	
	
	
}
