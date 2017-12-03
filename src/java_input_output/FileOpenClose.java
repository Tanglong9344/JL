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
 * @author ����
 */
public class FileOpenClose {
	public static void main(String[] args) throws IOException {
		File f = new File(CommonFileName.fileName);
		FileInputStream fi = null;
		try{
			System.out.println("��ͼ�� �ļ���"+	CommonFileName.fileName);
			fi  = new FileInputStream(f);
			System.out.println("�ɹ���");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = sdf.parse("2016-06-03");
			System.out.println("����Ϊ:"+d);
		} catch (FileNotFoundException | ParseException e) {
			if (e instanceof FileNotFoundException) {
				System.out.println("�ļ�:"+CommonFileName.fileName);
			}
			if (e instanceof ParseException) {
				System.out.println("���ڸ�ʽ��������");
			}
			e.printStackTrace();
		}
		finally{
			System.out.println("�����ļ��Ƿ���ڣ� ����ִ�еĴ���");
			if(null != fi){
				fi.close();
			}
		}
	}
}