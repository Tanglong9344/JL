package java_web_server;

import java.io.IOException;
import java.io.InputStream;

/**
 * ������
 *
 * @author ����
 *
 */
public class Request {
	private InputStream is;
	private String uri;

	public Request(InputStream is) {
		this.is = is;
	}

	/**��InputStream�ж�ȡrequest��Ϣ������request�л�ȡuriֵ*/
	public void parse() {
		StringBuffer request = new StringBuffer(2048);
		int i = -1;
		byte[] buffer = new byte[2048];
		try {
			i = is.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
			i = -1;
		}
		for (int j = 0; j < i; j++) {
			request.append((char) buffer[j]);
		}
		System.out.print(request.toString());
		uri = parseUri(request.toString());
	}

	/**
	 * requestString��ʽ���£�
	 * GET /index.html HTTP/1.1
	 * Host: localhost:8080
	 * Connection: keep-alive
	 * Cache-Control: max-age=0
	 * ...
	 * �ú���Ŀ�ľ���Ϊ�˻�ȡ/index.html�ַ���
	 */
	private String parseUri(String requestString) {
		int index1, index2;
		index1 = requestString.indexOf(' ');
		if (index1 != -1) {
			index2 = requestString.indexOf(' ', index1 + 1);
			if (index2 > index1) {
				return requestString.substring(index1 + 1, index2);
			}
		}
		return null;
	}

	public String getUri() {
		return uri;
	}
}