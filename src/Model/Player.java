package Model;

import java.awt.Point;

public abstract class Player {
	
	private static final int SHIPNUM = 5;
	private Grid myGrid;
	private Grid oppGrid;
	private Ship[] ships;
	private int shipsAlive; 
	
	
	public Player () {
		
		this.myGrid = new Grid();
		this.oppGrid = new Grid();
		this.ships = new Ship[SHIPNUM];
		shipsAlive = SHIPNUM;
		shipInit();
	}


	private void shipInit() {
		
		int i=0;
		for(ShipType s : ShipType.values()) 
			ships[i++]= new Ship(s);		
	}
	
	
	public abstract void shipPositioning();
	
	
	public abstract Point declareCoord();
	

	public boolean hasHit(int x, int y) {
		
		if(myGrid.getCells()[x][y].isOccupied())
			return true;
		
		else
			return false;
	}
	
	
	public void setHit(int x, int y) {
		
		if(!myGrid.isHit(x, y))
			myGrid.hit(x, y);
		
		for(Ship s : ships)
			if(!s.isHit(x, y)) {
				s.hit(x, y);
				if(s.getHealth()==0);
					shipsAlive--;
			}
					
	}
	
	
	
	
	
}
