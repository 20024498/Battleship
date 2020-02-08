package Model;

public class Grid implements Hittable{
	
	private static final int DIM = 10;
	private GridCell[][] cells;
	
	public Grid() {
		this.cells = new GridCell[DIM][DIM];
		gridInit();
	}
	
	
	private void gridInit() {
		
		for(int i=0;i<DIM;i++)
			for(int j=0;j<DIM;j++) 
				cells[i][j] = new GridCell(i,j);		
	}

	@Override
	public void hit(int x, int y) {
		// TODO FARE CONTROLLO OUTOFBOUND
		
		cells[x][y].hit();
		
		
	}

	@Override
	public boolean isHit(int x, int y) {
		// TODO FARE CONTROLLO OUTOFBOUND
		
		if(cells[x][y].isHit())
			return true;
		else
			return false;
		
	}


	public static int getDim() {
		return DIM;
	}


	public GridCell[][] getCells() {
		return cells;
	}

	

}
