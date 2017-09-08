package java_reg_exp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest1 {
	private static final String REGEX = "\\bcat\\b";//\b 匹配一个字边界
	private static final String INPUT = "cat cat cat cattie cat";
	public static void main( String args[] ){
		// 按指定模式在字符串查找
		String line = "This order was placed for QT3000! OK?";
		String pattern = "(.*)(\\d+)(.*)";
		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);
		// 现在创建 matcher对象
		Matcher m = r.matcher(line);
		if (m.find()) {
			System.out.println("Found value: " + m.group(0) );//(.*)(\\d+)(.*)
			System.out.println("Found value: " + m.group(1) );//(.*)
			System.out.println("Found value: " + m.group(2) );//(\\d+)
			System.out.println("Found value: " + m.group(3) );//(.*)
		}
		else {
			System.out.println("NO MATCH");
		}

		System.out.println("\n");
		Pattern p = Pattern.compile(REGEX);
		Matcher m2 = p.matcher(INPUT);
		// 获取 matcher 对象
		int count = 0;
		while(m2.find()) {
			count++;
			System.out.println("Match number "+count);
			System.out.println("start(): "+m2.start());
			System.out.println("end(): "+m2.end()+"\n");
		}
	}
}
