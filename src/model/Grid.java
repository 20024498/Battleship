package model;

public abstract class Grid implements Hittable{
	
	public static final int DIM = 10;
	protected Cell[][] cells;
	
	
	protected abstract void gridInit(); 

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


	public Cell[][] getCells() {
		return cells;
	}
	
	
	
}
