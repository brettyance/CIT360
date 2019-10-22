package jUnitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.JUnitExample;

public class TestAssertTrue {

	@Test
	public void test() {
		
		JUnitExample test = new JUnitExample();
		
		Boolean output = test.assertTrueTest();
		
		assertTrue(output);
	}

}
