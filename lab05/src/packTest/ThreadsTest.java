package packTest;

public class ThreadsTest {
	public void testThreads() {
		ThreadClass objThreadClass1 = new ThreadClass("objThreadClass1");
		objThreadClass1.start();

		ThreadClass objThreadClass2 = new ThreadClass("objThreadClass2");
		objThreadClass2.start();
		
		RunnableClass objRunnableClass = new RunnableClass("objRunnableClass");
		objRunnableClass.start();

		System.out.println("testThreads() ended");
	}
}
