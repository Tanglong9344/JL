package java_web_programming;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Socket Client
 *
 * @author ����
 *
 */
public class SocketClient {
	public static void main(String[] args)  {
		try {
			//���ӵ�������8888�˿�
			Socket s = new Socket("127.0.0.1",8888);
			System.out.println(s);

			// �������
			OutputStream os = s.getOutputStream();
			//���ִ���
			// ��������110�������
			System.out.println("��������110�������!");
			os.write(110);

			//�ַ�������
			//���������װ��DataOutputStream��
			DataOutputStream dos = new DataOutputStream(os);
			//ʹ��writeUTF�����ַ���
			System.out.println("�����ַ���\"I am Client!\"�������!");
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