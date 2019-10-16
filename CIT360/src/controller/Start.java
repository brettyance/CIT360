package controller;

import view.ConsoleView;

import java.util.HashMap;

import controller.HibernateExample;

public class Start {
	
	
	//direct reference to the View object in the MVC model
	static ConsoleView view = new ConsoleView();
	
	static String reply = null;
	
	public static void main(String[] args) {
		
		//using the View object to print.
		view.print("Hello! Welcome to my modules!\n"
				+ "\n"
				+ "In this application, I will demonstrate collections,\n"
				+ "threads and executables, Hibernate, JSON, and\n"
				+ "HttpURLConnection."
				+ "\n");
		
		
		while (reply == null) {
			
			
			//Using the View object to both print the text and get a reply.
			reply = view.getAnswer("Are you ready? (Y/N) ");
			
			if (reply.toUpperCase().contentEquals("Y")) {
				next();
			}
			
			else if (reply.toUpperCase().contentEquals("N")) {
				view.print("\nCome back when  you're ready.");
			}
			
			else {
				view.print("\nWrong answer.\n");
				reply = null;
			}
		}
		view.close();
	}
	
	static void next() {
		
		HashMap<String, ListItem> key = new HashMap<String, ListItem>();
				key.put("C", new CollectionsExample());
				key.put("T", new ThreadsExample());
				key.put("H", new HibernateExample());
				key.put("J", new HibernateExample());
		
		Boolean again = true;
	
		while(again) {
			
			reply = view.getAnswer("Would you like to see:\n"
					+ "(C)ollections,\n"
					+ "(T)hreads and executables,\n"
					+ "(H)ibernate,\n"
					+ "(J)SON and HttpURL Connection, or"
					+ "(Q)uit?").toUpperCase();
			
			if (key.containsKey(reply)) {
				
				ListItem operation = key.get(reply);
				operation.run();
				
			}
			
			else if (reply.contentEquals("Q")) again = false;
			
			else view.print("Not an option. Try again.");
		}
		view.print("Goodbye!");
		
	}
	
}
