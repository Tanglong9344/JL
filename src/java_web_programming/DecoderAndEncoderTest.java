package java_web_programming;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class DecoderAndEncoderTest {

	public static void main(String[] args) {
		String str = "今天真热啊!!!";
		System.out.println("原始字符串:" + str);
		// 编码
		try {
			String strEncode = URLEncoder.encode(str, "utf-8");
			System.out.println("编码后的字符串:" + strEncode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 解码
		try {
			String strDecode = URLDecoder.decode(str, "utf-8");
			System.out.println("解码后的字符串:" + strDecode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
