package test;

import static org.junit.Assert.*;
import hashing.OpenHash;

import org.junit.Before;
import org.junit.Test;



public class OpenHashTest {
	
	@Before
	public void init() {
	}
	
	@Test
	public void testPutGet() {
		OpenHash<String, String> map= new OpenHash<String, String>();
		map.put("comida", "food");
		assertEquals("food", map.get("comida"));
	}
	

}
