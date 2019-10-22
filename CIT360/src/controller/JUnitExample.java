package controller;

import java.util.ArrayList;

public class JUnitExample implements ListItem {

	@Override
	public void run() {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++) {
			list.add((int)(Math.random() * 100));
		}
		
		assertArrayEqualsTest(list);
		
		assertEqualsTest(list);
		
		assertFalseTest(list);
		
		assertNotNullTest(list);
		
		assertNotSameTest(list);
		
		assertNullTest(list);
		
		assertSameTest(list);
		
		assertThatTest();
		
		assertTrueTest();
		
	}
	
	public ArrayList<Integer> assertArrayEqualsTest(ArrayList<Integer> list) {
		
		for (int i = 0; i < list.size(); i++) {
			list.set(i, (list.get(i) * 2));
		}
		
		for (int i = 0; i < list.size(); i++) {
			list.set(i, (list.get(i) / 2));
		}
		
		return list;
	}
	
	public Object assertEqualsTest(Object o) {
		return o;
	}
	
	public Boolean assertFalseTest(ArrayList<Integer> list) {
		list.clear();
		
		if (list.isEmpty()) {
			return false;
		}
		
		return true;
	}
	
	public Object assertNotNullTest(ArrayList<Integer> list) {
		
		Object o = null;
		
		if (!list.isEmpty()) {
			
			o = new String("1");
		}
		
		return o;
	}
	
	public ArrayList<Integer> assertNotSameTest(ArrayList<Integer> list) {
		
		ArrayList<Integer>list2 = new ArrayList<Integer>(list);
		
		return list2;
	}
	
	public Object assertNullTest(ArrayList<Integer> list) {
		list.clear();
		Object o = null;
		
		if (!list.isEmpty()) {
			
			o = new String("1");
		}
		
		return o;
		
	}
	
	public ArrayList<Integer> assertSameTest(ArrayList<Integer> list) {
		
		ArrayList<Integer>list2 = list;
		
		return list2;
	}
	
	public Integer assertThatTest() {
		return 1;
	}
	
	public Boolean assertTrueTest() {
		return !(false);
	}

}
//assertArrayEquals, assertEquals, assertFalse, assertNotNull, assertNotSame, assertNull, assertSame, assertThat, assertTrue