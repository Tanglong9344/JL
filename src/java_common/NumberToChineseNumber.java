package java_common;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * transform numbers to chinese numbers
 * e.g:
 *    '1992694160'
 *      to
 *    '一十九亿九千二百六十九万四千一百六十'
 * coment: the largest unit is '亿'
 *
 * @author tanglong
 *
 */
public class NumberToChineseNumber {
	public static void main(String[] args) {
		Random random = new Random();
		int number = random.nextInt(Integer.MAX_VALUE);
		System.out.println(number);
		System.out.println(getNumberByChinese(number));
	}

	/** transform numbers to chinese numbers */
	public static String getNumberByChinese(int number) {
		String numberStr = String.valueOf(number);
		char[] array = numberStr.toCharArray();
		// classify according to the length of number
		int n1 = array.length / 4;
		int n2 = array.length % 4;
		StringBuilder sb = new StringBuilder();
		sb.append(transfer2Chinese(numberStr.substring(0, n2)) + "亿");
		for (int i = 0; i < n1; i++) {
			String result = numberStr.substring(i * 4 + n2, i * 4 + n2 + 4);
			if (i == (n1 - 2)) {
				sb.append(transfer2Chinese(result) + "万");
			}
			if (i == (n1 - 1)) {
				sb.append(transfer2Chinese(result) + "");
			}
		}
		return sb.toString();
	}

	/** replace all numbers as chinese number */
	public static String transfer2Chinese(String str) {
		char[] array = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		// remove needless '0'
		for(int i = 0; i < array.length - 1; i++) {
			if((array[i] != '0') || (array[i+1] != '0')) {
				sb.append(array[i]);
			} else {
				sb.append("");
			}
		}
		sb.append(array[array.length - 1]);
		array = sb.toString().toCharArray();
		sb = new StringBuilder();
		Map<Integer, String> map = new HashMap<Integer, String>();
		// 获取单位
		for (int i = array.length - 1; i >= 0; i--) {
			// 个位默认""
			map.put(i, "");
			// 十位
			if (i == array.length - 2) {
				map.put(i, "十");
			}
			// 百位
			if (i == array.length - 3) {
				map.put(i, "百");
			}
			// 千位
			if (i == array.length - 4) {
				map.put(i, "千");
			}
		}
		for (int i = 0, len=array.length; i < len; i++) {
			if(i == len - 1 && array[i] == '0') {
				sb.append("");
			} else {
				sb.append(array[i]);
			}
			if(array[i] != '0' && array[i] != ' ') {
				sb.append(map.get(i));
			}
		}
		return sb.toString()
				.replaceAll("1", "一")
				.replaceAll("2", "二")
				.replaceAll("3", "三")
				.replaceAll("4", "四")
				.replaceAll("5", "五")
				.replaceAll("6", "六")
				.replaceAll("7", "七")
				.replaceAll("8", "八")
				.replaceAll("9", "九")
				.replaceAll("0", "零");
	}
}