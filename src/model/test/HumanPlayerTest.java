package model.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.HumanPlayer;
import model.ShipOrientation;

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
	public void testShipPositioning() {
		
	}

	@Test
	public void testLecitPosition() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsShipOnCell() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetShipOnCell() {
		fail("Not yet implemented");
	}

	@Test
	public void testHitOwnShip() {
		fail("Not yet implemented");
	}

	@Test
	public void testHitOppGrid() {
		fail("Not yet implemented");
	}

	@Test
	public void testHitOwnGrid() {
		fail("Not yet implemented");
	}
	
	

}
