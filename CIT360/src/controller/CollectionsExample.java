package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class CollectionsExample implements ListItem {
	public void run() {
		
		ArrayList<Integer> list = new ArrayList<Integer>(arrayListExample());
		treeSetExample(list);
		hashSetExample();
		queueExample(list);
		mapExample();
		
		
		System.out.println("Done");
	}
	

	//Example of an ArrayList which will be used in the
	//TreeSet/Queue example
	ArrayList<Integer> arrayListExample() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < 100; i++) {
			list.add((int)(Math.random() * 10));
		}
		
		Start.view.print("Printing ArrayList:\n");
		for (int i = 1; i < (list.size() + 1); i++) {
			Start.view.print(list.get(i - 1) + ",");
			if ((i % 10) == 0) Start.view.print("\n");
		}
		
		return list;
	}
	
	//Example of Tree, Set, and Queue.
	//Creating the TreeSet will create a collection
	// that will only have one of each (because it's
	// a Set) and should be in order (because it's a
	// Tree). It will then remove things from the
	// front, thus making it utilized like a Queue.
	void treeSetExample(ArrayList<Integer>list) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>(list);
		
		Start.view.print("Printing TreeSet queue:\n");
		while (!treeSet.isEmpty()) {
			Start.view.print(Integer.toString(treeSet.first()) + "\n");
			treeSet.remove(treeSet.first());
		}
	}
	
	//Extra Set example using union, intersection, and difference.
	void hashSetExample() {
		
		//	I'll be using these two lists for the example.
		Integer[] listA = {1, 2, 3, 4};
		Integer[] listB = {2, 4, 6, 8};
		
		//This Set will be what I use to add to and remove from.
		HashSet<Integer> starter = new HashSet<Integer>(Arrays.asList(listA));
		
		
		//Union listB to the set using listA
		HashSet<Integer> union = new HashSet<Integer>();
		union.addAll(starter);
		union.addAll(Arrays.asList(listB));
		System.out.println("Printing union\n" + union);

		//Intersection listA using listB as a reference
		HashSet<Integer> intersection = new HashSet<Integer>();
		intersection.addAll(starter);
		intersection.retainAll(Arrays.asList(listB));
		System.out.println("Printing intersection\n" + intersection);

		//Difference listB from the set using listA
		HashSet<Integer> difference = new HashSet<Integer>();
		difference.addAll(starter);
		difference.removeAll(Arrays.asList(listB));
		System.out.println("Printing difference\n"  + difference);
	}
	
	//Extra Queue example using a LinkedList.
	void queueExample(ArrayList<Integer> list) {
		
		//This line shoves one Integer after another from the ArrayList
		//	into the LinkedList, created a "First In" queue.
		LinkedList<Integer> queueList = new LinkedList<Integer>(list);
		
		
		//This while loop will utilize the queue by deleting the first element
		//	then printing the deleted element in a "First In - First Out" manner.
		while (!queueList.isEmpty()) {
			System.out.println(queueList.remove());
		}
	}
	
	//Extra Map example using HashMap
	void mapExample() {
		
		//Array of Student names, including a duplicate
		String[] studentNames = {
				"Susy",
				"Billy",
				"Jermaine",
				"Todd",
				"Samantha",
				"Susy" //This is a purposeful duplicate.
		};
		
		//HashMap for indicating unique Students
		HashMap<Integer, String> studentTable = new HashMap<Integer, String>();
		
		for (int i = 0; i < studentNames.length; i++) {
			//Each key (an Integer in this case) must be unique.
			//the Value may be a duplicate, as in the case of two Susies.
			studentTable.put(i, studentNames[i]);
		}
		
		System.out.println(studentTable.values());
	}
}
