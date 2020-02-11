package Model;

public class OppGridCell extends Cell{

	private static final long serialVersionUID = 1L;

	OppGridCellState state;
	
	public OppGridCell(int x , int y) {
		super(x,y);
		state=OppGridCellState.DEFAULT;
		
	}
	
	public OppGridCell(Cell c) {
		super(c);
		state=OppGridCellState.DEFAULT;
	}

	public OppGridCellState getState() {
		return state;
	}

	public void setState(OppGridCellState state) {
		this.state = state;
	}

	

	

	
	

}
