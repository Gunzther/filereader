package filereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class TaskTimer {
	private final static String ALICE = "http://se.cpe.ku.ac.th/doc/samples/Alice-in-Wonderland.txt";
	
	public static String readFileToString(String filename)  {
		InputStream in;
		String all = "";
		try {
			in = openUrl(filename);
			InputStreamReader reader = new InputStreamReader(in);
			int c;
			while(true) {
				c = reader.read();
				if(c < 0) break;
				all = all + (char)c;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return all;
	}
	
	public static String readFileToStringBuilder(String filename) {
		InputStream in;
		StringBuilder all = new StringBuilder();
		try {
			in = openUrl(filename);
			InputStreamReader reader = new InputStreamReader(in);
			int c;
			while(true) {
				c = reader.read();
				if(c < 0) break;
				all.append((char) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return all.toString();
	}
	
	public static String readFileByBufferedReader(String filename) {
		InputStream in;
		String all = "";
		try {
			in = openUrl(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line = reader.readLine();
			while(line != null) {
				all = all + line + "\n";
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return all.toString();
	}
	
	public static InputStream openUrl(String urlstr) throws IOException {
		URL url = null;
		try {
			url = new URL(urlstr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return url.openStream();
	}
	
	public static void main(String[]args) {
		Stopwatch sw = new Stopwatch();
		sw.start();
		String alice = readFileToString(ALICE);
		sw.stop();
//		System.out.println(alice);
		System.out.println("Reading Alice-in-Wonderland.txt(UML) using InputStreamReader, append to String.");
		System.out.printf("Read %d chars in %.6f\n", alice.length(), sw.getElapsed());
		
		sw = new Stopwatch();
		sw.start();
		alice = readFileToStringBuilder(ALICE);
		sw.stop();
//		System.out.println(alice);
		System.out.println("Reading Alice-in-Wonderland.txt(UML) using InputStreamReader, append to StringBuilder.");
		System.out.printf("Read %d chars in %.6f\n", alice.length(), sw.getElapsed());
		
		sw = new Stopwatch();
		sw.start();
		alice = readFileByBufferedReader(ALICE);
		sw.stop();
//		System.out.println(alice);
		System.out.println("Reading Alice-in-Wonderland.txt(UML) using InputStreamReader, append lines to String.");
		System.out.printf("Read %d chars in %.6f\n", alice.length(), sw.getElapsed());
	}
}
