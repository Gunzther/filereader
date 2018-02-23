package filereader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFileToStringBuilderTask implements Runnable{
	/** uml of Alice-in-Wonderland 	*/
	private final static String ALICE = "http://se.cpe.ku.ac.th/doc/samples/Alice-in-Wonderland.txt";
	
	public String readFileToStringBuilder(String uml) {
		InputStream in;
		StringBuilder all = new StringBuilder();
		try {
			OpenUrl op = new OpenUrl();
			in = op.openUrl(uml);
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
	
	@Override
	public void run() {
		readFileToStringBuilder(ALICE);
	}
	
	public String toString() {
		int chars = readFileToStringBuilder(ALICE).length();
		String intro = "Alice-in-Wonderland.txt using InputStreamReader, append to StringBuilder.";
		return String.format("%s\nRead %d chars in ", intro, chars);
	}

}
