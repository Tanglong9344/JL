package bit_operation;

/**
 * λ����˳�
 * λ�Ƶ�Ч��Ҫ��ֱ�ӽ��г˳������Ч�ʸ�
 *
 * @author ����
 */
public class BitMove extends Object{
	public static void main(String[] args) throws CloneNotSupportedException {
		//�˷�
		System.out.println("9*8 = " + 9*8);
		System.out.printf("9<<3 = %d%n",9<<3);

		//����
		System.out.println("9/4 = " + 9/4);
		System.out.printf("9>>2 = %d%n",9>>2);

		//��2�ı���
		System.out.println("9*7 = " + 9*7);
		System.out.printf("(9<<3)-9 = %d%n",(9<<3)-9);
	}
}