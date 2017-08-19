package java_input_output;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	public static void main(String[] args) {
		File f = new File("f:/test.txt");
		try(FileReader fis = new FileReader(f)){
			char[] all = new char[(int) f.length()];
			fis.read(all);
			for (char b : all) {
				System.out.print(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}