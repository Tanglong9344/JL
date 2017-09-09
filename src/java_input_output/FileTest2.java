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
			System.out.println("��ͼ�� f:/hello.txt");
			new FileInputStream(f);
			System.out.println("�ɹ���");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf.parse("2016-06-03");
			System.out.println("����Ϊ:"+d);
		} catch (FileNotFoundException | ParseException e) {
			if (e instanceof FileNotFoundException) {
				System.out.println("f:/hello.txt");
			}
			if (e instanceof ParseException) {
				System.out.println("���ڸ�ʽ��������");
			}
			e.printStackTrace();
		}
		finally{
			System.out.println("�����ļ��Ƿ���ڣ� ����ִ�еĴ���");
		}
	}
}