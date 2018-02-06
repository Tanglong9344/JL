package java_lamda_expression;

import static java_common.CommonValue.N;

import java.util.Arrays;
import java.util.List;

/**
 * �ۺϲ���-�ܵ�Դ
 *
 * @author ����
 */
public class AggregateStream {
	public static void main(String[] args) {
		List<String> strList = java_common.CommonUtils.getList(N);
		System.out.println("��ʼ����ļ���:\n" + strList);
		//�ܵ�Դ�Ǽ���
		System.out.println("�ܵ�Դ�Ǽ���:");
		strList
		.stream()
		.forEach(s->System.out.println(s));

		//�ܵ�Դ������
		System.out.println("�ܵ�Դ������:");
		String strArr[] = strList.toArray(new String[strList.size()]);
		Arrays
		.stream(strArr)
		.forEach(s->System.out.println(s));
	}
}