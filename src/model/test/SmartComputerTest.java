package model.test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Grid;
import model.SmartComputer;

public class SmartComputerTest {

	SmartComputer cpu;
	
	@Before
	public void init() {
		cpu = new SmartComputer();
	}
	
	@Test
	public void testInitTargets() {
		
		
		for(int i=0; i<Grid.DIM;i++)
			for(int j=0; j<Grid.DIM;j++) {
				if((i+j)%2==0)
					assertTrue(cpu.getSeekTargets().contains(new Point(i,j)));
				else
					assertFalse(cpu.getSeekTargets().contains(new Point(i,j)));
			}
		
		assertEquals(cpu.getSeekTargets().size(),(Grid.DIM*Grid.DIM)/2);
	}
	
	@Test
	public void testCrossBoundary() {
		
		List<Point> l1 = new ArrayList<Point>();
		List<Point> l2 = new ArrayList<Point>();
		List<Point> l3 = new ArrayList<Point>();
		List<Point> l4 = new ArrayList<Point>();
		List<Point> l5 = new ArrayList<Point>();
		
		
	}
	
	
	/*
	@Test
	public void testDeclareCoord() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
*/
}
