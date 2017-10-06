package java_core_basic;

public class CharTest {
	public static void main(String[] args) {
		char c = 'a';// 英文字符，aa非法
		char cc = '嗷';// 中文字符，嗷嗷非法
		char ccc = '1';// 数字字符，11非法

		System.err.printf("英文字符：%c\t 中文字符:%c\t 数字字符:%c\n", c, cc, ccc);

		System.out.println("判断是否为字母：" + Character.isLetter('a'));// 判断是否为字母
		System.out.println("判断是否为数字:" + Character.isDigit('a')); // 判断是否为数字
		System.out.println("是否是空白:" + Character.isWhitespace(' ')); // 是否是空白
		System.out.println("是否是大写:" + Character.isUpperCase('a')); // 是否是大写
		System.out.println("是否是小写:" + Character.isLowerCase('a')); // 是否是小写

		System.out.println("转换为大写:" + Character.toUpperCase('a')); // 转换为大写
		System.out.println("转换为小写:" + Character.toLowerCase('A')); // 转换为小写

		// String a = 'a'; //不能够直接把一个字符转换成字符串
		System.out.println("转换为字符串:" + Character.toString('a'));

		String str = " 我是,李小龙,我是,中国人!I am,Bruce Lee,I am,Chinese!";
		System.out.println("字符串:" + str);
		System.out.println("去掉首尾空格:" + str.trim());// 去掉首尾空格
		System.out.println("全部变成小写:" + str.toLowerCase());// 全部变成小写
		System.out.println("全部变成大写:" + str.toUpperCase());// 全部变成大写
		System.out.println("字符串第一次出现的位置:" + str.indexOf("I am"));
		System.out.println("字符串最后一次出现的位置:" + str.lastIndexOf("I am"));
		System.out.println("字符串是否包含I am:" + str.contains("I am"));

		System.out.println("替换字符串第一次出现的位置:" + str.replaceFirst("I", "我"));
		System.out.println("替换字符串所有出现的位置:" + str.replaceAll("I", "我"));
		System.out.println("字符串\"我是李小龙!我是中国人!\"在位置3的字符:" + str.charAt(3));
		System.out.println("字符串\"我是李小龙!我是中国人!\"的子串(2,5):" + str.substring(2, 5));
		// 字符串分割
		String[] strArr = str.split(",");
		for (String subStr : strArr) {
			System.out.print(subStr + "    ");
		}
		System.out.println();

		char[] charr = str.toCharArray();
		for (int i = 0; i < charr.length; i++) {
			System.out.printf("字符charr[%d]:%c  ", i, charr[i]);
			if (i == charr.length - 1) {
				System.out.println();
			}
		}
	}
}
