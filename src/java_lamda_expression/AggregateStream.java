package java_lamda_expression;

import static java_lamda_expression.CommonConstant.N;
import static java_lamda_expression.CommonConstant.RANGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * �ۺϲ���-�ܵ�Դ
 *
 * @author ����
 */
public class AggregateStream {
	public static void main(String[] args) {
		Random r = new Random();
		List<String> strList = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			strList.add("String" + r.nextInt(RANGE));
		}
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