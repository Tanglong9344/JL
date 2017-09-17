package java_web_programming;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class DecoderAndEncoderTest {

	public static void main(String[] args) {
		String str = "�������Ȱ�!!!";
		System.out.println("ԭʼ�ַ���:" + str);
		// ����
		try {
			String strEncode = URLEncoder.encode(str, "utf-8");
			System.out.println("�������ַ���:" + strEncode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// ����
		try {
			String strDecode = URLDecoder.decode(str, "utf-8");
			System.out.println("�������ַ���:" + strDecode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
