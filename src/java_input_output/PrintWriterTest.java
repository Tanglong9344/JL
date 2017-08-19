package java_input_output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterTest {
	public static void main(String[] args) {
		File f = new File("f:test.txt");
		// 创建文件字符流
		// 缓存流必须建立在一个存在的流的基础上
		try (
				// 创建文件字符流
				FileWriter fw = new FileWriter(f);
				// 缓存流必须建立在一个存在的流的基础上               
				PrintWriter pw = new PrintWriter(fw);               
				) {
				pw.println("I am Chinese!");
				pw.println("我是中国人!");
				pw.println("技术在手，说走就走！");
				pw.flush();//刷新缓存
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
