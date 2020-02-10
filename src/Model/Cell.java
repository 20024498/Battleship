package Model;

import java.awt.Point;

public abstract class Cell extends Point {

	private static final long serialVersionUID = 1L;
	private Boolean hit;
	
	public Cell(int x, int y) {
		super(x,y);
		hit=false;
	}

	public void hit() {
		hit=true;
	}

	public boolean isHit() {
		return hit;
	}

	
	
}
