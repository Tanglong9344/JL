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
			new Client("localhost", 8080); // IP地址为本机,端口为80
		} catch (Exception e) {
			System.out.println("测试客户端连接出错：" + e.getMessage());
		}
	}
}

/**
 * Socket客户端
 */
class Client {
	private String host; // IP地址（域名）
	private int port; // 端口号
	public Client(String host, int port) {
		this.host = host;
		this.port = port;
		connectServer(); // 调用连接方法
	}

	// 连接方法
	public void connectServer() {
		try {
			Socket socketConn; // 声明Socket连接
			// 判断IP地址(域名)如果是本机localhost
			if (host.equals("localhost") || host.equals("127.0.0.1")) {
				// 创建本地Socket连接
				socketConn = new Socket(InetAddress.getLocalHost(), port);
			} else { // 创建远程Socket连接
				socketConn = new Socket(InetAddress.getByName(host), port);
			}
			BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)); // 获得从键盘输入的流
			PrintWriter out = new PrintWriter(socketConn.getOutputStream(),true); // 获得服务器写内容的数据流
			BufferedReader in = new BufferedReader(new InputStreamReader
					(socketConn.getInputStream()));// 获得接收服务器发送内容的缓冲流
			// 从服务器获得信息
			System.out.println("服务器信息：" + in.readLine());
			System.out.println("服务器信息：" + in.readLine());
			System.out.print("请输入>"); // 用户输入
			boolean done = false;
			while (!done) {
				String line = stdin.readLine(); // 获得从键盘输入的每行字符
				out.println(line); // 发送到服务端
				if (line.equalsIgnoreCase("quit")) {
					done = true;
				}
				String info = in.readLine(); // 从服务器读取字符串
				System.out.println("服务器信息:" + info);// 显示从服务器发送来的数据
				if (!done) {
					System.out.print("请输入>");
				}
			}
			socketConn.close(); // 关闭资源
		} catch (SecurityException e) { // 捕获安全性错误时引发的异常
			System.out.println("连接服务器出现安全问题！");
		} catch (IOException e) { // 捕获IO流异常
			System.out.println("连接服务器出现I/O错误！");
		}
	}
}