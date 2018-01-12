package java_effective_code;

/**
 * The memory of JVM
 *
 * @author ÌÆÁú
 *
 */
public class JVMMemory {
	public static void main(String[] args) {
		final int M = 1024*1024;
		long maxMemory       = Runtime.getRuntime().maxMemory()/M;
		long totalUsedMemory = Runtime.getRuntime().totalMemory()/M;
		System.out.println("MaxMemory      : " + maxMemory + "M");
		System.out.println("TotalUsedMemory: " + totalUsedMemory + "M");

		String s = "";
		for(int i=0;i<10000;i++){
			s += i;
		}
		System.out.println(s);
		totalUsedMemory = Runtime.getRuntime().totalMemory()/M;
		System.out.println("TotalUsedMemory: " + totalUsedMemory + "M");

		for(int i=0;i<10000_0000;i++){
			new String("" + i);
		}
		totalUsedMemory = Runtime.getRuntime().totalMemory()/M;
		System.out.println("TotalUsedMemory: " + totalUsedMemory + "M");
	}
}