package model.test;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import model.Ship;
import model.ShipMap;
import model.ShipType;

public class ShipMapTest {

	ShipMap map;
	Point p1;
	Ship s1;
	
	@Before
	public void init() {
		map = new ShipMap();
		p1=new Point(0,0);
		s1= new Ship(ShipType.CACCIATORPEDINIERE);
	}
	
	@Test
	public void testPut() {
		assertNull(map.put(p1,s1));
		assertEquals(map.put(p1,s1),s1);
	}


	@Test
	public void testSize() {
		assertEquals(map.size(),0);
		assertNull(map.put(p1,s1));
		assertEquals(map.size(),1);
	}
	
	
	@Test
	public void testIsEmpty() {
		assertTrue(map.isEmpty());
		assertNull(map.put(p1,s1));
		assertFalse(map.isEmpty());
	}
	
	@Test
	public void testClear() {
		assertTrue(map.isEmpty());
		assertNull(map.put(p1,s1));
		assertFalse(map.isEmpty());
		map.clear();
		assertTrue(map.isEmpty());
	}
	
	
	
	@Test
	public void testContainskey() {
		assertEquals(map.size(),0);
		assertNull(map.put(p1,s1));
		assertEquals(map.size(),1);
		assertTrue(map.containsKey(p1));
		assertTrue(map.containsKey(new Point(0,0)));
		assertFalse(map.containsKey(new Point(2,2)));
	}
	
	@Test
	public void testContains() {
		assertEquals(map.size(),0);
		assertNull(map.put(p1,s1));
		assertEquals(map.size(),1);
		assertTrue(map.containsValue(s1));
		assertTrue(map.containsValue(new Ship(ShipType.CACCIATORPEDINIERE)));
		assertFalse(map.containsValue(new Ship(ShipType.PORTAEREI)));
	}
	
	
	
	@Test
	public void testEntrySet() {
		
		Set<Entry<Point,Ship>> set = new HashSet<Entry<Point,Ship>>();
		assertTrue(set.isEmpty());
		set= map.entrySet();
		assertTrue(set.isEmpty());
		assertNull(map.put(p1,s1));
		set= map.entrySet();
		assertEquals(set.size(),1);
		
		
	}
	
	@Test
	public void testGet() {
		assertNull(map.put(p1,s1));
		assertEquals(map.get(p1),s1);
		assertNull(map.get(new Point (2,2)));
	}
	
	@Test
	public void testKeySet() {
		Set<Point> set =new HashSet<Point>();
		assertTrue(set.isEmpty());
		assertNull(map.put(p1,s1));
		set=map.keySet();
		assertTrue(set.size()==1);
	}
	
	@Test
	public void testPutAll() {
		Map<Point,Ship> map2 = new HashMap<Point,Ship>();
		assertNull(map2.put(p1,s1));
		map.putAll(map2);
		assertTrue(map.size()==1);
		
	}
	
	@Test
	public void testRemove() {
		assertNull(map.remove(p1));
		assertNull(map.put(p1,s1));
		assertEquals(map.remove(p1),s1);
	}
	
	@Test
	public void testValues() {
		Collection<Ship> set =new HashSet<Ship>();
		assertTrue(set.isEmpty());
		assertNull(map.put(p1,s1));
		set=map.values();
		assertTrue(set.size()==1);
	}
	
	
}
