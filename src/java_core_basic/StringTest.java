package java_core_basic;

public class StringTest {
	public static void main(String[] args) {
		String str1 = "the light";
		String str2 = new String(str1);
		// ==用于判断是否是同一个字符串对象
		System.out.print("str1 == str2:");
		System.out.println(str1 == str2);
		String str11 = "the light";
		String str22 = "the light";
		System.out.print("str11 == str22:");
		System.out.println(str11 == str22);
		String str111 = "The Light";
		String str222 = "the light";
		System.out.println("str111.equals(str222):" + str111.equals(str222));
		System.out.println("str111.equalsIgnoreCase(str222):" + str111.equalsIgnoreCase(str222));// 忽略大小写进行比较
		System.out.println("str111.startsWith(\"the\"):" + str111.startsWith("the"));
		System.out.println("str111.endsWith(\"ght\"):" + str111.endsWith("ght"));
	}
}
