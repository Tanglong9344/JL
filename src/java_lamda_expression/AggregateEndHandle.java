package java_lamda_expression;

import static java_lamda_expression.CommonConstant.RANGE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * �ۺϲ���-��������
 * 1. �����н������������ͱ�ʹ�á��⡱�ˣ��޷��ٱ�������������ض����������һ��������
 *    �����������᷵��Stream�����ǻ᷵��int��float��String�� Collection
 *    ������forEach��ʲô�������ء�
 * 2. �����������������б�����Ϊ��ǰ����м����Ҳ�����ʱ�򣬲�������ִ�С�
 * 3. ���������������£�
 *    3.1 forEach() ����ÿ��Ԫ��
 *    3.2 toArray() ת��Ϊ����
 *    3.3 min(Comparator<T>) ȡ��С��Ԫ��
 *    3.4 max(Comparator<T>) ȡ����Ԫ��
 *    3.5 count() ����
 *    3.6 findFirst() ��һ��Ԫ��
 *
 * @author ����
 */
public class AggregateEndHandle {
	static final int N = 5;
	public static void main(String[] args) {
		Random r = new Random();
		List<String> strs = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			strs.add("String" + r.nextInt(RANGE));
		}
		System.out.println("��ʼ����ļ���:\n" + strs);

		//forEach() ����ÿ��Ԫ��
		System.out.println("���������е�ÿ������:");
		strs
		.stream()
		.forEach(s->System.out.println(s));

		//toArray() ת��Ϊ����
		System.out.println("����һ������:");
		Object[] arr= strs
				.stream()
				.toArray();
		System.out.println(Arrays.toString(arr));

		//min(Comparator<T>) ȡ��С��Ԫ��
		System.out.print("������СԪ��: ");
		String min = strs
				.stream()
				.min((s1,s2)->s1.compareTo(s2))
				.get();
		System.out.println(min);

		//max(Comparator<T>) ȡ����Ԫ��
		System.out.print("�������Ԫ��: ");
		String max = strs
				.stream()
				.max((s1,s2)->s1.compareTo(s2))
				.get();
		System.out.println(max);

		//count() ����
		System.out.print("�������ݵ�����: ");
		long count = strs
				.stream()
				.count();
		System.out.println(count);

		//findFirst() ��һ��Ԫ��
		System.out.print("��һ��Ԫ��: ");
		String first = strs
				.stream()
				.findFirst()
				.get();
		System.out.println(first);
	}
}