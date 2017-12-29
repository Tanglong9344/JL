package java_web_programming;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * URLEncoder
 *
 * @author 唐龙
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
		System.out.println(URLEncoder.encode("杭州杭州杭州","utf-8"));
		System.out.println(URLEncoder.encode("(你还（是那个（哈利波特））)","utf-8"));
		System.out.println(URLEncoder.encode("杭州.杭州.杭州","utf-8"));
		System.out.println(URLEncoder.encode("杭州&杭州&杭州","utf-8"));
		System.out.println(URLEncoder.encode("杭州-杭州-杭州","utf-8"));
	}
}