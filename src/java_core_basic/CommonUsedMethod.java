package java_core_basic;

/**
 * 常用方法
 * @author 唐龙
 */
public class CommonUsedMethod {
	public static void main(String[] args) {
		char ch1 = '3';
		char ch2 = 'b';
		System.out.println("'3'是数字：" + Character.isDigit(ch1));
		System.out.println("'3'是字母：" + Character.isLetter(ch1));
		System.out.println("'3'是字母或数字：" + Character.isLetterOrDigit(ch1));

		System.out.println("'b'是数字：" + Character.isDigit(ch2));
		System.out.println("'b'是字母：" + Character.isLetter(ch2));
		System.out.println("'b'是字母或数字：" + Character.isLetterOrDigit(ch2));

		char ch3 = 'a';
		char ch4 = 'A';
		System.out.println("'a'是小写：" + Character.isLowerCase(ch3));
		System.out.println("'a'是大写：" + Character.isUpperCase(ch3));
		System.out.println("'a'转为大写：" + Character.toUpperCase(ch3));

		System.out.println("'A'是小写：" + Character.isLowerCase(ch4));
		System.out.println("'A'是大写：" + Character.isUpperCase(ch4));
		System.out.println("'A'转为小写：" + Character.toLowerCase(ch4));

		char ch5 = ' ';//空格
		char ch6 = '	';//tab
		System.out.println("' '是空白字符：" + Character.isSpaceChar(ch5));
		System.out.println("'	'是空白字符：" + Character.isSpaceChar(ch6));
	}
}