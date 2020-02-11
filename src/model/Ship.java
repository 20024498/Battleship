package model;

public class Ship implements Hittable {

	private final ShipType type;
	private final int length;
	private ShipCell[] cells;
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
		this.state=ShipState.ILLESA;
		this.cells = new ShipCell[type.length()];
		this.orientation=ShipOrientation.NESSUNA;
		this.headCell = new ShipCell(-1,-1);
		cells[0]=headCell;
		
	}
	
	public void setPosition(ShipCell headCell,ShipOrientation orientation) {
		this.orientation=orientation;
		this.headCell=headCell;
		cellsInit();
	}

	private void cellsInit() {
		
		/* TODO FARE CONTROLLO OUTOFBOUND*/
		
		if (orientation.equals(ShipOrientation.ORIZZONTALE))
			for(int i=0;i<length;i++) 
				cells[i]=new ShipCell(headCell.x +i,headCell.y);                   
		else
			for(int i=0;i<length;i++) 
				cells[i]=new ShipCell(headCell.x,headCell.y+i); 	
		
	}
	
	@Override
	public boolean hit(int x, int y) {
		
		for(int i=0;i<length;i++) {
			
			if(cells[i].x == x && cells[i].y == y) {
				
				if(state.equals(ShipState.ILLESA)) {
					setState(ShipState.COLPITA);
					cells[i].hit();
					health--;
				}
				
				else if(state.equals(ShipState.COLPITA)) {
					cells[i].hit();
					health--;
					if(health==0)
						setState(ShipState.AFFONDATA);
				}
				
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean isHit(int x, int y) {
		
		for(int i=0;i<length;i++) 
			if(cells[i].x == x && cells[i].y == y) 
				if(cells[i].isHit())
					return true;
		
		return false;
		
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

	public ShipCell[] getCells() {
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
