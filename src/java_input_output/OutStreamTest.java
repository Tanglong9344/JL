package java_input_output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutStreamTest {
	public static void main(String[] args) {
		try {
			// 准备文件lol2.txt其中的内容是空的
			File f = new File("f:/lol2.txt");
			// 准备长度是2的字节数组，用88,89初始化，其对应的字符分别是X,Y
			byte data[] = {88,89,65};
			// 创建基于文件的输出流
			FileOutputStream fos = new FileOutputStream(f);
			// 把数据写入到输出流
			fos.write(data);
			// 关闭输出流
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
