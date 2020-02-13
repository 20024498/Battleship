package model;

import java.awt.Point;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ShipMap implements Map<Point,Ship> {
	
	LinkedHashMap<Point,ShipType> m1;
	LinkedHashMap <ShipType,Ship> m2;
	
	public ShipMap() {
		m1= new LinkedHashMap<Point,ShipType>();
		m2= new LinkedHashMap <ShipType,Ship>();
	}

	@Override
	public void clear() {
		m1.clear();
		m2.clear();
		
	}

	@Override
	public boolean containsKey(Object key) {
		return m1.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return m2.containsValue(value);
	}

	@Override
	public Set<Entry<Point, Ship>> entrySet() {
		
		Set<Entry<Point,Ship>> set = new HashSet<Entry<Point,Ship>>();
		
		for(Point p: m1.keySet()) {
			set.add(new AbstractMap.SimpleEntry<Point,Ship>(p,m2.get(m1.get(p))));	
		}
		
		return set;
			
	}

	@Override
	public Ship get(Object key) {
		return m2.get(m1.get(key));
	}

	@Override
	public boolean isEmpty() {
		
		if(m1.isEmpty() && m2.isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public Set<Point> keySet() {
		
		return m1.keySet();
	}

	@Override
	public Ship put(Point key, Ship value) {
		
		ShipType st = value.getType();
		ShipType st2 = m1.put(key, st);
		Ship s = m2.put(st, value);
		
		if(st2==null)
			return null;
		else
			return s;
		
	}

	@Override
	public void putAll(Map<? extends Point, ? extends Ship> m) {
		
		for(Point p: m.keySet()) {
			m1.put(p, m.get(p).getType());
			m2.put(m.get(p).getType(), m.get(p));	
		}
		
	}

	@Override
	public Ship remove(Object key) {
		
		ShipType st = m1.remove(key);
		if(!m1.containsValue(st))
			return m2.remove(st);
		return m2.get(st);
	}

	@Override
	public int size() {
		return m1.size();
	}

	@Override
	public Collection<Ship> values() {
		return m2.values();
	}

	
	
}
