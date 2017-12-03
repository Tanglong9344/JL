package java_input_output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File Open and Close
 * @author 唐龙
 */
public class FileOpenClose {
	public static void main(String[] args) throws IOException {
		File f = new File(CommonFileName.fileName);
		FileInputStream fi = null;
		try{
			System.out.println("试图打开 文件："+	CommonFileName.fileName);
			fi  = new FileInputStream(f);
			System.out.println("成功打开");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf.parse("2016-06-03");
			System.out.println("日期为:"+d);
		} catch (FileNotFoundException | ParseException e) {
			if (e instanceof FileNotFoundException) {
				System.out.println("文件:"+CommonFileName.fileName);
			}
			if (e instanceof ParseException) {
				System.out.println("日期格式解析错误");
			}
			e.printStackTrace();
		}
		finally{
			System.out.println("无论文件是否存在， 都会执行的代码");
			if(null != fi){
				fi.close();
			}
		}
	}
}