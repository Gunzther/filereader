package filereader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class OpenUrl {
	
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
