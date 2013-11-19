package cqu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket=new Socket("127.0.0.1",8000);
		InputStream in=socket.getInputStream();
		OutputStream out=socket.getOutputStream();
		PrintWriter writer=new PrintWriter(new OutputStreamWriter(out));
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		writer.println("add");
		writer.println(10000);
		writer.println(20000);
		writer.flush();
		String result=reader.readLine();
		System.out.println(result);
		socket.close();
	}

}
