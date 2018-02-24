package filereader;

/**
 * Create TaskTimer and Tasks.
 * Measure the elapsed time in each task.
 * 
 * @author Gunthee tawewatmongkol
 */
public class Main {
	public static void main(String[]args) {
		TaskTimer task = new TaskTimer();
		ReadFileToStringTask read1 = new ReadFileToStringTask();
		ReadFileToStringBuilderTask read2 = new ReadFileToStringBuilderTask();
		ReadFileByBufferedReaderTask read3 = new ReadFileByBufferedReaderTask();
		task.measure(read1);
		task.measure(read2);
		task.measure(read3);
	}
}
