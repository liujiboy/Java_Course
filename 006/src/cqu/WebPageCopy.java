package cqu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class WebPageCopy implements Copy{
	private String src;
	private String dest;
	public WebPageCopy(String src, String dest) {
		
		this.src = src;
		this.dest = dest;
	}

	public boolean doCopy() {
		try {
			URL url = new URL(src);
			OutputStream out = new FileOutputStream(dest);
			InputStream in = url.openStream();
			IOOperation.copy(in, out);
			in.close();
			out.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
