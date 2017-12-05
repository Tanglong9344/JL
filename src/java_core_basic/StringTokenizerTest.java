package java_core_basic;

import java.util.StringTokenizer;

/**
 * StringTokenizer类
 *
 * 与String.split()方法相比
 * StringTokenizer在截取字符串中的效率最高。
 * @author 唐龙
 */
public class StringTokenizerTest {
	public static void main(String[] args) {
		String str="qq,qe e,w dh,bj,d, k,ck,h iw,kz, xc n";
		System.out.println("str="+str);

		System.out.println("---------将字符串str按照','分割----------");
		StringTokenizer st = new StringTokenizer(str);
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken(","));//字符串按照','分割
		}

		System.out.println("---------将字符串str按照空格分割----------");
		st = new StringTokenizer(str);
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken(" "));//字符串按照空格分割
		}
	}
}