package java_collection;

/**
 * StringBuilder �����̰߳�ȫ�ģ�����ڲ����ϻ���̰߳�ȫ��StringBuffer��
 */
public class StringBuilderTest {
	public static void main(String[] args) {
		final int N = 1000_000;
		StringBuffer sb1 = new StringBuffer();
		long start = System.currentTimeMillis();
		for(int i=0;i<N;i++){
			sb1.append("aaa");
		}
		long end = System.currentTimeMillis();
		System.out.printf("%s����%d��\"append\"��������ʱ:%dms\n","StringBuffer",N,end-start);

		StringBuilder sb2 = new StringBuilder();
		start = System.currentTimeMillis();
		for(int i=0;i<N;i++){
			sb2.append("aaa");
		}
		end = System.currentTimeMillis();
		System.out.printf("%s����%d��\"append\"��������ʱ:%d\n","StringBuilder",N,end-start);
	}
}