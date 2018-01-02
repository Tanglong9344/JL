package bit_operation;

/**
 * Bit operation is more efficient than arithemic operation
 *
 * @author ÌÆÁú
 *
 */
public class BitPerformance {
	public static void main(String[] args) {
		long start,end;
		start = System.nanoTime();
		System.out.println((2)<<10);
		end = System.nanoTime();
		System.out.println("Time: " + (end-start));

		start = System.nanoTime();
		System.out.println(2*1024);
		end = System.nanoTime();
		System.out.println("Time: " + (end-start));
	}
}