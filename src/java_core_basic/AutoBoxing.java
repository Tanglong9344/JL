package java_core_basic;

/**
 * �Զ�װ��Ͳ���
 *
 * @author ����
 */
public class AutoBoxing {
	public static void main(String[] args) {
		//�Զ�װ��
		Integer i = new Integer(1);
		Integer ii = new Integer("1");

		System.out.println("i=" + i);
		System.out.println("ii=" + ii);

		//ֻ��Ϊtrue(���Դ�Сд)ʱ����
		Boolean b1 = new Boolean("True");
		Boolean b2 = new Boolean("yes");
		Boolean b3 = new Boolean(true);

		System.out.println("b1=" + b1);
		System.out.println("b2=" + b2);
		System.out.println("b3=" + b3);

		//��̬����
		Integer i1 = Integer.valueOf(1);
		Integer i2 = Integer.valueOf("1");
		Integer i3 = Integer.valueOf("1",Character.MAX_RADIX);
		Integer i4 = Integer.parseInt("1");
		Double d = new Double("3.14");

		System.out.println("i1=" + i1);
		System.out.println("i2=" + i2);
		System.out.println("i3=" + i3);
		System.out.println("i4=" + i4);
		System.out.println("d=" + d + "\td.intValue()=" + d.intValue());

		System.out.println("int ���ֵ��" + Integer.MAX_VALUE);
		System.out.println("int ��Сֵ��" + Integer.MIN_VALUE);
	}
}