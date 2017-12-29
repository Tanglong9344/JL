package java_web_programming;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * URLEncoder
 *
 * @author ����
 *
 */
public class UrlEncoderTest {
	public static void main(String[] args) throws UnsupportedEncodingException{
		System.out.println(URLEncoder.encode("Hello Hello Hello","utf-8"));
		System.out.println(URLEncoder.encode("Java;Java;Java;","utf-8"));
		System.out.println(URLEncoder.encode("%%%%%#######^^^&&****","utf-8"));
		System.out.println(URLEncoder.encode("123123123","utf-8"));
		System.out.println(URLEncoder.encode("name/password/address","utf-8"));
		System.out.println(URLEncoder.encode("China:Zhejiang:Hangzhou","utf-8"));
		System.out.println(URLEncoder.encode("���ݺ��ݺ���","utf-8"));
		System.out.println(URLEncoder.encode("(�㻹�����Ǹ����������أ���)","utf-8"));
		System.out.println(URLEncoder.encode("����.����.����","utf-8"));
		System.out.println(URLEncoder.encode("����&����&����","utf-8"));
		System.out.println(URLEncoder.encode("����-����-����","utf-8"));
	}
}