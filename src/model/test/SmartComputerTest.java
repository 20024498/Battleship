package model.test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Grid;
import model.OppGridCellState;
import model.SmartComputer;
import model.SmartComputerState;

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
		
		Point p1= new Point(0,0);
		Point p2= new Point(9,9);
		Point p3= new Point(4,4);
		Point p4= new Point(4,4);
		
		
		List<Point> l1 = cpu.crossBoundary(p1);
		List<Point> l2 = cpu.crossBoundary(p2);
		List<Point> l3 = cpu.crossBoundary(p3);
		cpu.getOppGrid().hit(5,4);
		List<Point> l4 = cpu.crossBoundary(p4);
		
		assertEquals(l1.size(),2);
		assertTrue(l1.contains(new Point(0,1)));
		assertTrue(l1.contains(new Point(1,0)));
		
		assertEquals(l2.size(),2);
		assertTrue(l2.contains(new Point(8,9)));
		assertTrue(l2.contains(new Point(9,8)));
		
		assertEquals(l3.size(),4);
		assertTrue(l3.contains(new Point(3,4)));
		assertTrue(l3.contains(new Point(4,3)));
		assertTrue(l3.contains(new Point(4,5)));
		assertTrue(l3.contains(new Point(5,4)));
		
		assertEquals(l4.size(),3);
		assertTrue(l4.contains(new Point(3,4)));
		assertTrue(l4.contains(new Point(4,3)));
		assertTrue(l4.contains(new Point(4,5)));
		
	}
	
	
	
	@Test
	public void testDeclareCoord() {
		
		assertEquals(cpu.getState(),SmartComputerState.SEEK);
		HashSet<Point> set = new HashSet<Point>();
		assertEquals(cpu.getSeekTargets().size(),(Grid.DIM*Grid.DIM)/2);
		assertTrue(set.isEmpty());
		for(int i=0;i<(Grid.DIM*Grid.DIM)/2;i++)
			set.add(cpu.declareCoord());
		assertEquals(set.size(),(Grid.DIM*Grid.DIM)/2);
		assertTrue(cpu.getSeekTargets().isEmpty());
		
		Point p= new Point(4,4);
		cpu.getOppGrid().hit(p.x,p.y);
		cpu.getOppGrid().getCells()[p.x][p.y].setState(OppGridCellState.COLPITO);
		cpu.setState(SmartComputerState.DESTROY);
		assertEquals(cpu.getState(),SmartComputerState.DESTROY);
		cpu.getDestroyTargets().addAll(((SmartComputer) cpu).crossBoundary(p));
		HashSet<Point> set2 = new HashSet<Point>();
		int size = cpu.getDestroyTargets().size();
		assertEquals(size,4);
		for(int i=0;i<size;i++)
			set2.add(cpu.declareCoord());
		assertTrue(cpu.getDestroyTargets().isEmpty());
		assertEquals(set2.size(),4);
		assertTrue(set2.contains(new Point(3,4)));
		assertTrue(set2.contains(new Point(4,3)));
		assertTrue(set2.contains(new Point(4,5)));
		assertTrue(set2.contains(new Point(5,4)));
		
	}
	

}
