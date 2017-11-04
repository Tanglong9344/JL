/**
 * SHA��ȫ��Ϊ��Secure Hash Algorithm��������������ȫ��ϣ�㷨����
 * ��Ҫ����������ǩ����׼��Digital Signature Standard DSS��
 * ���涨�������ǩ���㷨��Digital Signature Algorithm DSA��
 * ���ڳ���С�� 2^64 λ����Ϣ��SHA1 �����һ�� 160 λ����ϢժҪ��
 * ���㷨��˼���ǽ���һ�����ģ�Ȼ����һ�ֲ�����ķ�ʽ����ת����һ��
 * ��ͨ����С�����ģ�Ҳ���Լ򵥵����Ϊȡһ�������루��ΪԤӳ�����Ϣ����
 * ��������ת��Ϊ���Ƚ϶̡�λ���̶���������м�ɢ��ֵ�Ĺ��̡�
 */

package java_other;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SHATest {
	/**
	 * SHA ����
	 * @param s ��Ҫ���ܵ��ַ���
	 * @param choose ����ʵ�����ķ�ʽ
	 * @return ����֮����ַ���
	 * @throws Exception
	 */
	public static String encryptSHA(String s,boolean choose) throws Exception {
		// ��ֵ�ж�
		if(s.equals("") || null == s){
			return "";
		}
		//��������ָ���㷨���Ƶ���ϢժҪ
		MessageDigest sha = null;
		if(choose){
			sha = MessageDigest.getInstance("SHA");
		}else{
			sha = MessageDigest.getInstance("SHA-1");
		}
		//ʹ��ָ�����ֽ������ժҪ����������
		sha.update(s.getBytes());
		// ���ժҪ����
		return (new BigInteger(1,sha.digest()).toString(16));
	}

	// This is a test
	public static void main(String[] args) throws Exception {
		String key = "pwd123";
		System.out.println("SHA  :" + encryptSHA(key,true));
		System.out.println("SHA-1:" + encryptSHA(key,false));
	}
}