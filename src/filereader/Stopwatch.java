package filereader;

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
	
	public void start() {
		if(running) return;
		startTime = System.nanoTime();
		running = true;
	}
	
	public void stop() {
		if(!running) return;
		stopTime = System.nanoTime();
		running = false;
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public double getElapsed() {
		if(running) return (System.nanoTime() - startTime)*NANOSECONDTIME;
		return (stopTime - startTime)*NANOSECONDTIME;
	}
}
