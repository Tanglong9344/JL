package java_common;

import java.io.UnsupportedEncodingException;

/**
 * String encoding transform
 * 1. gbk2312 <==> iso-8859-1
 *
 * @author tanglong
 *
 */
public class StringEncodeTransform {
	public static void main(String[] args) {
		String srcString = "ÌÆÁú";
		System.out.println("source : " + srcString);
		System.out.println("gbk2iso: " + gbk2iso(srcString));
		System.out.println("iso2gbk: " + iso2gbk(gbk2iso(srcString)));
	}

	/** gbk2312 to ISO-8859-1 */
	public static String gbk2iso(String src) {
		try {
			return new String(src.getBytes("GB2312"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return src;
	}

	/** ISO-8859-1 to gbk2312*/
	public static String iso2gbk(String src) {
		try {
			return new String(src.getBytes("ISO-8859-1"), "GB2312");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return src;
	}
}