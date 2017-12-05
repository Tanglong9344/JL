package java_core_basic;

import java.util.Base64;

/**
 * Java 编码和解码
 * @author 唐龙
 */
public class Base64Test {
	public static void main(String[] args) {
		String base64String="Base64String";
		System.out.println("初始字符串：" + base64String + "\n");

		//Decoder and Encoder
		//使用Base64.getDecoder().decode()方法
		byte[] decoderResult = Base64.getDecoder().decode(base64String.getBytes());
		System.out.println("Base64 Decoder 解码结果：");
		for(int i = 0;i<decoderResult.length;i++) {
			System.out.printf("byte[%d] = %d %n",i,decoderResult[i]);
		}

		//使用Base64.getEncoder().encodeToString()方法
		String encoderResult = Base64.getEncoder().encodeToString(decoderResult);
		System.out.println("Base64 Encoder编码结果："+encoderResult + "\n");

		//MimeDecoder and MimeEncoder
		//使用Base64.getMimeDecoder().decode()方法
		byte[] mimeDecoderResult = Base64.getMimeDecoder().decode(base64String.getBytes());
		System.out.println("Base64 MimeDecoder解码结果：");
		for(int i = 0;i<mimeDecoderResult.length;i++) {
			System.out.printf("byte[%d] = %d %n",i,mimeDecoderResult[i]);
		}

		//使用Base64.getMimeEncoder().encodeToString()方法
		String mimeEncoderResult = Base64.getMimeEncoder().encodeToString(mimeDecoderResult);
		System.out.println("Base64 MimeEncoder编码结果："+mimeEncoderResult + "\n");

		//UrlDecoder and UrlEncoder
		//使用Base64.getUrlDecoder().decode()方法
		byte[] urlDecoderResult = Base64.getUrlDecoder().decode(base64String.getBytes());
		System.out.println("Base64 UrlDecoder解码结果：");
		for(int i = 0;i<urlDecoderResult.length;i++) {
			System.out.printf("byte[%d] = %d %n",i,urlDecoderResult[i]);
		}

		//使用Base64.getUrlEncoder().encodeToString()方法
		String urlEncoderResult = Base64.getUrlEncoder().encodeToString(mimeDecoderResult);
		System.out.println("Base64 UrlEncoder编码结果："+urlEncoderResult + "\n");
	}
}