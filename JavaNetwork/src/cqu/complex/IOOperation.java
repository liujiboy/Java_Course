package cqu.complex;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOOperation {
	public static void copy(InputStream in, OutputStream out) throws IOException {
		byte b[]=new byte[1024*1024*5];
		int len=in.read(b);
		while(len!=-1)
		{
			out.write(b, 0, len);
			len=in.read(b);
		}
	
	}
}
