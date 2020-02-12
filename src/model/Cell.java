package model;

import java.awt.Point;

public abstract class Cell extends Point {

	private static final long serialVersionUID = 1L;
	boolean hit;
	
	public Cell(int x, int y) {
		super(x,y);
		hit=false;
	}
	
	public Cell(Point c) {
		super(c.x,c.y);
		hit=false;
	}

	public boolean isHit() {
		return hit;
	}

	public void hit() {
		this.hit = true;
	}
	
	
}
