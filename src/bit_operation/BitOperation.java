package bit_operation;

/**
 * λ����
 *
 * @author ����
 */
public class BitOperation{
	public static void main(String[] args) {
		// bit operation
		int a = 8;
		System.out.println(a<<2);//����
		System.out.println(a>>2);//����
		System.out.println(a>>>2);//�޷�������
		System.out.println(a^2);//���
		System.out.println(a&2);//��
		System.out.println(a|2);//��
		System.out.println(~a);//��

		// combination operators
		a = 8;
		a<<=2;
		System.out.println(a);
		a>>=2;
		System.out.println(a);
		a>>>=2;
		System.out.println(a);
		a^=2;
		System.out.println(a);
		a&=2;
		System.out.println(a);
		a|=2;
		System.out.println(a);
	}
}