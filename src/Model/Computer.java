package Model;

import java.awt.Point;
import java.util.Random;

public class Computer extends Player{
	
	

	public void autoPosition() {
		 
		for(Ship s : getShips()) {
			 
			int x; 
			int y; 
			int l; 
			ShipOrientation o;
			
			do {
				
				x = randomCoord();
				y = randomCoord();
				l = s.getLength();
				if(randomCoord()%2==0)
					o=ShipOrientation.ORIZZONTALE;
				else
					o=ShipOrientation.VERTICALE;
				
			}while(lecitPosition(l, o, x, y));
			
			if(shipPositioning(s, o, x, y))
				shipPositioned++;	
		 }
			 
	}
	
	public Point declareCoord() {
		
		int x; 
		int y;
		
		do {
			
			x=randomCoord();
			y=randomCoord();
			
		}while(getOppGrid().getCells()[x][y].isHit());
		
		return new Point(x,y);
		
	}

	public int randomCoord () {
		Random rand = new Random();
		return rand.nextInt(Grid.getDim());
	}

}
