package model.test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import model.Difficulty;
import model.Game;
import model.Player;
import model.Ship;

public class GameTest {
	
	Game game1;
	Game game2;
	
	@Before
	public void init() {
		 game1 = new Game(Difficulty.FACILE,10);
		 game2 = new Game(Difficulty.MEDIA,10);
	}

	@Test
	public void testPlayerPosition() {
		game1.getPlayer();
		Ship s = game1.getPlayer().getShipHouse().peek();
		boolean b1 = game1.getPlayer().humanShipPosition(new Point (0,1));
		boolean b2 = game1.getPlayer().humanShipPosition(new Point (10,11));
		assertTrue(b1);
		assertFalse(b2);
		assertEquals(game1.getPlayer().getShips().get(new Point (0,1)),s);
		assertEquals(game1.getPlayer().getShips().get(new Point (0,2)),s);
		assertEquals(game1.getPlayer().getShips().get(new Point (0,3)),s);
		assertEquals(game1.getPlayer().getShips().get(new Point (0,4)),s);
		assertEquals(game1.getPlayer().getShips().get(new Point (0,5)),s);
		assertNull(game1.getPlayer().getShips().get(new Point (0,6)));
		assertNotEquals(s, game1.getPlayer().getShipHouse().peek());
		Ship s2 = game1.getPlayer().getShipHouse().peek();
		boolean b3 = game1.getPlayer().humanShipPosition(new Point (0,1));
		assertFalse(b3);
		boolean b4 = game1.getPlayer().humanShipPosition(new Point (4,1));
		assertTrue(b4);
		game1.getPlayer().switchOrientation();
		assertEquals(game1.getPlayer().getShips().get(new Point (4,1)),s2);
		assertEquals(game1.getPlayer().getShips().get(new Point (4,2)),s2);
		assertEquals(game1.getPlayer().getShips().get(new Point (4,3)),s2);
		assertEquals(game1.getPlayer().getShips().get(new Point (4,4)),s2);
		assertNull(game1.getPlayer().getShips().get(new Point (4,5)));
	}
	
	@Test
	public void testCpuPosition() {
		assertTrue(game1.getCpu().getShips().isEmpty());
		assertEquals(game1.getCpu().getShipHouse().size(),Player.SHIPNUM);
		game1.getCpu().autoPosition();
		assertTrue(game1.getCpu().getShipHouse().isEmpty());
		assertEquals(game1.getCpu().getShips().values().size(),Player.SHIPNUM);
	}
	
	/*
	@Test
	public void testPlayerMove() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCpuMove() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSave() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testLoad() {
		fail("Not yet implemented");
	}
*/
}
