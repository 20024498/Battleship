package model;

import java.io.Serializable;

/**
 * 
 * 
 * @author Gili_Patera
 *
 */
public abstract class Grid implements Hittable,Serializable{
	

	private static final long serialVersionUID = 1L;
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
		
		if(x<0 || y<0 || x>=DIM || y>=DIM)
			return false;
		
		if(cells[x][y].isHit())
			return true;
		else
			return false;
		
	}

	/**
	 * Questa funzione restituisce il campo cells
	 * 
	 * @return cells, ovvero una matrice di Cell
	 */
	public Cell[][] getCells() {
		return cells;
	}
}
