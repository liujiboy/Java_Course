package cqu.simple;

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
		Socket socket=new Socket("127.0.0.1",8000); //与服务器建立连接
		//获取输入和输出
		InputStream in=socket.getInputStream();
		OutputStream out=socket.getOutputStream();
		PrintWriter writer=new PrintWriter(new OutputStreamWriter(out));
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		//按照I/O的方式操作
		String result=reader.readLine();
		System.out.println(result);
		writer.println("你好！");
		writer.flush(); //将缓冲区中的数据发送
		socket.close();
	}

}
