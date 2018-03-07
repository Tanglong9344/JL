package java_core_basic;

import java.nio.ByteBuffer;

/**
 * Test for ByteBuffer
 *
 * @author tanglong
 *
 */
public class ByteBufferTest {
	public static void main(String[] args) {
		// alocate
		System.out.println("Before alocate:" + Runtime.getRuntime().freeMemory());
		ByteBuffer buffer = ByteBuffer.allocate(102400);
		System.out.println("buffer = " + buffer);

		System.out.println("After alocate:" + Runtime.getRuntime().freeMemory());

		// 这部分直接用的系统内存，所以对JVM的内存没有影响
		ByteBuffer directBuffer = ByteBuffer.allocateDirect(102400);
		System.out.println("directBuffer = " + directBuffer);
		System.out.println("After direct alocate:" + Runtime.getRuntime().freeMemory());

		// write into buffer
		buffer.put((byte) 1);
		// read from buffer
		System.out.println(buffer);
		System.out.println(buffer.get(0));

		// wrap
		// 1.position:当前读取的位置
		// 2.capacity:初始化buffer容量
		// 3.limit:数据读写的边界
		byte[] bytes = new byte[32];
		buffer = ByteBuffer.wrap(bytes);
		System.out.println(buffer);

		buffer = ByteBuffer.wrap(bytes, 10, 10);
		System.out.println(buffer);
	}
}