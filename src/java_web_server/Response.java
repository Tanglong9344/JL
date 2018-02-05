package java_web_server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 响应类
 *
 * @author 唐龙
 *
 */
public class Response {
	private static final int BUFFER_SIZE = 100;
	Request request;
	OutputStream os;

	public Response(OutputStream os) {
		this.os = os;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	/** 内容响应  */
	public void sendStaticResource() throws IOException {
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try {
			//将web文件写入到OutputStream字节流中
			String path = HttpServer.WEB_ROOT + request.getUri();
			File file = new File(path);
			if (file.exists()) {
				fis = new FileInputStream(file);
				int ch = fis.read(bytes, 0, BUFFER_SIZE);
				while (ch != -1) {
					os.write(bytes, 0, ch);
					ch = fis.read(bytes, 0, BUFFER_SIZE);
				}
			} else {
				// file not found
				String errorMessage = "HTTP/1.1 404 File Not Found\r\n" + "Content-Type: text/html\r\n"
						+ "Content-Length: 23\r\n" + "\r\n" + "<h1>File Not Found</h1>";
				os.write(errorMessage.getBytes());
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
	}
}