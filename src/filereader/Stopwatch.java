package filereader;
/**
 * Computing elapsed time between a start and stop time.
 * 
 * @author Gunthee tawewatmongkol
 */
public class Stopwatch {
	private final double NANOSECONDTIME = 1.0E-9; 
	private long startTime;
	private long stopTime;
	private boolean running;
	
	public Stopwatch(){
		this.startTime = 0;
		this.stopTime = 0;
		running = false;
	}
	
	/**	Set the start time.	*/
	public void start() {
		if(running) return;
		startTime = System.nanoTime();
		running = true;
	}
	
	/**	Set the stop time when program stop running.	*/
	public void stop() {
		if(!running) return;
		stopTime = System.nanoTime();
		running = false;
	}
	
	/** @return true if program is running.	*/
	public boolean isRunning() {
		return running;
	}
	
	/**
	 * Compute elapsed time between a start and stop time.
	 * 
	 * @return elapsed time between a start and stop time.
	 */
	public double getElapsed() {
		if(running) return (System.nanoTime() - startTime)*NANOSECONDTIME;
		return (stopTime - startTime)*NANOSECONDTIME;
	}
}
