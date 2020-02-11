package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Computer extends Player{
	
	protected ArrayList<Point> SeekTargets;
	
	public Computer() {
		super();
		initTargets();
	}
	
	protected void initTargets () {
		SeekTargets = new ArrayList<Point>();
		for(int i=0; i<Grid.DIM;i++)
			for(int j=0; j<Grid.DIM;j++)
				SeekTargets.add(new Point(i,j));
	}

	public void autoPosition() {
		 
		while(!getShipHouse().isEmpty()) {
			 
			Ship s = getShipHouse().pop();
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
			
			shipPositioning(s, o, x, y);
					
		 }
			 
	}
	
	public Point declareCoord() {
		
		int index = randomCell();
		Point p = SeekTargets.get(index);
		SeekTargets.remove(index);
		
		return new Point(p.x,p.y);
		
	}

	public int randomCell() {
		Random rand = new Random();
		return rand.nextInt(SeekTargets.size());
	}

	public ArrayList<Point> getSeekTargets() {
		return SeekTargets;
	}
	
	

}
