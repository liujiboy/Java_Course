package cqu.whiteboard.server.v2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiveDataThread extends Thread {
	private Socket socket;
	private SendDataThread sendDataThread;
	
	public ReceiveDataThread(Socket socket, SendDataThread sendDataThread) {
		super();
		this.socket = socket;
		this.sendDataThread = sendDataThread;
	}

	public void run() {
		while (true) {
			try {
				//从PainterFrame客户端读取数据
				DataInputStream in = new DataInputStream(
						socket.getInputStream());
				int totalSize = in.readInt();
				byte newdatas[] = new byte[totalSize];
				int receivedSize=in.read(newdatas);
				while(receivedSize<totalSize)
				{
					receivedSize+=in.read(newdatas,receivedSize,totalSize-receivedSize);
				}
				//更新ViewerFrame客户端的数据
				sendDataThread.setDatas(newdatas);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
