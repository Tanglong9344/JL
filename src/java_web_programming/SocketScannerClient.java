package java_web_programming;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketScannerClient {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			Socket s = new Socket("127.0.0.1", 8888);
			OutputStream os = s.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			//ʹ��Scanner��ȡ����̨�����룬�����͵������
			sc = new Scanner(System.in);
			boolean run=true;
			while(run){
				System.out.println("����Ҫ���͵�����:");
				String str = sc.next();
				if("Q".equals(str) || "q".equals(str)){
					run = false;
					System.out.println("�˳�!");
				}else{
					System.out.println("�����ַ���\""+str+"\"�������!");
					dos.writeUTF(str);
				}
			}
			dos.close();
			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}