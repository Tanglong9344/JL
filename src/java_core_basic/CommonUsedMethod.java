package java_core_basic;

/**
 * ���÷���
 * @author ����
 */
public class CommonUsedMethod {
	public static void main(String[] args) {
		char ch1 = '3';
		char ch2 = 'b';
		System.out.println("'3'�����֣�" + Character.isDigit(ch1));
		System.out.println("'3'����ĸ��" + Character.isLetter(ch1));
		System.out.println("'3'����ĸ�����֣�" + Character.isLetterOrDigit(ch1));

		System.out.println("'b'�����֣�" + Character.isDigit(ch2));
		System.out.println("'b'����ĸ��" + Character.isLetter(ch2));
		System.out.println("'b'����ĸ�����֣�" + Character.isLetterOrDigit(ch2));

		char ch3 = 'a';
		char ch4 = 'A';
		System.out.println("'a'��Сд��" + Character.isLowerCase(ch3));
		System.out.println("'a'�Ǵ�д��" + Character.isUpperCase(ch3));
		System.out.println("'a'תΪ��д��" + Character.toUpperCase(ch3));

		System.out.println("'A'��Сд��" + Character.isLowerCase(ch4));
		System.out.println("'A'�Ǵ�д��" + Character.isUpperCase(ch4));
		System.out.println("'A'תΪСд��" + Character.toLowerCase(ch4));

		char ch5 = ' ';//�ո�
		char ch6 = '	';//tab
		System.out.println("' '�ǿհ��ַ���" + Character.isSpaceChar(ch5));
		System.out.println("'	'�ǿհ��ַ���" + Character.isSpaceChar(ch6));
	}
}