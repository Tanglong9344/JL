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

		// �ⲿ��ֱ���õ�ϵͳ�ڴ棬���Զ�JVM���ڴ�û��Ӱ��
		ByteBuffer directBuffer = ByteBuffer.allocateDirect(102400);
		System.out.println("directBuffer = " + directBuffer);
		System.out.println("After direct alocate:" + Runtime.getRuntime().freeMemory());

		// write into buffer
		buffer.put((byte) 1);
		// read from buffer
		System.out.println(buffer);
		System.out.println(buffer.get(0));

		// wrap
		// 1.position:��ǰ��ȡ��λ��
		// 2.capacity:��ʼ��buffer����
		// 3.limit:���ݶ�д�ı߽�
		byte[] bytes = new byte[32];
		buffer = ByteBuffer.wrap(bytes);
		System.out.println(buffer);

		buffer = ByteBuffer.wrap(bytes, 10, 10);
		System.out.println(buffer);
	}
}