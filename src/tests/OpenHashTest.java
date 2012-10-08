package tests;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import hashing.OpenHash;

import org.junit.Test;


public class OpenHashTest {
	
	@Test
	public void testPutGet() {
		OpenHash<String, String> map = new OpenHash<String, String>();
		map.put("comida", "food");
		assertEquals("food", map.get("comida"));
		
		map.put("barco", "ship");
		assertEquals("ship", map.get("barco"));
		
		// still there...
		assertEquals("food", map.get("comida"));
		assertEquals(2, map.size());
	}
	
	@Test
	public void testRemove() {
		OpenHash<String, String> map = new OpenHash<String, String>();
		map.put("comida", "food");
		map.remove("comida");
		assertEquals(null, map.get("comida"));
	}
	
	@Test
	public void testValues() {
		OpenHash<String, String> map = new OpenHash<String, String>();
		map.put("comida", "food");
		map.put("perro", "dog");
		map.put("barco", "ship");
		
		Collection<String> expect = new LinkedList<String>();
		expect.add("food");
		expect.add("dog");
		expect.add("ship");
		
		assertTrue(map.values().containsAll(expect));
	}
	
	@Test
	public void testKeysSet() {
		OpenHash<String, String> map = new OpenHash<String, String>();
		map.put("comida", "food");
		map.put("perro", "dog");
		map.put("barco", "ship");
		
		Set<String> expect = new HashSet<String>();
		expect.add("comida");
		expect.add("perro");
		expect.add("barco");
		
		assertTrue(map.keySet().containsAll(expect));
	}
	

}
