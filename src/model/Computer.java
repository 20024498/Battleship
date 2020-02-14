package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public class Computer extends Player{
	
	private static final long serialVersionUID = 1L;
	protected ArrayList<Point> SeekTargets;
	
	/**
	 * Il costrutttore Computer() si riferisce alla superclasse
	 * con l'operatore super. Inoltre, usa la funzione initTargets()
	 * che consente di trovare una nave bersaglio da affondare sulla
	 * mappa
	 * 
	 */
	public Computer() {
		super();
		initTargets();
	}
	
	/**
	 * Questo metodo inizializza i target di un giocatore
	 * 
	 */
	protected void initTargets () {
		SeekTargets = new ArrayList<Point>();
		for(int i=0; i<Grid.DIM;i++)
			for(int j=0; j<Grid.DIM;j++)
				SeekTargets.add(new Point(i,j));
	}

	/**
	 * Questo metodo serve a poszionare le navi per il Player
	 * Computer in modo automatico
	 * 
	 */
	public void autoPosition() {
		 
		while(!getShipHouse().isEmpty()) {
			 
			Ship s = getShipHouse().pop();
			int x; 
			int y; 
			int l; 
			ShipOrientation o;
			
			do {
				
				x = randomCell(Grid.DIM);
				y = randomCell(Grid.DIM);
				l = s.getLength();
				if(randomCell(2)==0)
					o=ShipOrientation.ORIZZONTALE;
				else
					o=ShipOrientation.VERTICALE;
				
			}while(!lecitPosition(l, o, x, y));
			
			shipPositioning(s, o, x, y);
					
		 }
			 
	}
	
	/**
	 * Questo metodo serve a dichiarare le coordinate da colpire
	 * 
	 * @return new Point(p.x,p.y)
	 */
	public Point declareCoord() {
		
		int index = randomCell(SeekTargets.size());
		Point p = SeekTargets.get(index);
		SeekTargets.remove(index);
		
		return new Point(p.x,p.y);
		
	}
	/**
	 * Questo metodo serve a generare un cella randomicamente
	 * 
	 * @param size
	 * @return rand.nextInt(size)
	 */
	protected int randomCell(int size) {
		Random rand = new Random();
		return rand.nextInt(size);
	}

	/**
	 * Questo metodo serve ad ottenere il campo SeekTargets
	 * 
	 * @return SeekTargets
	 */
	public ArrayList<Point> getSeekTargets() {
		return SeekTargets;
	}
}
