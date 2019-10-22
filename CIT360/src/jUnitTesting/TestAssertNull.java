package jUnitTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import controller.JUnitExample;

public class TestAssertNull {

	@Test
	public void test() {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++) {
			list.add((int)(Math.random() * 100));
		}
		
		JUnitExample test = new JUnitExample();
		
		Object output = test.assertNullTest(list);
		
		assertNull(output);
	}

}
