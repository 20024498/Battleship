package model;

import java.awt.Point;

/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public class Game {

	
	private HumanPlayer player;
	private Computer cpu;
	private Countdown timer;
	private Difficulty diff;
	
	/**
	 * Il costruttore setta a null tutti i campi della classe
	 * 
	 */
	public Game() {
		player = null;;
		cpu = null;
		timer = null;
		diff = null;
	}
	
	/**
	 * Questa funzione, che prende in input i parametri
	 * diff e time, inizializza il giocatore, un
	 * avversario in base alla difficoltà ed un timer
	 * 
	 * @param diff
	 * @param time
	 */
	public Game (Difficulty diff, int time) {
		
		player = new HumanPlayer();

		if(diff.equals(Difficulty.FACILE))
			cpu = new Computer();
		else if(diff.equals(Difficulty.MEDIA))
			cpu = new SmartComputer();
		
		timer= new Countdown(time);
		/*start timer*/
	}
	
	/**
	 * Questa funzione, dati i parametri x ed y, in input
	 * dirà il risultato della mossa del giocatore
	 * 
	 * @param x
	 * @param y
	 * @return il tipo di return è MoveResul 
	 */
	public MoveResult playerMove(int x, int y) {
		
		player.hitOppGrid(x, y);
		cpu.hitOwnGrid(x, y);
		
		if(cpu.isShipOnCell(x, y)) {
			ShipState s = cpu.hitOwnShip(x, y);
			
			
			
			if(s.equals(ShipState.AFFONDATA)) {
				if(cpu.getShipsAlive()==0)
					player.setpState(PlayerState.VITTORIA);
				
				for(ShipCell c : cpu.getShips().get(new Point(x,y)).getCells().values())
					player.getOppGrid().getCells()[c.x][c.y].setState(OppGridCellState.AFFONDATO);
				
				return new MoveResult(MoveResultType.AFFONDATO, new Point(x,y),cpu.getShips().get(new Point(x,y)).getType());
			}
			
			else {
				player.getOppGrid().getCells()[x][y].setState(OppGridCellState.COLPITO);
				return new MoveResult(MoveResultType.COLPITO, new Point(x,y));
			}	
		}
		
		
		else {
			player.getOppGrid().getCells()[x][y].setState(OppGridCellState.MANCATO);
			return new MoveResult(MoveResultType.MANCATO, new Point(x,y));
			
		}
		
	}
	
	/**
	 * Questa funzione, dati i parametri x ed y, in input
	 * dirà il risultato della mossa del giocatore computer
	 * 
	 * @return il return è di tipo MoveResult
	 */
	public MoveResult cpuMove() {
		
		Point p = cpu.declareCoord();
		
		cpu.hitOppGrid(p.x, p.y);
		player.hitOwnGrid(p.x, p.y);
		
		if(player.isShipOnCell(p.x, p.y)) {
			ShipState s = player.hitOwnShip(p.x, p.y);
			
			if(s.equals(ShipState.AFFONDATA)) {
				if(player.getShipsAlive()==0)
					player.setpState(PlayerState.SCONFITTA);
				for(ShipCell c : player.getShips().get(new Point(p.x,p.y)).getCells().values())
					cpu.getOppGrid().getCells()[c.x][c.y].setState(OppGridCellState.AFFONDATO);
				
				
				return new MoveResult(MoveResultType.AFFONDATO, new Point(p.x,p.y),cpu.getShips().get(new Point(p.x,p.y)).getType());
			}
			
			else {
				cpu.getOppGrid().getCells()[p.x][p.y].setState(OppGridCellState.COLPITO);
				
				
				if(cpu instanceof SmartComputer) {
					((SmartComputer) cpu).setState(SmartComputerState.DESTROY);
					for(Point t : ((SmartComputer) cpu).crossBoundary(p))
						if(!cpu.getOppGrid().getCells()[t.x][t.y].isHit())
							((SmartComputer) cpu).getDestroyTargets().add(t);
				}
				
				return new MoveResult(MoveResultType.COLPITO, new Point(p.x,p.y));
			}	
		}
		
		
		else {
			cpu.getOppGrid().getCells()[p.x][p.y].setState(OppGridCellState.MANCATO);
			return new MoveResult(MoveResultType.MANCATO, new Point(p.x,p.y));
			
		}
		
	}
	

	/**
	 * Questa funzione restituisce il campo player
	 * 
	 * @return player
	 */
	public HumanPlayer getPlayer() {
		return player;
	}

	/**
	 * Questa funzione restituisce il campo cpu
	 * 
	 * @return cpu
	 */
	public Computer getCpu() {
		return cpu;
	}

	/**
	 * Questa funzione restituisce il campo timer
	 * 
	 * @return timer
	 */
	public Countdown getTimer() {
		return timer;
	}

	/**
	 * Questa funzione restituisce il campo diff
	 * 
	 * @return diff
	 */
	public Difficulty getDiff() {
		return diff;
	}

	public void save() {
		// TODO Auto-generated method stub
		
	}

	public Game load() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
