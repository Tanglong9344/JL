package java_input_output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderTest {
	public static void main(String[] args) {
		File f = new File("f:test.txt");
		// 创建文件字符流
		// 缓存流必须建立在一个存在的流的基础上
		try (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr);) {
			while (true) {
				// 一次读一行
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
