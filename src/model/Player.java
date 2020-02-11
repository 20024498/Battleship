package model;

public abstract class Player {
	
	private static final int SHIPNUM = 5;
	private Grid myGrid;
	private Grid oppGrid;
	private Ship[] ships;
	private int shipsAlive;
	protected int shipPositioned;
	
	
	public Player () {
		
		this.myGrid = new Grid();
		this.oppGrid = new Grid();
		this.ships = new Ship[SHIPNUM];
		shipsAlive = SHIPNUM;
		shipPositioned = 0;
		shipInit();
	}


	private void shipInit() {
		
		int i=0;
		for(ShipType s : ShipType.values()) 
			ships[i++]= new Ship(s);		
	}
	
	
	public boolean shipPositioning(Ship ship ,ShipOrientation orientation, int x, int y) {
		
		if(lecitPosition(ship.getLength(), orientation, x, y)) {
			
			ship.setPosition(new ShipCell(x,y), orientation);
			for(ShipCell c : ship.getCells())
				myGrid.getCells()[c.x][c.y].setOccupied(true);
			shipPositioned++;
			return true;
			
		}
		
		return false;
		
	} 
	
	public boolean lecitPosition(int shipLength ,ShipOrientation orientation, int x, int y) {
		
		if(orientation.equals(ShipOrientation.ORIZZONTALE)) {
			if(shipLength+x >= Grid.getDim())
				return false;
			
			for(int i=0;i<shipLength;i++)
				if(myGrid.getCells()[x+i][y].isOccupied())
					return false;
		}
		else {
			if(shipLength+y >= Grid.getDim())
				return false;
			
			for(int i=0;i<shipLength;i++)
				if(myGrid.getCells()[x][y+i].isOccupied())
					return false;
		}
		
		return true;
	}
	
	private boolean verifySurround(int x, int y) {
		
		if(x!=0 && y!=0 && x!=(Grid.getDim()-1) && y!=(Grid.getDim()-1)) {}
		
		else {
			
			if(x==0) {}
			else if(x==Grid.getDim()-1) {}
			if(y==0) {}
			else if(y==Grid.getDim()-1) {}
			
		}
		
		
		
		
		
		
	}

	public boolean isShipOnCell(int x, int y) {
		
		if(myGrid.getCells()[x][y].isOccupied())
			return true;
		
		else
			return false;
	}
	
	
	public ShipState hitShip(int x, int y) {
			
		for(Ship s : ships)
			if(s.isHit(x, y)) {
				
				s.hit(x, y);
				if(s.getState().equals(ShipState.AFFONDATA)) 
					shipsAlive--;
				
				return s.getState();
			}
			
		return ShipState.ILLESA;				
	}
	
	public void hitOppGrid (int x, int y) {
		
		if(!oppGrid.isHit(x, y))
			oppGrid.hit(x, y);
	}
	
	public void hitOwnGrid(int x, int y) {
		if(!myGrid.isHit(x, y))
			myGrid.hit(x, y);
	}


	public static int getShipnum() {
		return SHIPNUM;
	}


	public Grid getMyGrid() {
		return myGrid;
	}


	public Grid getOppGrid() {
		return oppGrid;
	}


	public Ship[] getShips() {
		return ships;
	}


	public int getShipsAlive() {
		return shipsAlive;
	}
	
	public int getShipPositioned() {
		return shipPositioned;
	}
	
	
	
}
