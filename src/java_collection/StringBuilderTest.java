package java_collection;

/**
 * StringBuilder 不是线程安全的，因此在操作上会比线程安全的StringBuffer快
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
		System.out.printf("%s进行%d次\"append\"操作共耗时:%dms\n","StringBuffer",N,end-start);

		StringBuilder sb2 = new StringBuilder();
		start = System.currentTimeMillis();
		for(int i=0;i<N;i++){
			sb2.append("aaa");
		}
		end = System.currentTimeMillis();
		System.out.printf("%s进行%d次\"append\"操作共耗时:%d\n","StringBuilder",N,end-start);
	}
}