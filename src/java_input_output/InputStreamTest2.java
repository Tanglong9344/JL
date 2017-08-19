package java_input_output;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamTest2 {
	public static void main(String[] args) {
		try {
			File f = new File("f:/test.txt");
			// 创建基于文件的输入流
			FileInputStream fis = new FileInputStream(f);
			//文件长度
			System.out.println("文件长度:"+f.length());
			//创建字节数组，其长度就是文件的长度
			byte[] all =new byte[(int) f.length()];
			//以字节流的形式读取文件所有内容
			fis.read(all);
			for (byte b : all) {
				//打印出来是65 66
				System.out.println(b);
			}
			//每次使用完流，都应该进行关闭
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
