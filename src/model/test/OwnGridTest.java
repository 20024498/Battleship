package model.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.OwnGrid;

public class OwnGridTest {

	OwnGrid grid;
	
	@Before
	public void init() {
		
		grid = new OwnGrid();
		
	}
	
	
	@Test
	public void testIsHit() {
		assertFalse(grid.isHit(1, 2));
	}
	
	@Test
	public void testHit() {
		assertFalse(grid.isHit(1, 2));
		assertTrue(grid.hit(1, 2));
		assertTrue(grid.isHit(1, 2));
		assertFalse(grid.isHit(10, 20));
		assertFalse(grid.hit(10, 20));
		assertFalse(grid.isHit(10, 20));
		
	}
	
	
	
}
