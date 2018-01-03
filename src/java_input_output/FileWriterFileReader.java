package java_input_output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * FileWriter and FileReader
 *
 * @author 唐龙
 */
public class FileWriterFileReader {
	public static void main(String[] args) {
		File f = new File(CommonFileName.fileName);
		fileWriter(f);
		fileReader(f);
	}

	// write data
	private static void fileWriter(File f){
		try (
				FileWriter fw = new FileWriter(f);// 创建文件字符流
				PrintWriter pw = new PrintWriter(fw);// 缓存流必须建立在一个存在的流的基础上
				) {
			fw.write("我是唐龙。\n");//FileWriter.write()方式写入
			pw.println("I am Tanglong.");//PrintWriter.println()方式写入
			pw.flush();//刷新缓存
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// read data
	private static void fileReader(File f){
		// 创建文件字符流
		// 缓存流必须建立在一个存在的流的基础上
		String line = null;
		try (
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);) {
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}