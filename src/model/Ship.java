package model;

import java.awt.Point;
import java.util.LinkedHashMap;

public class Ship implements Hittable {

	private final ShipType type;
	private final int shipId;
	private final int length;
	private LinkedHashMap<Point,ShipCell> cells;
	private ShipState state;
	private ShipOrientation orientation;
	private int health;
	private ShipCell headCell;
	private final String name;
	
	public Ship (ShipType type){
		
		this.type=type;
		this.name = type.shipName();
		this.length=type.length();
		this.health=type.length();
		this.shipId=type.id();
		this.state=ShipState.ILLESA;
		this.cells = new LinkedHashMap<Point,ShipCell>() ;
		this.orientation=ShipOrientation.NESSUNA;
		this.headCell = new ShipCell(-1,-1);
		
	}
	
	public void setPosition(ShipCell headCell,ShipOrientation orientation) {
		this.orientation=orientation;
		this.headCell=headCell;
		cellsInit();
	}

	private void cellsInit() {
		
		cells.clear();
		
		if (orientation.equals(ShipOrientation.ORIZZONTALE))
			for(int i=0;i<length;i++) 
				cells.put(new Point(headCell.x+i,headCell.y), new ShipCell(headCell.x+i,headCell.y)); 
		
		else if(orientation.equals(ShipOrientation.VERTICALE))
			for(int i=0;i<length;i++) 
				cells.put(new Point(headCell.x,headCell.y+i), new ShipCell(headCell.x,headCell.y+i)); 	
		
	}
	
	@Override
	public boolean hit(int x, int y) {
		
		Point p = new Point(x,y);
			
		if(cells.containsKey(p)) {
				
			if(state.equals(ShipState.ILLESA)) {
				setState(ShipState.COLPITA);
				cells.get(p).hit();
				health--;
			}
				
			else if(state.equals(ShipState.COLPITA)) {
				cells.get(p).hit();
				health--;
				if(health==0)
					setState(ShipState.AFFONDATA);
			}
				
			return true;
		}
		
		
		return false;
	}
	
	@Override
	public boolean isHit(int x, int y) {
		
		Point p = new Point(x,y);
		if(cells.containsKey(p)) 
			if(cells.get(p).isHit())
				return true;
		
		return false;
		
	}
	
	

	@Override
	public int hashCode() {
		
		return this.shipId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ship other = (Ship) obj;
		if (type != other.type)
			return false;
		
		return this.shipId == ((Ship)obj).shipId;
		
		
		
		
	}

	private void setState(ShipState state) {
		this.state = state;
	}

	public ShipType getType() {
		return type;
	}

	public int getLength() {
		return length;
	}

	public LinkedHashMap<Point,ShipCell> getCells() {
		return cells;
	}

	public ShipState getState() {
		return state;
	}

	public ShipOrientation getOrientation() {
		return orientation;
	}

	public int getHealth() {
		return health;
	}

	public ShipCell getHeadCell() {
		return headCell;
	}

	public String getName() {
		return name;
	}
	
	
}
