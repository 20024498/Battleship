package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public class SmartComputer extends Computer{
	
	private static final long serialVersionUID = 1L;
	private SmartComputerState state;
	private LinkedList<Point> destroyTargets;
	
	/**
	 * Il costruttore SmartComputer() si riferisce alla superclasse
	 *  tramite l'operatore super. Inoltre inizializza il valore dei campi
	 *  state allo stato SEEK, crea l'oggetto destroyTarget ed in più riempie
	 *  la lista dei target
	 * 
	 */
	public SmartComputer() {
		super();
		state=SmartComputerState.SEEK;
		destroyTargets = new LinkedList<Point>();
		initTargets();
	}
	
	
	@Override
	protected void initTargets () {
		SeekTargets = new ArrayList<Point>();
		for(int i=0; i<Grid.DIM;i++)
			for(int j=0; j<Grid.DIM;j++)
				if((i+j)%2==0)
					getSeekTargets().add(new Point(i,j));
	}
	
	@Override
	public Point declareCoord() {
		
		if(state.equals(SmartComputerState.SEEK)) {
			
			int index = randomCell(SeekTargets.size());
			Point p = getSeekTargets().get(index);
			getSeekTargets().remove(index);
			
			return new Point(p.x,p.y);
		}
		
		else {
			
			Point p = destroyTargets.pop();
			
			if(destroyTargets.isEmpty())
				setState(SmartComputerState.SEEK);
							
			if(SeekTargets.contains(p))
				SeekTargets.remove(p);
			
			return p;		
				
		}
	}

	/**
	 * Questa funzione controlla che non vengano sforati i confini
	 * della mappa
	 * 
	 * @param p
	 * @return out
	 */
	public List<Point> crossBoundary(Point p){
		List<Point> temp = new ArrayList<Point>();
		List<Point> out = new ArrayList<Point>();
		
		if(p.x ==0) 
			temp.add(new Point(1,p.y));
		
		if(p.y ==0) 
			temp.add(new Point(p.x,1));
		
		if(p.x == Grid.DIM-1) 
			temp.add(new Point(Grid.DIM-2,p.y));
		
		if(p.y == Grid.DIM-1) 
			temp.add(new Point(p.x,Grid.DIM-2));
		
		if(p.x!= 0 && p.x!= Grid.DIM-1) {
			temp.add(new Point(p.x-1,p.y));
			temp.add(new Point(p.x+1,p.y));
		}
		
		if(p.y!= 0 && p.y!= Grid.DIM-1) {
			temp.add(new Point(p.x,p.y-1));
			temp.add(new Point(p.x,p.y+1));
		}
		
		for(Point t : temp)
			if(!getOppGrid().getCells()[t.x][t.y].isHit())
				out.add(t);
			
		return out;
	}

	/**
	 * Questa funzione ritorna il campo state
	 * 
	 * @return state
	 */
	public SmartComputerState getState() {
		return state;
	} 

	/**
	 * Questa funzione imposta il capo stato al valore 
	 * in input alla funzione
	 * 
	 * @param state
	 */
	public void setState(SmartComputerState state) {
		this.state = state;
	}

	/**
	 * Questa funzione serve a ritornare il campo destroyTargets
	 * 
	 * @return destroyTargets
	 */
	public LinkedList<Point> getDestroyTargets() {
		return destroyTargets;
	}	
}
