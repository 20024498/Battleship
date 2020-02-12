package model.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.OwnGridCell;
import model.ShipType;

public class OwnGridCellTest {

	
	OwnGridCell cell;
	int x;
	int y;
	
	@Before
	public void init() {
		int x= 1;
		int y= 2;
		cell = new OwnGridCell(x,y);
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
	
	@Test
	public void testIsOccupied() {
		assertFalse(cell.isOccupied());
	}
	
	@Test
	public void testOccupy() {
		assertFalse(cell.isOccupied());
		cell.occupy();
		assertTrue(cell.isOccupied());
	}

	@Test
	public void testGetShiptype() {
		assertNull(cell.getShipType());
	}
	
	@Test
	public void testSetShiptype() {
		assertNull(cell.getShipType());
		cell.setShipType(ShipType.PORTAEREI);
		assertEquals(cell.getShipType(),ShipType.PORTAEREI);
	}
}
