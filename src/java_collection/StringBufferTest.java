package java_collection;

public class StringBufferTest {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("StingBuffer!");
		System.out.println(sb.toString());

		//�޸ĵ�һ���ַ�
		sb.setCharAt(0,'s');
		System.out.println(sb.toString());

		//�޸����һ���ַ�
		sb.setCharAt(sb.length()-1,'s');
		System.out.println(sb.toString());

		//����ǰ���������
		sb.insert(0, "We are ");
		System.out.println(sb.toString());

		//��������������
		sb.insert(sb.length(), ",good day! ");
		System.out.println(sb.toString());

		//ɾ������
		sb.delete(0,sb.length());
		System.out.println(sb.toString());
		System.out.println(sb.capacity());//����

		sb.append("aaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaa");
		System.out.println(sb.toString());
		System.out.println(sb.capacity());//����
	}
}