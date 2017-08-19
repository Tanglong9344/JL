package java_input_output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest {
	public static void main(String[] args) {
		File f = new File("f:/test.txt");
		try(FileWriter fis = new FileWriter(f)){
			String str = "我是中国人，I am Chinese！\n";
			fis.write(str.toCharArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
