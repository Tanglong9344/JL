package java_common;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * transform numbers to chinese numbers
 * e.g:
 *    '1992694160'
 *      to
 *    'һʮ���ھ�ǧ������ʮ������ǧһ����ʮ'
 * coment: the largest unit is '��'
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
		sb.append(transfer2Chinese(numberStr.substring(0, n2)) + "��");
		for (int i = 0; i < n1; i++) {
			String result = numberStr.substring(i * 4 + n2, i * 4 + n2 + 4);
			if (i == (n1 - 2)) {
				sb.append(transfer2Chinese(result) + "��");
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
		// ��ȡ��λ
		for (int i = array.length - 1; i >= 0; i--) {
			// ��λĬ��""
			map.put(i, "");
			// ʮλ
			if (i == array.length - 2) {
				map.put(i, "ʮ");
			}
			// ��λ
			if (i == array.length - 3) {
				map.put(i, "��");
			}
			// ǧλ
			if (i == array.length - 4) {
				map.put(i, "ǧ");
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
				.replaceAll("1", "һ")
				.replaceAll("2", "��")
				.replaceAll("3", "��")
				.replaceAll("4", "��")
				.replaceAll("5", "��")
				.replaceAll("6", "��")
				.replaceAll("7", "��")
				.replaceAll("8", "��")
				.replaceAll("9", "��")
				.replaceAll("0", "��");
	}
}