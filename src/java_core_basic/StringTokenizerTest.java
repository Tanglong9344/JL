package java_core_basic;

import java.util.StringTokenizer;

/**
 * StringTokenizer��
 *
 * ��String.split()�������
 * StringTokenizer�ڽ�ȡ�ַ����е�Ч����ߡ�
 * @author ����
 */
public class StringTokenizerTest {
	public static void main(String[] args) {
		String str="qq,qe e,w dh,bj,d, k,ck,h iw,kz, xc n";
		System.out.println("str="+str);

		System.out.println("---------���ַ���str����','�ָ�----------");
		StringTokenizer st = new StringTokenizer(str);
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken(","));//�ַ�������','�ָ�
		}

		System.out.println("---------���ַ���str���տո�ָ�----------");
		st = new StringTokenizer(str);
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken(" "));//�ַ������տո�ָ�
		}
	}
}