package controller;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import model.BasicRunnable;

public class ThreadsExample implements ListItem {

	public void run() {
		
		ArrayList<Runnable> runnables = new ArrayList<Runnable>();
		for(int i = 0; i < 10; i++) {
			runnables.add(new BasicRunnable(new String("Thread " + (i + 1))));
		}
		
		ExecutorService executor = Executors.newFixedThreadPool(10);

		for(int i = 0; i < 10; i++) {
			executor.execute(runnables.get(i));
		}
		
		executor.shutdown();
	}
}