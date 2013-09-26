package cqu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	private String src;
	private String dest;
	public FileCopy(String src, String dest) {
		super();
		this.src = src;
		this.dest = dest;
	}
	public boolean doCopy()
	{
		try {
			InputStream in=new FileInputStream(src);
			OutputStream out=new FileOutputStream(dest);
			byte b[]=new byte[1024*1024*5];
			int len=in.read(b);
			while(len!=-1)
			{
				out.write(b, 0, len);
				len=in.read(b);
			}
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
