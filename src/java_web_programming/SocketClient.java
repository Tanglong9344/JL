package java_web_programming;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Socket Client
 *
 * @author 唐龙
 *
 */
public class SocketClient {
	public static void main(String[] args)  {
		try {
			//连接到本机的8888端口
			Socket s = new Socket("127.0.0.1",8888);
			System.out.println(s);

			// 打开输出流
			OutputStream os = s.getOutputStream();
			//数字传输
			// 发送数字110到服务端
			System.out.println("发送数字110到服务端!");
			os.write(110);

			//字符串传输
			//把输出流封装在DataOutputStream中
			DataOutputStream dos = new DataOutputStream(os);
			//使用writeUTF发送字符串
			System.out.println("发送字符串\"I am Client!\"到服务端!");
			dos.writeUTF("I am Client!");
			dos.close();

			os.close();
			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}