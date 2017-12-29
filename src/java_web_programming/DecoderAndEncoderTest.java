package java_web_programming;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Decoder and Decoder in Java
 *
 * @author ÌÆÁú
 *
 */
public class DecoderAndEncoderTest {
	public static void main(String[] args) {
		String str = "ÌÆÁú¡£¡£¡£";
		System.out.println("Old str: " + str);

		// encoder
		try {
			String strEncode = URLEncoder.encode(str, "utf-8");
			System.out.println("After encoder: " + strEncode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// decoder
		try {
			String strDecode = URLDecoder.decode(str, "utf-8");
			System.out.println("After decoder: " + strDecode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}