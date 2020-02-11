package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SmartComputer extends Computer{
	
	private SmartComputerState state;
	private LinkedList<Point> destroyTargets;
	private MoveResult LastMove;
	
	
	public SmartComputer() {
		super();
		state=SmartComputerState.SEEK;
		LastMove=null;
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
			
			int index = randomCell();
			Point p = getSeekTargets().get(index);
			getSeekTargets().remove(index);
			
			return new Point(p.x,p.y);
		}
		
		else {
			
			if(LastMove.getMoveResultType().equals(MoveResultType.COLPITO)) {
				for(Point p : crossBoundary(LastMove.Coord)) {
					if(getOppGrid().getCells()[p.x][p.y].getState().equals(OppGridCellState.COLPITO)) {
						for(Point d : destroyTargets) {
							if(d.x == p.x || d.y == p.y) {
								destroyTargets.remove(d);
								if(SeekTargets.contains(d))
									SeekTargets.remove(d);
								return d;
							}
							
							//NON CI SONO CELLE IN DESTROY TARGET CON STESSA ASC/ORD DI UNA CELLA DEI DINTORNI DI LAST MOVE
						}
					}
					
					//NEI DINTORNI DELL'ULTIMA MOSSA NON CI SONO COLPITI
				}
			}
			
			//ULTIMO BERSAGLIO NON COLPITO
				
		}
	}

	public List<Point> crossBoundary(Point p){
		List<Point> out = new ArrayList<Point>();
		
		if(p.x ==0) 
			out.add(new Point(1,p.y));
		
		if(p.y ==0) 
			out.add(new Point(p.x,1));
		
		if(p.x == Grid.DIM-1) 
			out.add(new Point(Grid.DIM-2,p.y));
		
		if(p.y == Grid.DIM-1) 
			out.add(new Point(p.x,Grid.DIM-2));
		
		if(p.x!= 0 && p.x!= Grid.DIM-1) {
			out.add(new Point(p.x-1,p.y));
			out.add(new Point(p.x+1,p.y));
		}
		
		if(p.y!= 0 && p.y!= Grid.DIM-1) {
			out.add(new Point(p.x,p.y-1));
			out.add(new Point(p.x,p.y+1));
		}
			
		return out;
	}

	public SmartComputerState getState() {
		return state;
	}


	public void setState(SmartComputerState state) {
		this.state = state;
	}


	public LinkedList<Point> getDestroyTargets() {
		return destroyTargets;
	}


	public MoveResult getLastMove() {
		return LastMove;
	}


	public void setLastMove(MoveResult lastMove) {
		LastMove = lastMove;
	}
	
	
	
}
