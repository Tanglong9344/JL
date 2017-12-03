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
 * @author ����
 */
public class InputStreamEncoding {
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		File f = new File(CommonFileName.fileName);
		System.out.println("Ĭ�ϱ��뷽ʽ:"+Charset.defaultCharset());
		//FileReader�õ����ǽ��ֽڸ���ĳ�ֱ���ʶ��ɵ��ַ�
		//FileReaderʹ�õı��뷽ʽ��Charset.defaultCharset()�ķ���ֵ
		try (FileReader fr = new FileReader(f)) {
			char[] cs = new char[(int) f.length()];
			fr.read(cs);
			System.out.printf("FileReader��ʹ��Ĭ�ϵı��뷽ʽ%s,ʶ��������ַ��ǣ�%n",Charset.defaultCharset());
			System.out.println(new String(cs));
			System.out.println("-----------end----------");
		} catch (IOException e) {
			e.printStackTrace();
		}

		//FileReader�����ֶ����ñ��뷽ʽ��ֻ��ʹ��InputStreamReader������
		try (InputStreamReader isr = new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8"))){
			char[] cs = new char[(int) f.length()];
			isr.read(cs);
			System.out.printf("InputStreamReader ָ�����뷽ʽUTF-8,ʶ��������ַ��ǣ�%n");
			System.out.println(new String(cs));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}