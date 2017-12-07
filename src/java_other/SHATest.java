package java_other;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * SHA��ȫ��Ϊ��Secure Hash Algorithm��������������ȫ��ϣ�㷨����
 * ��Ҫ����������ǩ����׼��Digital Signature Standard DSS��
 * ���涨�������ǩ���㷨��Digital Signature Algorithm DSA��
 * ���ڳ���С�� 2^64 λ����Ϣ��SHA1 �����һ�� 160 λ����ϢժҪ��
 * ���㷨��˼���ǽ���һ�����ģ�Ȼ����һ�ֲ�����ķ�ʽ����ת����һ��
 * ��ͨ����С�����ģ�Ҳ���Լ򵥵����Ϊȡһ�������루��ΪԤӳ�����Ϣ����
 * ��������ת��Ϊ���Ƚ϶̡�λ���̶���������м�ɢ��ֵ�Ĺ��̡�
 */
public class SHATest {
	public static void main(String[] args) throws Exception {
		String key = "pwd123";
		System.out.println("SHA  :" + encryptSHA(key,true));
		System.out.println("SHA-1:" + encryptSHA(key,false));
	}

	public static String encryptSHA(String s,boolean cho) throws Exception {
		// ��ֵ�ж�
		if(s.equals("") || null == s){
			return "";
		}
		//��������ָ���㷨���Ƶ���ϢժҪ
		MessageDigest md = cho?MessageDigest.getInstance("SHA"):MessageDigest.getInstance("SHA-1");
		//ʹ��ָ�����ֽ������ժҪ����������
		md.update(s.getBytes());
		// ���ժҪ����
		return (new BigInteger(1,md.digest()).toString(16));
	}
}