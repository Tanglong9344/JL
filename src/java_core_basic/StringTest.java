package java_core_basic;

public class StringTest {
	public static void main(String[] args) {
		String str1 = "the light";
		String str2 = new String(str1);

		// '=='用于判断是否是同一个字符串对象
		System.out.print("str1 == str2:");
		System.out.println(str1 == str2);
		String str11 = "the light";
		String str22 = "the light";
		System.out.print("str11 == str22:");
		System.out.println(str11 == str22);
		String str111 = "The Light";
		String str222 = "the light";
		//equals 用于判断字符串的值
		System.out.println("str111.equals(str222):" + str111.equals(str222));
		System.out.println("str111.equalsIgnoreCase(str222):" + str111.equalsIgnoreCase(str222));// 忽略大小写进行比较
		System.out.println("str111.startsWith(\"the\"):" + str111.startsWith("the"));
		System.out.println("str111.endsWith(\"ght\"):" + str111.endsWith("ght"));

		String week="一二三四五六日";
		int i;
		//charAt()
		for(i=0;i<week.length();i++){
			System.out.println(week.charAt(i));
		}

		//subString()
		for(i=0;i<week.length();i++){
			System.out.println(week.substring(i,i+1));
		}

		//split()方法
		String splitStr="Wo.shi.zh.o.ng.r.en.";
		System.out.println(splitStr);
		String [] splitStrArr = splitStr.split("\\.");//.是转义字符，必须加上\\
		System.out.println("数组长度："+splitStrArr.length);
		for(i=0;i<splitStrArr.length;i++){
			System.out.println(splitStrArr[i]);
		}
		//matches()方法
		System.out.println(splitStr.matches("^Wo\\.shi[a-z(\\.)]*$"));
	}
}
