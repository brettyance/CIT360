package threadsRetry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Namer {
	
	int i;
	
	Namer() {
		this.i = 0;
	}
	
	synchronized String name() {
		return "Thread" + this.i++;
	}
}

class Spammer implements Runnable {
	
	public Spammer(Namer namer) {
		new Thread(this, namer.name()).start();
	}
	
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + " started.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) { e.printStackTrace(); }
		
		System.out.println(Thread.currentThread().getName() + " finished.");
	}
}


public class MultiThreadingBasic {
	
	public static void main(String[] args) throws InterruptedException {
		
		Namer namer = new Namer();
		ExecutorService taskmaster = Executors.newFixedThreadPool(10);
		
		Runnable example = () -> {
			System.out.println(Thread.currentThread().getName() + " started");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " finished");
		};
		
		for (int i = 0; i < 10; i++) {
			new Spammer(namer);
			taskmaster.execute(example);
		}
		
		taskmaster.shutdown();
	}
}

