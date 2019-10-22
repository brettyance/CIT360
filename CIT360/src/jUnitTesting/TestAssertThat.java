package jUnitTesting;

import static org.junit.Assert.*;
import org.junit.Test;
import controller.JUnitExample;
import static org.hamcrest.CoreMatchers.*;

public class TestAssertThat {

	@Test
	public void test() {
		
		JUnitExample test = new JUnitExample();
		
		Integer output = test.assertThatTest();
		
		assertThat(output, isA(Integer.class));
	}

}
