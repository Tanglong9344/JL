package java_reg_exp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Matcher match
 *
 * @author ����
 *
 */
public class RegExpTest2 {
	private static final String REGEX = "foo";
	private static final String INPUT = "fooooooooooooooooo";
	private static Pattern pattern;
	private static Matcher matcher;
	public static void main( String args[] ){
		pattern = Pattern.compile(REGEX);
		matcher = pattern.matcher(INPUT);
		System.out.println("Current REGEX is: " + REGEX);
		System.out.println("Current INPUT is: " + INPUT);
		System.out.println("lookingAt(): " + matcher.lookingAt());//ƥ�䲿������
		System.out.println("matches(): " + matcher.matches());//ƥ��ȫ������
	}
}