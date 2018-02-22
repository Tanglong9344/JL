package java_optimization;

/**
 * CPU 流水线优化
 *
 * @author 唐龙
 *
 */
public class CPUAssembleLine {
	public static void main(String[] args) {
		int N = Integer.MAX_VALUE;
		long start, end;
		start = System.nanoTime();
		test2(N);
		end = System.nanoTime();
		System.out.println("Time: " + (end-start));
		start = System.nanoTime();;
		test1(N);
		end = System.nanoTime();
		System.out.println("Time: " + (end-start));
	}

	/** 嵌套循环 -不能使用CPU流水*/
	private static void test1(int n) {
		int s = 0;
		for(int i=0;i<n;i++) {
			if (i<10000) {
				s += i;
			} else if (i<1000000) {
				s += 100;
			} else {
				s -= 100;
			}
		}
		System.out.println(s);
	}

	/** 拆分为多个循环-可以利用CPU流水 */
	private static void test2(int n) {
		int s = 0;
		for(int i=0;i<10000;i++) {
			s += i;
		}
		for(int i=10000;i<1000000;i++) {
			s += 100;
		}
		for(int i=1000000;i<n;i++) {
			s -= 100;
		}
		System.out.println(s);
	}
}