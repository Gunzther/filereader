package filereader;

/**
 * Performing any Runnable task and prints results(description of the task and elapsed time).
 * 
 * @author Gunthee tawewatmongkol
 */
public class TaskTimer {
	private static Stopwatch sw = new Stopwatch();
	
	/**
	 * Run the task, measure the elapsed time, and print the elapsed time.
	 * 
	 * @param run is the task.
	 */
	public static void measure(Runnable run) {
		sw.start();
		run.run();
		sw.stop();
		System.out.printf("%s%.6f sec.\n",run.toString(), sw.getElapsed());
	}
}
