package model;

public class OwnGridCell extends Cell {

	private static final long serialVersionUID = 1L;

	private boolean occupied;
	private ShipType shipType;
	
	public OwnGridCell(int x,int y) {
		super(x,y);	
		occupied=false;
		shipType=null;
	}
	
	public OwnGridCell(Cell c) {
		super(c);
		occupied=false;
		shipType=null;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public ShipType getShipType() {
		return shipType;
	}

	public void Occupy() {
		occupied = true;
	}

	public void setShipType(ShipType shipType) {
		this.shipType = shipType;
	}
	
	
	
	

	
}
