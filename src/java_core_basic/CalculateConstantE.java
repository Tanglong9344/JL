package java_core_basic;

/**
 * 常量E的计算
 * @author 唐龙
 */
public class CalculateConstantE {
	public static void main(String[] args) {
		final int N = 100000000;
		//公式 E = (1+(1/n))^n
		for(int i=1;i<=N;i++) {
			System.out.println("i="+i+"\t"+Math.pow((1+(double)1/i), i));
		}

		System.out.println("E:"+Math.E);
	}
}
