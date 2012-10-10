package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import set.OpenHashBag;

public class BagTest {

	@Test
	public void test() {
		OpenHashBag<String> bag = new OpenHashBag<String>();
		assertEquals(0, bag.occurencesOf("Comida"));
		bag.add("Comida");
		bag.add("Comida");
		assertEquals(2, bag.occurencesOf("Comida"));
		
		bag.add("Tierra");
		assertEquals(1, bag.occurencesOf("Tierra"));
		bag.remove("Tierra");
		assertEquals(0, bag.occurencesOf("Tierra"));
	}

}
