package Model;

import java.awt.Point;
import java.util.LinkedHashMap;

public abstract class Player {
	
	private static final int SHIPNUM = 5;
	private OwnGrid ownGrid;
	private OppGrid oppGrid;
	private LinkedHashMap<Point,Ship> ships;
	private int shipsAlive;
	protected int shipPositioned;
	
	
	public Player () {
		
		this.ownGrid = new OwnGrid();
		this.oppGrid = new OppGrid();
		this.ships = new LinkedHashMap<Point,Ship>();
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
				ownGrid.getCells()[c.x][c.y].setOccupied(true);
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
				if(ownGrid.getCells()[x+i][y].isOccupied())
					return false;
		}
		else {
			if(shipLength+y >= Grid.getDim())
				return false;
			
			for(int i=0;i<shipLength;i++)
				if(ownGrid.getCells()[x][y+i].isOccupied())
					return false;
		}
		
		return true;
	}
	

	public boolean isShipOnCell(int x, int y) {
		
		if(ownGrid.getCells()[x][y].isOccupied())
			return true;
		
		else
			return false;
	}
	
	public Ship getShipOnCell(int x, int y) {
		
		if(isShipOnCell(x, y)) {
			for(Ship s : ships)
				for(ShipCell c : s.getCells())
					if(c.x==x && c.y ==y)
						return s;
		}
		
		return null;
			
	}
	
	
	public ShipState hitShip(int x, int y) {
			
		for(Ship s : ships)
			if(!s.isHit(x, y) && ownGrid.isHit(x, y)) {
				
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
		if(!ownGrid.isHit(x, y))
			ownGrid.hit(x, y);
	}


	public static int getShipnum() {
		return SHIPNUM;
	}


	public Grid getMyGrid() {
		return ownGrid;
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
