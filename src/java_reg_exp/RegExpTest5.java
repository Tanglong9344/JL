package java_reg_exp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest5 {
	/**
	 * ������ʽƥ��
	 * ��3�����ֿ�ͷ���ԡ�_�����ӣ���8�����ֽ�β
	 * ����
	 * ��4�����ֿ�ͷ���ԡ�_�����ӣ���7�����ֽ�β
	 * �����ִ�
	 * */
	private static String REG_EXP = "^([0-9]{3}-?[0-9]{8})|([0-9]{4}-?[0-9]{7})$";
	// ʹ��String���е�matches��������������ʽƥ��ķ���
	public static boolean useMatches(String phoneNum) {
		if (phoneNum != null) {
			return phoneNum.matches(REG_EXP);
		} else {
			return false;
		}
	}
	//ʹ��Pattern��compile������Matcher��matcher������ͬƥ��
	public static boolean usePattern(String phoneNum) {
		Pattern p = Pattern.compile(REG_EXP);
		// ����һ��Matcher�������о�ȷƥ��
		Matcher m = p.matcher(phoneNum);
		return m.matches();
	}
	public static void main(String[] args) {
		String phoneNum = "210-12345678";
		System.out.println(phoneNum + " ��һ���Ϸ��ĵ绰�����ʽ��? "
				+ RegExpTest5.useMatches(phoneNum));
		System.out.println(phoneNum + " ��һ���Ϸ��ĵ绰�����ʽ��? "
				+ RegExpTest5.usePattern(phoneNum));

		phoneNum = "2103-1234567";
		System.out.println(phoneNum + " ��һ���Ϸ��ĵ绰�����ʽ��? "
				+ RegExpTest5.useMatches(phoneNum));
		System.out.println(phoneNum + " ��һ���Ϸ��ĵ绰�����ʽ��? "
				+ RegExpTest5.usePattern(phoneNum));

		phoneNum = "2103-1234";
		System.out.println(phoneNum + " ��һ���Ϸ��ĵ绰�����ʽ��? "
				+ RegExpTest5.useMatches(phoneNum));
		System.out.println(phoneNum + " ��һ���Ϸ��ĵ绰�����ʽ��? "
				+ RegExpTest5.usePattern(phoneNum));
	}
}