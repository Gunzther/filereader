package filereader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Read data from the URL.
 * 
 * @author Gunthee tawewatmongkol
 */
public class OpenUrl {
	
	/**
	 * Read data from the URL by using the openStream method.
	 * 
	 * @param urlstr is URL.
	 * @return an input stream for reading from the URL connection.
	 * @throws IOException
	 */
	public InputStream openUrl(String urlstr) throws IOException {
		URL url = null;
		try {
			url = new URL(urlstr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return url.openStream();
	}
	
}
