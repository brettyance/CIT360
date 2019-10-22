package controller;

import java.util.ArrayList;
import java.util.TreeSet;

public class CollectionsExample implements ListItem {
	public void run() {
		
		//A Hashmap is used in Start.java to control the ACP
		
		//Example of an ArrayList which will be used in the
		//TreeSet/Queue example
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < 100; i++) {
			list.add((int)(Math.random() * 10));
		}
		
		Start.view.print("Printing ArrayList:\n");
		for (int i = 1; i < (list.size() + 1); i++) {
			Start.view.print(list.get(i - 1) + ",");
			if ((i % 10) == 0) Start.view.print("\n");
		}
		
		//Example of Tree, Set, and Queue.
		//Creating the TreeSet will create a collection
		// that will only have one of each (because it's
		// a Set) and should be in order (because it's a
		// Tree). It will then remove things from the
		// front, thus making it utilized like a Queue.
		TreeSet<Integer> treeSet = new TreeSet<Integer>(list);
		
		
		Start.view.print("Printing TreeSet queue:\n");
		while (!treeSet.isEmpty()) {
			Start.view.print(Integer.toString(treeSet.first()) + "\n");
			treeSet.remove(treeSet.first());
		}
		
		System.out.println("done");
	}
}
