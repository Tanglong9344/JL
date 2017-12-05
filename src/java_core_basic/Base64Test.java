package java_core_basic;

import java.util.Base64;

/**
 * Java ����ͽ���
 * @author ����
 */
public class Base64Test {
	public static void main(String[] args) {
		String base64String="Base64String";
		System.out.println("��ʼ�ַ�����" + base64String + "\n");

		//Decoder and Encoder
		//ʹ��Base64.getDecoder().decode()����
		byte[] decoderResult = Base64.getDecoder().decode(base64String.getBytes());
		System.out.println("Base64 Decoder ��������");
		for(int i = 0;i<decoderResult.length;i++) {
			System.out.printf("byte[%d] = %d %n",i,decoderResult[i]);
		}

		//ʹ��Base64.getEncoder().encodeToString()����
		String encoderResult = Base64.getEncoder().encodeToString(decoderResult);
		System.out.println("Base64 Encoder��������"+encoderResult + "\n");

		//MimeDecoder and MimeEncoder
		//ʹ��Base64.getMimeDecoder().decode()����
		byte[] mimeDecoderResult = Base64.getMimeDecoder().decode(base64String.getBytes());
		System.out.println("Base64 MimeDecoder��������");
		for(int i = 0;i<mimeDecoderResult.length;i++) {
			System.out.printf("byte[%d] = %d %n",i,mimeDecoderResult[i]);
		}

		//ʹ��Base64.getMimeEncoder().encodeToString()����
		String mimeEncoderResult = Base64.getMimeEncoder().encodeToString(mimeDecoderResult);
		System.out.println("Base64 MimeEncoder��������"+mimeEncoderResult + "\n");

		//UrlDecoder and UrlEncoder
		//ʹ��Base64.getUrlDecoder().decode()����
		byte[] urlDecoderResult = Base64.getUrlDecoder().decode(base64String.getBytes());
		System.out.println("Base64 UrlDecoder��������");
		for(int i = 0;i<urlDecoderResult.length;i++) {
			System.out.printf("byte[%d] = %d %n",i,urlDecoderResult[i]);
		}

		//ʹ��Base64.getUrlEncoder().encodeToString()����
		String urlEncoderResult = Base64.getUrlEncoder().encodeToString(mimeDecoderResult);
		System.out.println("Base64 UrlEncoder��������"+urlEncoderResult + "\n");
	}
}