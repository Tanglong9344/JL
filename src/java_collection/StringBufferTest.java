package java_collection;

public class StringBufferTest {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("StingBuffer!");
		System.out.println(sb.toString());

		//修改第一个字符
		sb.setCharAt(0,'s');
		System.out.println(sb.toString());

		//修改最后一个字符
		sb.setCharAt(sb.length()-1,'s');
		System.out.println(sb.toString());

		//在最前面插入数据
		sb.insert(0, "We are ");
		System.out.println(sb.toString());

		//在最后面插入数据
		sb.insert(sb.length(), ",good day! ");
		System.out.println(sb.toString());

		//删除数据
		sb.delete(0,sb.length());
		System.out.println(sb.toString());
		System.out.println(sb.capacity());//容量

		sb.append("aaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaa");
		System.out.println(sb.toString());
		System.out.println(sb.capacity());//容量
	}
}