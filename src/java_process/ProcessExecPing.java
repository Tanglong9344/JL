package java_process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Process exec  ping
 *
 * @author ����
 *
 */
public class ProcessExecPing {
	public static void main(String[] args) throws IOException {
		Process p = Runtime.getRuntime().exec("ping " + "127.0.0.1");
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			if (line.length() != 0) {
				sb.append(line + "\r\n");
			}
		}
		System.out.println("����ָ��ص���Ϣ�ǣ�");
		System.out.println(sb.toString());
	}
}