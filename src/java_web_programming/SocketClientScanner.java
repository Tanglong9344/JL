package java_web_programming;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClientScanner {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 8888);
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			//使用Scanner读取控制台的输入，并发送到服务端
			Scanner sc = new Scanner(System.in);
			boolean run=true;
			while(run){
				System.out.println("输入要发送的数据:");
				String str = sc.next();
				if("Q".equals(str) || "q".equals(str)){
					run = false;
					System.out.println("退出!");
				}else{
					System.out.println("发送字符串\""+str+"\"到服务端!");
					dos.writeUTF(str);
				}
			}
			dos.close();
			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
