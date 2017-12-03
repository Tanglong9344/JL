package java_input_output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * InputStream Encoding
 * @author 唐龙
 */
public class InputStreamEncoding {
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		File f = new File(CommonFileName.fileName);
		System.out.println("默认编码方式:"+Charset.defaultCharset());
		//FileReader得到的是将字节根据某种编码识别成的字符
		//FileReader使用的编码方式是Charset.defaultCharset()的返回值
		try (FileReader fr = new FileReader(f)) {
			char[] cs = new char[(int) f.length()];
			fr.read(cs);
			System.out.printf("FileReader会使用默认的编码方式%s,识别出来的字符是：%n",Charset.defaultCharset());
			System.out.println(new String(cs));
			System.out.println("-----------end----------");
		} catch (IOException e) {
			e.printStackTrace();
		}

		//FileReader不能手动设置编码方式，只能使用InputStreamReader来代替
		try (InputStreamReader isr = new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8"))){
			char[] cs = new char[(int) f.length()];
			isr.read(cs);
			System.out.printf("InputStreamReader 指定编码方式UTF-8,识别出来的字符是：%n");
			System.out.println(new String(cs));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}