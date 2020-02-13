package model.test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;

import model.Computer;
import model.Grid;
import model.Player;

public class ComputerTest {

	Computer cpu;
	
	@Before
	public void testInit() {
		cpu = new Computer();
	}
	
	@Test
	public void testInitTargets() {
		
		assertEquals(cpu.getSeekTargets().size(),Grid.DIM*Grid.DIM);
		
		for(int i=0; i<Grid.DIM;i++)
			for(int j=0; j<Grid.DIM;j++)
				assertTrue(cpu.getSeekTargets().contains(new Point(i,j)));
		
		assertEquals(cpu.getSeekTargets().size(),Grid.DIM*Grid.DIM);
		
		assertFalse(cpu.getSeekTargets().contains(new Point(Grid.DIM,Grid.DIM)));
		
	}
	
	@Test
	public void testAutoPosition() {
		assertTrue(cpu.getShips().isEmpty());
		assertEquals(cpu.getShipHouse().size(),Player.SHIPNUM);
		cpu.autoPosition();
		assertTrue(cpu.getShipHouse().isEmpty());
		assertEquals(cpu.getShips().values().size(),Player.SHIPNUM);
		
		
		
		
	}
	
	@Test
	public void declareCoord() {
		HashSet<Point> set = new HashSet<Point>();
		assertEquals(cpu.getSeekTargets().size(),Grid.DIM*Grid.DIM);
		assertTrue(set.isEmpty());
		for(int i=0;i<Grid.DIM*Grid.DIM;i++)
			set.add(cpu.declareCoord());
		assertEquals(set.size(),Grid.DIM*Grid.DIM);
		assertTrue(cpu.getSeekTargets().isEmpty());
		
	}
	
	
	
	
	
	

}
