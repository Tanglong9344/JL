package java_core_basic;

public class CharTest {
	public static void main(String[] args) {
		char c = 'a';// Ӣ���ַ���aa�Ƿ�
		char cc = '�';// �����ַ����໷Ƿ�
		char ccc = '1';// �����ַ���11�Ƿ�

		System.err.printf("Ӣ���ַ���%c\t �����ַ�:%c\t �����ַ�:%c\n", c, cc, ccc);

		System.out.println("�ж��Ƿ�Ϊ��ĸ��" + Character.isLetter('a'));// �ж��Ƿ�Ϊ��ĸ
		System.out.println("�ж��Ƿ�Ϊ����:" + Character.isDigit('a')); // �ж��Ƿ�Ϊ����
		System.out.println("�Ƿ��ǿհ�:" + Character.isWhitespace(' ')); // �Ƿ��ǿհ�
		System.out.println("�Ƿ��Ǵ�д:" + Character.isUpperCase('a')); // �Ƿ��Ǵ�д
		System.out.println("�Ƿ���Сд:" + Character.isLowerCase('a')); // �Ƿ���Сд

		System.out.println("ת��Ϊ��д:" + Character.toUpperCase('a')); // ת��Ϊ��д
		System.out.println("ת��ΪСд:" + Character.toLowerCase('A')); // ת��ΪСд

		// String a = 'a'; //���ܹ�ֱ�Ӱ�һ���ַ�ת�����ַ���
		System.out.println("ת��Ϊ�ַ���:" + Character.toString('a'));

		String str = " ����,��С��,����,�й���!I am,Bruce Lee,I am,Chinese!";
		System.out.println("�ַ���:" + str);
		System.out.println("ȥ����β�ո�:" + str.trim());// ȥ����β�ո�
		System.out.println("ȫ�����Сд:" + str.toLowerCase());// ȫ�����Сд
		System.out.println("ȫ����ɴ�д:" + str.toUpperCase());// ȫ����ɴ�д
		System.out.println("�ַ�����һ�γ��ֵ�λ��:" + str.indexOf("I am"));
		System.out.println("�ַ������һ�γ��ֵ�λ��:" + str.lastIndexOf("I am"));
		System.out.println("�ַ����Ƿ����I am:" + str.contains("I am"));

		System.out.println("�滻�ַ�����һ�γ��ֵ�λ��:" + str.replaceFirst("I", "��"));
		System.out.println("�滻�ַ������г��ֵ�λ��:" + str.replaceAll("I", "��"));
		System.out.println("�ַ���\"������С��!�����й���!\"��λ��3���ַ�:" + str.charAt(3));
		System.out.println("�ַ���\"������С��!�����й���!\"���Ӵ�(2,5):" + str.substring(2, 5));
		// �ַ����ָ�
		String[] strArr = str.split(",");
		for (String subStr : strArr) {
			System.out.print(subStr + "    ");
		}
		System.out.println();

		char[] charr = str.toCharArray();
		for (int i = 0; i < charr.length; i++) {
			System.out.printf("�ַ�charr[%d]:%c  ", i, charr[i]);
			if (i == charr.length - 1) {
				System.out.println();
			}
		}
	}
}
