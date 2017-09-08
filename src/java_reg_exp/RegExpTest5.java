package java_reg_exp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest5 {
	/**
	 * 正则表达式匹配
	 * 以3个数字开头，以‘_’连接，以8个数字结尾
	 * 或者
	 * 以4个数字开头，以‘_’连接，以7个数字结尾
	 * 的数字串
	 * */
	private static String REG_EXP = "^([0-9]{3}-?[0-9]{8})|([0-9]{4}-?[0-9]{7})$";
	// 使用String类中的matches方法利用正则表达式匹配的方法
	public static boolean useMatches(String phoneNum) {
		if (phoneNum != null) {
			return phoneNum.matches(REG_EXP);
		} else {
			return false;
		}
	}
	//使用Pattern的compile方法和Matcher的matcher方法共同匹配
	public static boolean usePattern(String phoneNum) {
		Pattern p = Pattern.compile(REG_EXP);
		// 创建一个Matcher，并进行精确匹配
		Matcher m = p.matcher(phoneNum);
		return m.matches();
	}
	public static void main(String[] args) {
		String phoneNum = "210-12345678";
		System.out.println(phoneNum + " 是一个合法的电话号码格式吗? "
				+ RegExpTest5.useMatches(phoneNum));
		System.out.println(phoneNum + " 是一个合法的电话号码格式吗? "
				+ RegExpTest5.usePattern(phoneNum));

		phoneNum = "2103-1234567";
		System.out.println(phoneNum + " 是一个合法的电话号码格式吗? "
				+ RegExpTest5.useMatches(phoneNum));
		System.out.println(phoneNum + " 是一个合法的电话号码格式吗? "
				+ RegExpTest5.usePattern(phoneNum));

		phoneNum = "2103-1234";
		System.out.println(phoneNum + " 是一个合法的电话号码格式吗? "
				+ RegExpTest5.useMatches(phoneNum));
		System.out.println(phoneNum + " 是一个合法的电话号码格式吗? "
				+ RegExpTest5.usePattern(phoneNum));
	}
}