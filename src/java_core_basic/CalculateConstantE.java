package java_core_basic;

/**
 * ����E�ļ���
 * @author ����
 */
public class CalculateConstantE {
	public static void main(String[] args) {
		final int N = 100000000;
		//��ʽ E = (1+(1/n))^n
		for(int i=1;i<=N;i++) {
			System.out.println("i="+i+"\t"+Math.pow((1+(double)1/i), i));
		}

		System.out.println("E:"+Math.E);
	}
}
