package model.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.OppGridCell;
import model.OppGridCellState;

public class OppGridCellTest {


	OppGridCell cell;
	int x;
	int y;
	
	@Before
	public void init() {
		int x= 1;
		int y= 2;
		cell = new OppGridCell(x,y);
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
	public void testGetState() {
		assertEquals(cell.getState(),OppGridCellState.DEFAULT);
	}
	
	@Test
	public void testSetState() {
		assertEquals(cell.getState(),OppGridCellState.DEFAULT);
		cell.setState(OppGridCellState.COLPITO);
		assertEquals(cell.getState(),OppGridCellState.COLPITO);
	}

}
