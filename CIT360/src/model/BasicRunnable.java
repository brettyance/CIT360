package model;

import java.util.Random;

public class BasicRunnable implements Runnable{
	 private String name;
	 final static Random random = new Random();
	 
	 public BasicRunnable(String name) {
		 this.name = name;
	 }

	@Override
	public void run() {
		try {
			//I haven't figured out a way to send these messages
			// back to the model for it to be printed by the
			// view class, so here's me defaulting.
			System.out.printf("%s started!/n", this.name);
			Thread.sleep((long)random.nextInt(10000));
			System.out.printf("%s executed!%n", this.name);
		} catch(Exception e){System.out.println(e.getMessage());}
		
	}
}
