package java_effective_code;

/**
 * 自动装箱优化测试
 * Long型和long型之间切换的损耗
 * @author 唐龙
 */
public class AutoBoxing {
	public static void main(String[] args) {
		long start, end;
		start = System.nanoTime();
		longSum();
		end = System.nanoTime();
		System.out.println("longSum()用时： " + (end-start) + "ns");

		start = System.nanoTime();
		LongSum();
		end = System.nanoTime();
		System.out.println("LongSum()用时： " + (end-start) + "ns");
	}

	/**sum in long(primitive type)*/
	static void longSum(){
		long sum = 0L;
		for(long i=1;i<Integer.MAX_VALUE;i++){
			sum += i;
		}
		System.out.println("sum: " + sum);
	}

	/**sum in Long(class reference)*/
	static void LongSum(){
		Long sum = 0L;
		for(long i=1;i<Integer.MAX_VALUE;i++){
			sum += i;
		}
		System.out.println("sum: " + sum);
	}
}