package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Computer extends Player{
	
	protected ArrayList<Point> possibleTargets;
	
	public Computer() {
		super();
		possibleTargets = new ArrayList<Point>();
		initTargets();
	}
	
	protected void initTargets () {
		for(int i=0; i<Grid.getDim();i++)
			for(int j=0; j<Grid.getDim();j++)
				possibleTargets.add(new Point(i,j));
	}

	public void autoPosition() {
		 
		for(Ship s : getShips()) {
			 
			int x; 
			int y; 
			int l; 
			ShipOrientation o;
			
			do {
				
				x = randomCell();
				y = randomCell();
				l = s.getLength();
				if(randomCell()%2==0)
					o=ShipOrientation.ORIZZONTALE;
				else
					o=ShipOrientation.VERTICALE;
				
			}while(lecitPosition(l, o, x, y));
			
			if(shipPositioning(s, o, x, y))
				shipPositioned++;	
		 }
			 
	}
	
	public Point declareCoord() {
		
		int index = randomCell();
		Point p = possibleTargets.get(index);
		possibleTargets.remove(index);
		
		return new Point(p.x,p.y);
		
	}

	public int randomCell() {
		Random rand = new Random();
		return rand.nextInt(possibleTargets.size());
	}

	public ArrayList<Point> getPossibleTargets() {
		return possibleTargets;
	}
	
	

}
