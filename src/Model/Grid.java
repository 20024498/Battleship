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
	public boolean hit(int x, int y) {
	
		if(x>=0 && y >=0 && x<DIM && y<DIM && !cells[x][y].isHit()) {
			cells[x][y].hit();
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isHit(int x, int y) {
		
		if(x>=0 && y >=0 && x<DIM && y<DIM)
			return false;
		
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
