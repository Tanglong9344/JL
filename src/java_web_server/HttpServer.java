package java_web_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Java Web 服务器
 *
 * @author 唐龙
 *
 */
public class HttpServer {
	/** 指定HTML和其它文件存放的目录  */
	public static final String WEB_ROOT = "src/java_web_server";

	public static void main(String[] args) {
		System.out.println(WEB_ROOT);
		HttpServer server = new HttpServer();
		// 等待连接请求
		server.await();
	}

	/** 等待链接  */
	@SuppressWarnings("resource")
	public void await() {
		ServerSocket serverSocket = null;
		int port = 8080;
		String ip = "127.0.0.1";
		try {
			//服务器套接字对象
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName(ip));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		System.out.println("Listening...");
		// 循环等待一个请求
		while (true) {
			Socket socket   = null;
			InputStream is  = null;
			OutputStream os = null;
			try {
				//等待连接，连接成功后，返回一个Socket对象
				socket = serverSocket.accept();
				is     = socket.getInputStream();
				os     = socket.getOutputStream();
				// 创建Request对象并解析
				Request request = new Request(is);
				request.parse();

				// 创建 Response 对象
				Response response = new Response(os);
				response.setRequest(request);
				response.sendStaticResource();
				// 关闭 socket 对象
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}
}