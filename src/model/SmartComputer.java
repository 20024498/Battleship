package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmartComputer extends Computer{
	
	private SmartComputerState state;
	private LinkedList<Point> HitCells;
	
	public SmartComputer() {
		super();
		possibleTargets= new ArrayList<Point>();
		state=SmartComputerState.SEEK;
		HitCells = new LinkedList<Point>();
		initTargets();
	}
	
	
	@Override
	protected void initTargets () {
		for(int i=0; i<Grid.getDim();i++)
			for(int j=0; j<Grid.getDim();j++)
				if((i+j)%2==0)
					getPossibleTargets().add(new Point(i,j));
	}
	
	@Override
	public Point declareCoord() {
		
		if(state.equals(SmartComputerState.SEEK)) {
			
			int index = randomCell();
			Point p = getPossibleTargets().get(index);
			getPossibleTargets().remove(index);
			
			return new Point(p.x,p.y);
		}
		
		else {
			
			
		}
	}


	public SmartComputerState getState() {
		return state;
	}


	public void setState(SmartComputerState state) {
		this.state = state;
	}


	public LinkedList<Point> getHitCells() {
		return HitCells;
	}
	
	
	
}
