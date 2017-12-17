package java_lamda_expression;

import java.util.List;

/**
 * Condition checker
 *
 * @author ÌÆÁú
 */
public class Checker{
	/**check whether the last char of the String is even number*/
	public boolean check(String str){
		return (str.charAt(str.length()-1))%2 == 0;
	}

	/**
	 * filter elements according to checker
	 * @param Strings: elements need to be filtered
	 * @param checker: filter conditions
	 */
	public static void filter(List<String> strs,Checker checker) {
		for (String str : strs) {
			if(checker.check(str)) {
				System.out.println(str);
			}
		}
	}
}