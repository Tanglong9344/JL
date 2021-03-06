package java_web_programming;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReceiveThread extends Thread {
	private Socket s;

	public ReceiveThread(Socket s) {
		this.s = s;
	}
	@Override
	public void run() {
		try {
			InputStream is = s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			while (true) {
				String msg = dis.readUTF();
				System.out.println("接受的数据:"+msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}