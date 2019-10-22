package jUnitTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import controller.JUnitExample;

public class TestAssertArrayEquals {

	@Test
	public void test() {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++) {
			list.add((int)(Math.random() * 100));
		}
		
		JUnitExample test = new JUnitExample();
		
		ArrayList<Integer> output = test.assertArrayEqualsTest(list);
		
		assertArrayEquals(list.toArray(), output.toArray());
		
	}

}
