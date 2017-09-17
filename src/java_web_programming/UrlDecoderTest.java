package java_web_programming;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

//下载的页面不丢失链接
public class UrlDecoderTest {
	public static void main(String[] args) throws UnsupportedEncodingException{
		System.out.println(URLEncoder.encode("This string has spaces","utf-8"));
		System.out.println(URLEncoder.encode("This*string*has*asterisks","utf-8"));
		System.out.println(URLEncoder.encode("This%string%has%persent%signs","utf-8"));
		System.out.println(URLEncoder.encode("This+string+has+pulses","utf-8"));
		System.out.println(URLEncoder.encode("This/string/has/slashes","utf-8"));
		System.out.println(URLEncoder.encode("This:string:has:colors","utf-8"));
		System.out.println(URLEncoder.encode("This-string-has-tildes","utf-8"));
		System.out.println(URLEncoder.encode("This(string)has(parentheses)","utf-8"));
		System.out.println(URLEncoder.encode("This.string.has.periods","utf-8"));
		System.out.println(URLEncoder.encode("This&string&has&ampersands","utf-8"));
		System.out.println(URLEncoder.encode("This&string&has&ampersands","utf-8"));
	}
}