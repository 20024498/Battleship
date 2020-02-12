package model.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ShipCell;

public class ShipCellTest {

	ShipCell cell;
	int x;
	int y;
	
	@Before
	public void init() {
		int x= 1;
		int y= 2;
		cell = new ShipCell(x,y);
	}
	
	@Test
	public void testIsHit() {
		assertFalse(cell.isHit());
	}

	@Test
	public void testHit() {
		assertFalse(cell.isHit());
		cell.hit();
		assertTrue(cell.isHit());
	}
}
