package model.test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import model.Ship;
import model.ShipCell;
import model.ShipOrientation;
import model.ShipState;
import model.ShipType;

public class ShipTest {

	Ship ship;
	
	@Before
	public void init() {
		
		ship = new Ship(ShipType.CACCIATORPEDINIERE);
		ship.setPosition(new ShipCell(0,0), ShipOrientation.ORIZZONTALE);
		
	}
	
	@Test
	public void testSetPosition() {
		assertEquals(ship.getCells().get(new Point(0,0)) , new ShipCell(0,0));
		assertEquals(ship.getCells().get(new Point(1,0)) , new ShipCell(1,0));
		
	}
	
	@Test
	public void testIsHit() {
		assertFalse(ship.isHit(0, 0));
		assertFalse(ship.isHit(1, 0));
	}
	
	@Test
	public void testHit() {
		assertFalse(ship.isHit(0, 0));
		assertFalse(ship.isHit(1, 0));
		assertTrue(ship.hit(0, 0));
		assertTrue(ship.isHit(0, 0));
		assertEquals(ship.getState(),ShipState.COLPITA);
		assertTrue(ship.hit(1, 0));
		assertTrue(ship.isHit(1, 0));
		assertEquals(ship.getState(),ShipState.AFFONDATA);	
		
	}

}
