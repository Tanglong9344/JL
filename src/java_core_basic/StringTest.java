package java_core_basic;

public class StringTest {
	public static void main(String[] args) {
		String str1 = "the light";
		String str2 = new String(str1);
		// '=='用于判断是否是同一个字符串对象
		System.out.println("str1 == str2:" + str1 == str2);

		String str11 = "the light";
		String str22 = "the light";
		System.out.println("str11 == str22:" + str11 == str22);

		String str111 = "The Light";
		String str222 = "the light";
		//equals 用于判断字符串的值
		System.out.println("str111.equals(str222):" + str111.equals(str222));
		System.out.println("str111.equalsIgnoreCase(str222):" + str111.equalsIgnoreCase(str222));// 忽略大小写进行比较
		//CompareTo()返回从左到右第一对不同字符间的Unicode的差值
		System.out.println("str111.str111.compareTo(str222):" + str111.compareTo(str222));
		System.out.println("str111.compareToIgnoreCase(str222):" + str111.compareToIgnoreCase(str222));
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

		//startsWith前缀
		System.out.println(splitStr.startsWith("Wo."));
		//endsWith后缀
		System.out.println(splitStr.endsWith(".en."));

		String strTest = " I am TangLong,I'm from China. ";
		System.out.println("strTest:" + strTest);
		//toLowerCase
		System.out.println("strTest.toLowerCase():" + strTest.toLowerCase());
		//toUpperCase
		System.out.println("strTest.toUpperCase():" + strTest.toUpperCase());
		//trim
		System.out.println("strTest.trim():" + strTest.trim());
		//replace
		System.out.println("strTest.replace('L', 'l'):" + strTest.replace('L', 'l'));
		//lastIndexOf
		System.out.println("lastIndexOf():"+strTest.substring(strTest.lastIndexOf("T"),strTest.lastIndexOf(",")));
		//toCharArray()
		char [] charArray = strTest.toCharArray();
		System.out.println("strTest.toCharArray():");
		for(char ch:charArray){
			System.out.print(ch+" ");
		}
		System.out.println();

		//format
		System.out.println("String.format(\"ch=%c,isTrue=%b,num=%d,double=%f.\", 'c',true,32,Math.PI):\n"
				+ String.format("ch=%c,isTrue=%b,num=%d,double=%f.", 'c',true,32,Math.PI));
	}
}