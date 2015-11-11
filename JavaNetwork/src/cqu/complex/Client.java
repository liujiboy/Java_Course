package cqu.complex;

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

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Socket socket = new Socket("202.202.5.145", 8000);
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(out));
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		writer.println("sub");
		writer.println(20);
		writer.println(1);
		writer.flush();
		String result = reader.readLine();
		System.out.println(result);
		socket.close();
	}

}
