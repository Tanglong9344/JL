package java_reg_exp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * replacement using regular expression
 *
 * @author ����
 *
 */
public class RegExpTest4 {
	private static String REGEX = "a*b";
	private static String INPUT = "aabfooaabfooabfoob";
	private static String REPLACE = "-";
	public static void main(String[] args) {
		Pattern p = Pattern.compile(REGEX);
		// ��ȡ matcher����
		Matcher m = p.matcher(INPUT);
		StringBuffer sb = new StringBuffer();
		while(m.find()){
			m.appendReplacement(sb, REPLACE);
		}
		m.appendTail(sb);
		System.out.println(sb.toString());
	}
}