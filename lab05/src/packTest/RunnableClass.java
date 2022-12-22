package packTest;

public class RunnableClass implements Runnable {
	Thread t;
	//String threadName;
	
	public RunnableClass(String threadName) {
		//this.threadName = threadName;
		//t = new Thread(this);
		t = new Thread(this, threadName);
		System.out.println("Constructor thread = " + threadName);
	}
	
	public void start() {
		//System.out.println("Starting thread = " + threadName);
		System.out.println("Starting thread = " + t.getName());
		t.start();
	}

	@Override
	public void run() {
		//System.out.println("Running thread = " + threadName);
		System.out.println("Running thread = " + t.getName());
		
		for (int i = 0; i < 10; i++) {
			//System.out.println("Run thread = " + threadName + ", step = " + i);
			System.out.println("Run thread = " + t.getName() + ", step = " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//System.out.println("run() ended thread = " + threadName);		
		System.out.println("run() ended thread = " + t.getName());		
	}
}
