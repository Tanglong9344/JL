package java_core_basic;

public class NumberAndString {
	public static void main(String[] args) {
		int i = 5;
		// 把一个基本类型的变量,转换为Integer对象
		Integer it = new Integer(i);
		// 把一个Integer对象，转换为一个基本类型的int
		int i2 = it.intValue();
		int i3 = it; // 自动拆箱
		Integer it2 = i;// 自动装箱
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
		// 方法1
		String str = String.valueOf(i5);
		// 方法2
		Integer it5 = i;
		String str2 = it5.toString();
		System.out.println("intToString:" + str + "\tIntegerToString:" + str2);
		System.out.println("Character.MAX_RADIX:" + Character.MAX_RADIX);
		System.out.println("Character.MIN_RADIX:" + Character.MIN_RADIX);
		System.out.println(Integer.min(12, 2));
		System.out.println(Math.min(12, 2));
		String str123 = "123"; // 只能是数字字符串
		int strToInteger = Integer.parseInt(str123);// parseInt()方法
		System.out.print("字符串:" + str123);
		System.out.print("\t转化为整数:");
		System.out.println(strToInteger);
		String str111 = "111"; // 只能是数字字符串
		Double strToDouble = Double.valueOf(str111);// valueOf()方法
		System.out.print("字符串:" + str111);
		System.out.print("\t转化为浮点数:");
		System.out.println(strToDouble);
	}
}
