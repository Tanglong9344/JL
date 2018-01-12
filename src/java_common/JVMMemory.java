package java_common;

/**
 * The memory of JVM(M)
 *
 * @author ����
 *
 */
public class JVMMemory {
	private final static int M = 1024*1024;
	static long maxMemory       = Runtime.getRuntime().maxMemory()/M;
	static long totalUsedMemory = Runtime.getRuntime().totalMemory()/M;
}