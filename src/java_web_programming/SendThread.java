package java_web_programming;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{
	private Socket s;

	public SendThread(Socket s){
		this.s = s;
	}
	@SuppressWarnings("resource")
	@Override
	public void run(){
		try {
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			while(true){
				System.out.println("输入要发送的数据:");
				Scanner sc = new Scanner(System.in);
				String str = sc.next();
				dos.writeUTF(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
