package model.test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import model.Ship;
import model.ShipCell;
import model.ShipOrientation;
import model.ShipType;

public class ShipTest {

	Ship ship;
	
	@Before
	public void init() {
		
		ship = new Ship(ShipType.PORTAEREI);
		ship.setPosition(new ShipCell(0,0), ShipOrientation.ORIZZONTALE);
		
	}
	
	@Test
	public void testSetPosition() {
		assertEquals(ship.getCells().get(new Point(0,0)) , new ShipCell(0,0));
		assertEquals(ship.getCells().get(new Point(1,0)) , new ShipCell(1,0));
		assertEquals(ship.getCells().get(new Point(2,0)) , new ShipCell(2,0));
		assertEquals(ship.getCells().get(new Point(3,0)) , new ShipCell(3,0));
		assertEquals(ship.getCells().get(new Point(4,0)) , new ShipCell(4,0));
	}
	
	@Test
	public void testIsHit() {
		assertFalse(ship.isHit(1, 0));
	}
	
	@Test
	public void testHit() {
		assertFalse(ship.isHit(1, 0));
		assertTrue(ship.hit(1, 0));
		assertTrue(ship.isHit(1, 0));
		
		
	}

}
