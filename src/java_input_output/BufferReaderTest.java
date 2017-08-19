package java_input_output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderTest {
	public static void main(String[] args) {
		File f = new File("f:test.txt");
		// �����ļ��ַ���
		// ���������뽨����һ�����ڵ����Ļ�����
		try (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr);) {
			while (true) {
				// һ�ζ�һ��
				String line = br.readLine();
				if (null == line)
					break;
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
