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
			System.out.println("测试服务器端监听出错：" + e.getMessage());
		} finally {
			server.start();
		}
	}
}

/** Socket服务器端 */
class Server {
	private int port; // 端口
	public Server(int port) throws IOException {
		this.port = port;
		start(); // 调用启动服务器端的方法
	}

	// 处理信息
	public String infoUpperCase(String line) {
		return line.toUpperCase(); // 将字符串大写
	}

	// 启动服务器端
	public void start() throws IOException {
		ServerSocket serverSocket = null;
		try {
			// 根据端口创建服务器端Socket对象
			serverSocket = new ServerSocket(port);
			// 显示连接信息
			System.out.println("服务器已启动，监听端口号为：" + port);
			System.out.println("正在等待客户端连接.........");
			// 挂起等待客户的请求
			Socket socketAccept = serverSocket.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader
					(socketAccept.getInputStream()));// 获取读取客户端的数据流
			// 获取写往客户端的数据输出流,true:自动刷新
			PrintWriter out = new PrintWriter(socketAccept.getOutputStream(),true);
			out.println("服务器端连接成功........."); // 向客户发送连接信息
			out.println("输入quit断开与服务器的连接");
			boolean done = false;
			while (!done) {
				String line = in.readLine(); // 读取客户端每行的内容
				if (line == null) { // 没有写则不读取
					done = true;
				} else {
					// 显示客户端发送的内容
					System.out.println("来自客户端的信息：" + line);
					// 信息处理
					String message = infoUpperCase(line);
					// 向客户端发送信息
					out.println("来自服务器端的信息：" + message);
					if (line.trim().equals("quit")) {
						done = true;
					}
				}
			}
			socketAccept.close(); // 关闭通信资源
		} catch (Exception e) {
			System.out.println("启动服务器端出现错误：" + e.getMessage());
		} finally {
			serverSocket.close();
		}
	}
}