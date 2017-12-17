package java_optimization;

/**
 * 比较优化
 * 比较s1和s2(允许为null)
 * @author 唐龙
 */
public class Comparison {
	public static void main(String[] args) {
		String s1 = null;
		String s2 = "Java";
		System.out.println("cmp1: " + cmp1(s1,s2));
		System.out.println("cmp2: " + cmp2(s1,s2));
		System.out.println("cmp3: " + cmp3(s1,s2));
	}

	// 比较方式1
	static boolean cmp1(String s1,String s2){
		if(s1 == null){
			if(s2 == null) {
				return true;
			}
		}else{
			return s1.equals(s2);
		}
		return false;
	}

	// 比较方式2
	static boolean cmp2(String s1,String s2){
		return s1 == null? s2 == null : s1.equals(s2);
	}

	// 比较方式3
	static boolean cmp3(String s1,String s2){
		return ((s1 == null && s2 == null) || (s1 != null && s1.equals(s2)));
	}
}