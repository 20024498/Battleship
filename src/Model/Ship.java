package Model;

public abstract class Ship implements Hittable {

	private final ShipType type;
	private final int length;
	private Cell[] cells;
	private ShipState state;
	private final ShipOrientation orientation;
	private int health;
	private Cell headCell;
	private final String name;
	
	public Ship (ShipType type,Cell headCell,ShipOrientation orientation){
		
		this.type=type;
		this.name = type.shipName();
		this.length=type.length();
		this.health=type.length();
		this.state=ShipState.ILLESA;
		this.orientation=orientation;
		this.headCell=headCell;
		this.cells = new Cell[type.length()];
		cellsInit();
		
		
	}

	private void cellsInit() {
		
		/* TODO FARE CONTROLLO OUTOFBOUND*/
		
		if (orientation.equals(ShipOrientation.ORIZZONTALE))
			for(int i=0;i<length;i++) 
				cells[i]=new Cell(headCell.x +i,headCell.y);                   
		else
			for(int i=0;i<length;i++) 
				cells[i]=new Cell(headCell.x,headCell.y+i); 	
		
	}
	
	@Override
	public void hit(int x, int y) {
		
		/* TODO FARE CONTROLLO OUTOFBOUND*/
		
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
			}
		}
	}
	
	@Override
	public boolean isHit(int x, int y) {
		
		/* TODO FARE CONTROLLO OUTOFBOUND*/
		
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

	public Cell[] getCells() {
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

	public Cell getHeadCell() {
		return headCell;
	}

	public String getName() {
		return name;
	}
	
	
}
