package java_core_basic;

/**
 * StringBuffer��
 * @author ����
 */
public class StringBufferTest {
	public static void main(String[] args) {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("�����й���");
		System.out.println("After append(\"�����й���\") strBuffer:" + strBuffer);
		System.out.println("strBuffer.toString():" + strBuffer.toString());
		strBuffer.delete(0, 2);
		System.out.println("After delete(0,2) strBuffer:" + strBuffer);
		strBuffer.insert(3, "����");
		System.out.println("After insert(3,\"����\") strBuffer:" + strBuffer);
		strBuffer.reverse();
		System.out.println("After reverse strBuffer:" + strBuffer);
		System.out.println("strBuffer.length():" + strBuffer.length());
		System.out.println("strBuffer.capacity():" + strBuffer.capacity());
	}
}
