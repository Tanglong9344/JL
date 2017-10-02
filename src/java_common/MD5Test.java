package java_common;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Test {
	/**
	 * digest()���������ַ���s��md5��ϣֵ����16λ ��ʮ�����ƣ��൱��8���ַ���
	 * BigInteger��8���ַ����ɵ��ַ���ת����16λ��ʮ�����ƣ� �����ַ�������ʾ��
	 * �Ӷ��õ��ַ�����ʽ�Ĺ�ϣֵ
	 */
	public static String makeMD5(String s) {
		try {
			// ����һ��MD5���ܼ���ժҪ
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes());
			return (new BigInteger(1,md.digest()).toString(16));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	//test
	public static void main(String[] args) {
		String password = "pwd123";
		System.out.println("���롮" + password + "������MD5���ܺ�Ϊ��\n" + makeMD5(password));
	}
}