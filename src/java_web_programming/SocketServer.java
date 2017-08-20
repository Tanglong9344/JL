package java_web_programming;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args)  {
		try {
			//服务端打开端口8888
			ServerSocket ss = new ServerSocket(8888);
			//在8888端口上监听，看是否有连接请求过来
			System.out.println("监听端口号:8888");
			Socket s =  ss.accept();
			System.out.println("有连接过来" + s);

			//打开输入流
			InputStream is = s.getInputStream();
			//数字传输
			//读取客户端发送的数据
			int msgInt = is.read();
			//打印出来
			System.out.println("读取客户端发送的数字:"+msgInt);

			//字符串传输
			//把输入流封装在DataInputStream
			DataInputStream dis = new DataInputStream(is);
			//使用readUTF读取字符串
			String msgStr = dis.readUTF();
			System.out.println("读取客户端发送的字符串:"+msgStr);
			dis.close();

			is.close();
			s.close();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
