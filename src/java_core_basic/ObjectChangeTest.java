package java_core_basic;

public class ObjectChangeTest {
	public static void main(String[] args) {
		//�ַ�����������ת��
		String str = "1234";
		System.out.println("str="+str);

		Integer inte = Integer.parseInt(str);//�����������ַ���
		System.out.println("inte="+inte);

		Integer inte1 = Integer.valueOf(str);//�����������ַ���
		System.out.println("inte1="+inte1);

		//�ַ�����������ת��
		Integer intt = 5678;
		System.out.println("\nintt="+intt);

		String strr = String.valueOf(intt);//����ת��
		System.out.println("strr="+strr);

		String strr1 = 5678+"";//����ת��
		System.out.println("strr1="+strr1);
	}
}