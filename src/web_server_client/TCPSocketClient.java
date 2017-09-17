package web_server_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TCPSocketClient {
	public static void main(String[] args) {
		try {
			new Client("localhost", 8080); // IP��ַΪ����,�˿�Ϊ80
		} catch (Exception e) {
			System.out.println("���Կͻ������ӳ���" + e.getMessage());
		}
	}
}

/**
 * Socket�ͻ���
 */
class Client {
	private String host; // IP��ַ��������
	private int port; // �˿ں�
	public Client(String host, int port) {
		this.host = host;
		this.port = port;
		connectServer(); // �������ӷ���
	}

	// ���ӷ���
	public void connectServer() {
		try {
			Socket socketConn; // ����Socket����
			// �ж�IP��ַ(����)����Ǳ���localhost
			if (host.equals("localhost") || host.equals("127.0.0.1")) {
				// ��������Socket����
				socketConn = new Socket(InetAddress.getLocalHost(), port);
			} else { // ����Զ��Socket����
				socketConn = new Socket(InetAddress.getByName(host), port);
			}
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)); // ��ôӼ����������
			PrintWriter out = new PrintWriter(socketConn.getOutputStream(),true); // ��÷�����д���ݵ�������
			BufferedReader in = new BufferedReader(new InputStreamReader
					(socketConn.getInputStream()));// ��ý��շ������������ݵĻ�����
			// �ӷ����������Ϣ
			System.out.println("��������Ϣ��" + in.readLine());
			System.out.println("��������Ϣ��" + in.readLine());
			System.out.print("������>"); // �û�����
			boolean done = false;
			while (!done) {
				String line = stdin.readLine(); // ��ôӼ��������ÿ���ַ�
				out.println(line); // ���͵������
				if (line.equalsIgnoreCase("quit")) {
					done = true;
				}
				String info = in.readLine(); // �ӷ�������ȡ�ַ���
				System.out.println("��������Ϣ:" + info);// ��ʾ�ӷ�����������������
				if (!done) {
					System.out.print("������>");
				}
			}
			socketConn.close(); // �ر���Դ
		} catch (SecurityException e) { // ����ȫ�Դ���ʱ�������쳣
			System.out.println("���ӷ��������ְ�ȫ���⣡");
		} catch (IOException e) { // ����IO���쳣
			System.out.println("���ӷ���������I/O����");
		}
	}
}