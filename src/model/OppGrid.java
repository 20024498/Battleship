package model;

public class OppGrid extends Grid {

	private static final long serialVersionUID = 1L;



	public OppGrid() {
		this.cells = new OppGridCell[Grid.DIM][Grid.DIM];
		gridInit();
	}
	
	
	protected void gridInit() {
		
		for(int i=0;i<Grid.DIM;i++)
			for(int j=0;j<Grid.DIM;j++) 
				cells[i][j] = new OppGridCell(i,j);		
	}



	public OppGridCell[][] getCells() {
		return (OppGridCell[][]) cells;
	}

	
}
