package java_core_basic;

public class NumberAndString {
	public static void main(String[] args) {
		int i = 5;
		// ��һ���������͵ı���,ת��ΪInteger����
		Integer it = new Integer(i);
		// ��һ��Integer����ת��Ϊһ���������͵�int
		int i2 = it.intValue();
		int i3 = it; // �Զ�����
		Integer it2 = i;// �Զ�װ��
		System.out.println("i=" + i + "\t it=" + it + "\t i2=" + i2 + "\t i3=" + i3 + "\t it2=" + it2);
		System.out.print("it2 instanceof Integer:");
		System.out.println(it2 instanceof Integer);
		System.out.print("it2 instanceof Number:");
		System.out.println(it2 instanceof Number);
		System.out.println("Integer.MAX_VALUE:" + Integer.MAX_VALUE);
		System.out.println("Integer.MIN_VALUE:" + Integer.MIN_VALUE);
		System.out.println("Byte.MAX_VALUE:" + Byte.MAX_VALUE);
		System.out.println("Byte.MIN_VALUE:" + Byte.MIN_VALUE);
		byte b = 1;
		Integer ii = (int) b;
		int iii = 1024;
		Byte bb = (byte) iii;
		System.out.println(ii + "\t" + bb);
		int i5 = 5;
		// ����1
		String str = String.valueOf(i5);
		// ����2
		Integer it5 = i;
		String str2 = it5.toString();
		System.out.println("intToString:" + str + "\tIntegerToString:" + str2);
		System.out.println("Character.MAX_RADIX:" + Character.MAX_RADIX);
		System.out.println("Character.MIN_RADIX:" + Character.MIN_RADIX);
		System.out.println(Integer.min(12, 2));
		System.out.println(Math.min(12, 2));
		String str123 = "123"; // ֻ���������ַ���
		int strToInteger = Integer.parseInt(str123);// parseInt()����
		System.out.print("�ַ���:" + str123);
		System.out.print("\tת��Ϊ����:");
		System.out.println(strToInteger);
		String str111 = "111"; // ֻ���������ַ���
		Double strToDouble = Double.valueOf(str111);// valueOf()����
		System.out.print("�ַ���:" + str111);
		System.out.print("\tת��Ϊ������:");
		System.out.println(strToDouble);
	}
}
