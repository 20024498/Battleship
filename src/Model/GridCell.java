package Model;

public class GridCell extends Cell{

	private static final long serialVersionUID = 1L;
	private boolean occupied;
	
	public GridCell(int x, int y) {
		super(x, y);
		occupied= false;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	

}
