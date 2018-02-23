package filereader;

public class TaskTimer {
	private static Stopwatch sw = new Stopwatch();
	
	public static void measure(Runnable run) {
		sw.start();
		run.run();
		sw.stop();
		System.out.printf("%s%.6f sec.\n",run.toString(), sw.getElapsed());
	}
}
