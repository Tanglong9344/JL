package java_input_output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		File f= new File("f:/hello.txt");
		try{
			System.out.println("试图打开 f:/hello.txt");
			new FileInputStream(f);
			System.out.println("成功打开");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf.parse("2016-06-03");
			System.out.println("日期为:"+d);
		} catch (FileNotFoundException | ParseException e) {
			if (e instanceof FileNotFoundException) {
				System.out.println("f:/hello.txt");
			}
			if (e instanceof ParseException) {
				System.out.println("日期格式解析错误");
			}
			e.printStackTrace();
		}
		finally{
			System.out.println("无论文件是否存在， 都会执行的代码");
		}
	}
}