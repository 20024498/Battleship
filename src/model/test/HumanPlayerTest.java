package model.test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import model.HumanPlayer;
import model.Ship;
import model.ShipOrientation;
import model.ShipState;

public class HumanPlayerTest {

	HumanPlayer player;
	
	@Before
	public void testInit() {
		player = new HumanPlayer();
	}
	
	@Test
	public void testSwitchOrientation() {
		assertEquals(player.getChoiceOrientation(),ShipOrientation.VERTICALE);
		player.switchOrientation();
		assertEquals(player.getChoiceOrientation(),ShipOrientation.ORIZZONTALE);
		
	}

	
	@Test
	public void testhumanShipPosition() {
		Ship s = player.getShipHouse().peek();
		boolean b1 = player.humanShipPosition(new Point (0,1));
		boolean b2 = player.humanShipPosition(new Point (10,11));
		assertTrue(b1);
		assertFalse(b2);
		assertEquals(player.getShips().get(new Point (0,1)),s);
		assertEquals(player.getShips().get(new Point (0,2)),s);
		assertEquals(player.getShips().get(new Point (0,3)),s);
		assertEquals(player.getShips().get(new Point (0,4)),s);
		assertEquals(player.getShips().get(new Point (0,5)),s);
		assertNull(player.getShips().get(new Point (0,6)));
		assertNotEquals(s, player.getShipHouse().peek());
		Ship s2 = player.getShipHouse().peek();
		boolean b3 = player.humanShipPosition(new Point (0,1));
		assertFalse(b3);
		boolean b4 = player.humanShipPosition(new Point (4,1));
		assertTrue(b4);
		player.switchOrientation();
		assertEquals(player.getShips().get(new Point (4,1)),s2);
		assertEquals(player.getShips().get(new Point (4,2)),s2);
		assertEquals(player.getShips().get(new Point (4,3)),s2);
		assertEquals(player.getShips().get(new Point (4,4)),s2);
		assertNull(player.getShips().get(new Point (4,5)));
		
		
		
		
	}
	@Test
	public void testShipPositioning() {
		Ship s = player.getShipHouse().peek();
		boolean b1 = player.humanShipPosition(new Point (2,1));
		boolean b3 = player.humanShipPosition(new Point (1,6));
		player.switchOrientation();
		boolean b4 = player.humanShipPosition(new Point (0,1));
		boolean b2 = player.humanShipPosition(new Point (8,0));
		
		assertNotEquals(s, player.getShipHouse().peek());
		assertTrue(b1);
		assertFalse(b2);
		assertFalse(b3);
		assertFalse(b4);
		
	}
	

	@Test
	public void testLecitPosition() {
		Ship s = player.getShipHouse().peek();
		boolean b1 = player.lecitPosition(s.getLength(), player.getChoiceOrientation(), 2, 1);
		boolean b3 = player.lecitPosition(s.getLength(), player.getChoiceOrientation(), 1, 6);
		player.switchOrientation();
		boolean b4 = player.lecitPosition(s.getLength(), player.getChoiceOrientation(), 0, 1);
		boolean b2 = player.lecitPosition(s.getLength(), player.getChoiceOrientation(), 8, 0);
		
		assertTrue(b1);
		assertFalse(b2);
		assertFalse(b3);
		assertTrue(b4);
	}

	@Test
	public void testIsShipOnCell() {
		boolean b1 = player.humanShipPosition(new Point (0,1));
		assertTrue(b1);
		assertTrue(player.isShipOnCell(0, 1));
		assertTrue(player.isShipOnCell(0, 2));
		assertTrue(player.isShipOnCell(0, 3));
		assertTrue(player.isShipOnCell(0, 4));
		assertTrue(player.isShipOnCell(0, 5));
		assertFalse(player.isShipOnCell(0, 6));
	}

	@Test
	public void testGetShipOnCell() {
		Ship s = player.getShipHouse().peek();
		boolean b1 = player.humanShipPosition(new Point (0,1));
		assertTrue(b1);
		assertTrue(player.getShipOnCell(0, 1).equals(s));
		assertTrue(player.getShipOnCell(0, 4).equals(s));
		assertNull(player.getShipOnCell(0, 6));
	}

	@Test
	public void testHitOwnShip() {
		Ship s = player.getShipHouse().peek();
		boolean b1 = player.humanShipPosition(new Point (0,1));
		assertTrue(b1);
		assertEquals(s.getState(),ShipState.ILLESA);
		assertEquals(player.hitOwnShip(0, 0),ShipState.ILLESA);
		assertEquals(player.hitOwnShip(0, 1),ShipState.COLPITA);
		assertEquals(player.hitOwnShip(0, 2),ShipState.COLPITA);
		assertEquals(player.hitOwnShip(0, 3),ShipState.COLPITA);
		assertEquals(player.hitOwnShip(0, 4),ShipState.COLPITA);
		assertEquals(player.hitOwnShip(0, 5),ShipState.AFFONDATA);
		assertEquals(player.getShipsAlive(),HumanPlayer.getShipnum()-1);
	}

	@Test
	public void testHitOppGrid() {
		assertFalse(player.getOppGrid().isHit(0, 0));
		player.hitOppGrid(0, 0);
		assertTrue(player.getOppGrid().isHit(0, 0));
		
	}

	@Test
	public void testHitOwnGrid() {
		assertFalse(player.getOwnGrid().isHit(0, 0));
		player.hitOwnGrid(0, 0);
		assertTrue(player.getOwnGrid().isHit(0, 0));
	}
	
	

}
