package java_web_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketServer {
	public static void main(String[] args) throws IOException {
		Server server = null;
		try {
			server = new Server(8080);
		} catch (Exception e) {
			System.out.println("���Է������˼�������" + e.getMessage());
		} finally {
			server.start();
		}
	}
}

/** Socket�������� */
class Server {
	private int port; // �˿�
	public Server(int port) throws IOException {
		this.port = port;
		start(); // ���������������˵ķ���
	}

	// ������Ϣ
	public String infoUpperCase(String line) {
		return line.toUpperCase(); // ���ַ�����д
	}

	// ������������
	public void start() throws IOException {
		ServerSocket serverSocket = null;
		try {
			// ���ݶ˿ڴ�����������Socket����
			serverSocket = new ServerSocket(port);
			// ��ʾ������Ϣ
			System.out.println("�������������������˿ں�Ϊ��" + port);
			System.out.println("���ڵȴ��ͻ�������.........");
			// ����ȴ��ͻ�������
			Socket socketAccept = serverSocket.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader
					(socketAccept.getInputStream()));// ��ȡ��ȡ�ͻ��˵�������
			// ��ȡд���ͻ��˵����������,true:�Զ�ˢ��
			PrintWriter out = new PrintWriter(socketAccept.getOutputStream(),true);
			out.println("�����������ӳɹ�........."); // ��ͻ�����������Ϣ
			out.println("����quit�Ͽ��������������");
			boolean done = false;
			while (!done) {
				String line = in.readLine(); // ��ȡ�ͻ���ÿ�е�����
				if (line == null) { // û��д�򲻶�ȡ
					done = true;
				} else {
					// ��ʾ�ͻ��˷��͵�����
					System.out.println("���Կͻ��˵���Ϣ��" + line);
					// ��Ϣ����
					String message = infoUpperCase(line);
					// ��ͻ��˷�����Ϣ
					out.println("���Է������˵���Ϣ��" + message);
					if (line.trim().equals("quit")) {
						done = true;
					}
				}
			}
			socketAccept.close(); // �ر�ͨ����Դ
		} catch (Exception e) {
			System.out.println("�����������˳��ִ���" + e.getMessage());
		} finally {
			serverSocket.close();
		}
	}
}