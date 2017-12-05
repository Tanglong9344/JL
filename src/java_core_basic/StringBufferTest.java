package java_core_basic;

/**
 * StringBuffer类
 * @author 唐龙
 */
public class StringBufferTest {
	public static void main(String[] args) {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("我是中国人");
		System.out.println("After append(\"我是中国人\") strBuffer:" + strBuffer);
		System.out.println("strBuffer.toString():" + strBuffer.toString());
		strBuffer.delete(0, 2);
		System.out.println("After delete(0,2) strBuffer:" + strBuffer);
		strBuffer.insert(3, "是我");
		System.out.println("After insert(3,\"是我\") strBuffer:" + strBuffer);
		strBuffer.reverse();
		System.out.println("After reverse strBuffer:" + strBuffer);
		System.out.println("strBuffer.length():" + strBuffer.length());
		System.out.println("strBuffer.capacity():" + strBuffer.capacity());
	}
}
