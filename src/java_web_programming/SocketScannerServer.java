package java_web_programming;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketScannerServer {
	public static void main(String[] args)  {
		try {
			//����˴򿪶˿�8888
			ServerSocket ss = new ServerSocket(8888);
			//��8888�˿��ϼ��������Ƿ��������������
			System.out.println("�����˿ں�:8888");
			Socket s =  ss.accept();
			System.out.println("�����ӹ���" + s);

			//��������
			InputStream is = s.getInputStream();
			//�ַ�������
			//����������װ��DataInputStream
			DataInputStream dis = new DataInputStream(is);
			//ʹ��readUTF��ȡ�ַ���
			String msgStr;
			boolean run=true;
			while(run){
				msgStr = dis.readUTF();
				if(msgStr.length()>0) {
					System.out.println("��ȡ�ͻ��˷��͵��ַ���:"+msgStr);
				}
			}
			dis.close();
			is.close();
			s.close();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}