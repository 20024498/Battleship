package model;

import java.awt.Point;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public abstract class Player {
	
	private static final int SHIPNUM = 5;
	private OwnGrid ownGrid;
	private OppGrid oppGrid;
	private LinkedHashMap<Point,Ship> ships;
	private int shipsAlive;
	private LinkedList<Ship> shipHouse;
	
	
	public Player () {
		
		this.ownGrid = new OwnGrid();
		this.oppGrid = new OppGrid();
		this.ships = new LinkedHashMap<Point,Ship>();
		shipsAlive = SHIPNUM;
		shipHouse = new LinkedList<Ship>();
		shipHouseInit();
	}


	private void shipHouseInit() {
		
		for(ShipType s : ShipType.values()) { 
			shipHouse.add(new Ship(s));
		}
					
	}
	
	
	protected boolean shipPositioning(Ship ship ,ShipOrientation orientation, int x, int y) {
		
		if(lecitPosition(ship.getLength(), orientation, x, y)) {
			
			ship.setPosition(new ShipCell(x,y), orientation);
			
			for(ShipCell c : ship.getCells().values()) {
				ownGrid.getCells()[c.x][c.y].occupy();
				ownGrid.getCells()[c.x][c.y].setShipType(ship.getType());
				ships.put(c, ship);
			}
				
			return true;
			
		}
		
		return false;
		
	} 
	
	public boolean lecitPosition(int shipLength ,ShipOrientation orientation, int x, int y) {
		
		if(orientation.equals(ShipOrientation.ORIZZONTALE)) {
			if(shipLength+x >= Grid.DIM)
				return false;
			
			for(int i=0;i<shipLength;i++)
				if(ownGrid.getCells()[x+i][y].isOccupied())
					return false;
		}
		else {
			if(shipLength+y >= Grid.DIM)
				return false;
			
			for(int i=0;i<shipLength;i++)
				if(ownGrid.getCells()[x][y+i].isOccupied())
					return false;
		}
		
		
		return true;
	}
	
	
	 
	public boolean isShipOnCell(int x, int y) {
		
		return ships.containsKey(new Point(x,y));
	}
	
	
	
	public Ship getShipOnCell(int x, int y) {
		
		return ships.get(new Point(x,y));
			
	}
	
	
	public ShipState hitOwnShip(int x, int y) {
			
		/*TODO eccezione griglia non colpita*/
		
			Ship s = ships.get(new Point(x,y));
			
			if(s!=null) {
				if(!ownGrid.isHit(x, y)) 
					hitOwnGrid(x, y);
					
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


	public OppGrid getOppGrid() {
		return oppGrid;
	}


	public LinkedHashMap<Point,Ship> getShips() {
		return ships;
	}


	public int getShipsAlive() {
		return shipsAlive;
	}


	public OwnGrid getOwnGrid() {
		return ownGrid;
	}


	public LinkedList<Ship> getShipHouse() {
		return shipHouse;
	}
	
	
	
	
	
}
