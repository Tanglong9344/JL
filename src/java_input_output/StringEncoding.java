package java_input_output;

import java.io.UnsupportedEncodingException;

/**
 * �����ʽ
 * @author ����
 */
public class StringEncoding {
	public static void main(String[] args) {
		String str = "��";
		showCode(str);
	}
	//����
	private static void showCode(String str) {
		String[] encodes = {"BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32"};
		for (String encode : encodes) {
			showCode(str, encode);
		}
	}
	private static void showCode(String str, String encode) {
		try {
			System.out.printf("�ַ�: \"%s\" ���ڱ��뷽ʽ%s�µ�ʮ������ֵ��%n", str, encode);
			byte[] bs = str.getBytes(encode);
			int i;
			for (byte b : bs) {
				i = b&0xff;
				System.out.print(Integer.toHexString(i) + "\t");
			}
			System.out.println();
		} catch (UnsupportedEncodingException e) {
			System.out.printf("UnsupportedEncodingException: %s���뷽ʽ�޷������ַ�%s\n", encode, str);
		}
	}
}