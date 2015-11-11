package cqu.whiteboard.server.v2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		SendDataThread sendDataThread = new SendDataThread();
		sendDataThread.start();
		ServerSocket s=null;
		try {
			s = new ServerSocket(8000);
			while (true) {
				final Socket socket = s.accept();
				System.out.printf("%s已经连接\n", socket.getInetAddress()
						.toString());
				DataInputStream in = new DataInputStream(
						socket.getInputStream());
				// 先读取客户端的类型，0表示PainterFrame，1表示ViewerFrame
				int type = in.readInt();
				if (type == 0) {
					//用线程接收数据
					ReceiveDataThread receiveDataThread = new ReceiveDataThread(
							socket, sendDataThread);
					receiveDataThread.start();
				} else {
					//用线程处理所有的ViewerFrame客户端
					sendDataThread.addClient(socket);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
