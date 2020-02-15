package model;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Observable;

/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public class Game extends Observable implements Serializable  {

	private static final long serialVersionUID = 1L;
	private HumanPlayer player;
	private Computer cpu;
	private Countdown timer;
	private Difficulty diff;
	private GameState gstate;
	
	/**
	 * Il costruttore setta a null tutti i campi della classe
	 * 
	 */
	public Game() {
		player = null;;
		cpu = null;
		timer = null;
		diff = null;
		gstate=null;
	}
	
	/**
	 * Questa funzione, che prende in input i parametri
	 * diff e time, inizializza il giocatore, un
	 * avversario in base alla difficolt� ed un timer
	 * 
	 * @param diff
	 * @param time
	 */
	public Game (Difficulty diff, int time) {
		
		player = new HumanPlayer();
		gstate= GameState.DEFAULT;
		if(diff.equals(Difficulty.FACILE))
			cpu = new Computer();
		else if(diff.equals(Difficulty.MEDIA))
			cpu = new SmartComputer();
		
		cpu.autoPosition();
		
		//timer= new Countdown(time);
		/*start timer*/
	}
	
	/**
	 * Questa funzione, dati i parametri x ed y, in input
	 * dir� il risultato della mossa del giocatore
	 * 
	 * @param x
	 * @param y
	 * @return il tipo di return � MoveResul 
	 */
	public MoveResult playerMove(int x, int y) {
		
		player.hitOppGrid(x, y);
		cpu.hitOwnGrid(x, y);
		
		if(cpu.isShipOnCell(x, y)) {
			ShipState s = cpu.hitOwnShip(x, y);
			
			
			
			if(s.equals(ShipState.AFFONDATA)) {
				if(cpu.getShipsAlive()==0)
					setGameState(GameState.VITTORIA);
				
				for(ShipCell c : cpu.getShips().get(new Point(x,y)).getCells().values())
					player.getOppGrid().getCells()[c.x][c.y].setState(OppGridCellState.AFFONDATO);
				
				return new MoveResult(MoveResultType.AFFONDATO, new Point(x,y),cpu.getShips().get(new Point(x,y)).getType(),Turn.PLAYER);
			}
			
			else {
				player.getOppGrid().getCells()[x][y].setState(OppGridCellState.COLPITO);
				return new MoveResult(MoveResultType.COLPITO, new Point(x,y),Turn.PLAYER);
			}	
		}
		
		
		else {
			player.getOppGrid().getCells()[x][y].setState(OppGridCellState.MANCATO);
			return new MoveResult(MoveResultType.MANCATO, new Point(x,y),Turn.PLAYER);
			
		}
		
	}
	
	/**
	 * Questa funzione, dati i parametri x ed y, in input
	 * dir� il risultato della mossa del giocatore computer
	 * 
	 * @return il return � di tipo MoveResult
	 */
	public MoveResult cpuMove() {
		
		Point p = cpu.declareCoord();
		
		
		
		cpu.hitOppGrid(p.x, p.y);
		player.hitOwnGrid(p.x, p.y);
		
		if(player.isShipOnCell(p.x, p.y)) {
			ShipState s = player.hitOwnShip(p.x, p.y);
			
			if(s.equals(ShipState.AFFONDATA)) {
				if(player.getShipsAlive()==0)
					setGameState(GameState.SCONFITTA);
				for(ShipCell c : player.getShips().get(new Point(p.x,p.y)).getCells().values())
					cpu.getOppGrid().getCells()[c.x][c.y].setState(OppGridCellState.AFFONDATO);
				
				
				return new MoveResult(MoveResultType.AFFONDATO, new Point(p.x,p.y),cpu.getShips().get(new Point(p.x,p.y)).getType(),Turn.CPU);
			}
			
			else {
				cpu.getOppGrid().getCells()[p.x][p.y].setState(OppGridCellState.COLPITO);
				
				
				if(cpu instanceof SmartComputer) {
					((SmartComputer) cpu).setState(SmartComputerState.DESTROY);
					((SmartComputer) cpu).getDestroyTargets().addAll(((SmartComputer) cpu).crossBoundary(p));
				}
				
				return new MoveResult(MoveResultType.COLPITO, new Point(p.x,p.y),Turn.CPU);
			}	
		}
		
		
		else {
			cpu.getOppGrid().getCells()[p.x][p.y].setState(OppGridCellState.MANCATO);
			return new MoveResult(MoveResultType.MANCATO, new Point(p.x,p.y),Turn.CPU);
			
		}
		
	}
	
	public boolean playerPosition(Point p) {
		
		return player.humanShipPosition(p);
	}
	
	public void cpuPosition() {
		cpu.autoPosition();
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

	public void save(File file) throws IOException {
		   
            
            FileOutputStream fileStream = new FileOutputStream(file); 
            ObjectOutputStream out = new ObjectOutputStream(fileStream); 
              
            out.writeObject(this); 
              
            out.close(); 
            fileStream.close(); 
              
            
  
		
	}

	public Game load(File file) throws IOException, ClassNotFoundException  {
		
		Game game = null;
		       
		FileInputStream fileStream = new FileInputStream(file); 
	    ObjectInputStream in = new ObjectInputStream(fileStream); 
	                 
	    game = (Game)in.readObject(); 
	              
	    in.close(); 
	    fileStream.close(); 
	              
		return game;
	  
	}


	public GameState getGameState() {
		return gstate;
	}

	public void setGameState(GameState gstate) {
		this.gstate = gstate;
		setChanged();
	    notifyObservers();
	}
	
	
	
}
