package java_collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Set ��Ԫ�ز����ظ�,��������������Խ���Ԫ��ȥ��
 * @author ����
 */
public class SetRemoveRepetition {
	public static void main(String[] args) {
		String[] strs = {"aaa","bbb","bbb","ccc","ccc","ddd"};
		System.out.println("����ȥ��ǰ��"+Arrays.toString(strs));

		//����Setȥ��
		Set<String> set = new HashSet<String>(Arrays.asList(strs));

		strs = new String[set.size()];
		set.toArray(strs);
		System.out.println("����ȥ�غ�"+Arrays.toString(strs));
	}
}