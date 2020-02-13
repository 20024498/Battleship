package model;

public class OwnGrid extends Grid{

	private static final long serialVersionUID = 1L;

	public OwnGrid() {
		this.cells = new OwnGridCell[Grid.DIM][Grid.DIM];
		gridInit();
	}
	
	
	protected void gridInit() {
		
		for(int i=0;i<Grid.DIM;i++)
			for(int j=0;j<Grid.DIM;j++) 
				cells[i][j] = new OwnGridCell(i,j);		
	}



	public OwnGridCell[][] getCells() {
		return (OwnGridCell[][])cells;
	}

}
