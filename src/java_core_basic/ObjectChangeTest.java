package java_core_basic;

public class ObjectChangeTest {
	public static void main(String[] args) {
		//字符串到整数的转换
		String str = "1234";
		System.out.println("str="+str);

		Integer inte = Integer.parseInt(str);//必须是数字字符串
		System.out.println("inte="+inte);

		Integer inte1 = Integer.valueOf(str);//必须是数字字符串
		System.out.println("inte1="+inte1);

		//字符串到整数的转换
		Integer intt = 5678;
		System.out.println("\nintt="+intt);

		String strr = String.valueOf(intt);//方法转换
		System.out.println("strr="+strr);

		String strr1 = 5678+"";//运算转换
		System.out.println("strr1="+strr1);
	}
}