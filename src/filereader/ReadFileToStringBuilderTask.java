package filereader;

/**
 * Read text from URL by using InputStreamReader and append it to StringBuilder.
 * 
 * @author Gunthee tawewatmongkol
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFileToStringBuilderTask implements Runnable{
	/** URL of Alice-in-Wonderland 	*/
	private final static String ALICE = "http://se.cpe.ku.ac.th/doc/samples/Alice-in-Wonderland.txt";
	
	/**
	 * Read text from URL by using InputStreamReader and append it to StringBuilder.
	 * 
	 * @param url
	 * @return all text in URL.
	 */
	public String readFileToStringBuilder(String url) {
		InputStream in;
		StringBuilder all = new StringBuilder();
		try {
			OpenUrl op = new OpenUrl();
			in = op.openUrl(url);
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
	
	@Override
	public String toString() {
		int chars = readFileToStringBuilder(ALICE).length();
		String intro = "Alice-in-Wonderland.txt using InputStreamReader, append to StringBuilder.";
		return String.format("%s\nRead %d chars in ", intro, chars);
	}

}
