package cqu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy implements Copy {
	private String src;
	private String dest;
	public FileCopy(String src, String dest) {
		
		this.src = src;
		this.dest = dest;
	}
	

	public boolean doCopy()
	{
		try {
			InputStream in=new FileInputStream(src);
			OutputStream out=new FileOutputStream(dest);
			IOOperation.copy(in, out);
			in.close();
			out.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
}
