package java_lamda_expression;

import static java_lamda_expression.CommonConstant.N;
import static java_lamda_expression.CommonConstant.RANGE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**�ۺϲ���-�м����
 *
 * ÿ���м�������ֻ᷵��һ��Stream��
 * ����.filter()�ַ���һ��Stream,
 * �м�����ǡ������������������������б�����
 * �м�����Ƚ϶࣬��Ҫ������
 * 1.��Ԫ�ؽ���ɸѡ��
 * 1.1 filter ƥ��
 * 1.2 distinct ȥ���ظ�(����equals�ж�)
 * 1.3 sorted ��Ȼ����
 * 1.4 sorted(Comparator<T>) ָ������
 * 1.5 limit ����
 * 1.6 skip ����
 *
 * 2.ת��Ϊ������ʽ������
 * 2.1 mapToDouble ת��Ϊdouble����
 * 2.2 map ת��Ϊ�������͵���
 *
 * @author ����
 */
public class AggregateMiddleHandle {
	public static void main(String[] args) {
		Random r = new Random();
		List<String> strs = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			strs.add("String" + r.nextInt(RANGE));
		}
		System.out.println("��ʼ����ļ���:\n" + strs);

		//����һ���ظ�����
		strs.add(strs.get(strs.size()-1));
		System.out.println("��ʼ�����Ϻ������ (���һ�������ظ�):\n" + strs);

		//filter ƥ��
		System.out.println("�������һ���ַ�Ϊż��������, filter ƥ��: ");
		strs
		.stream()
		.filter(s->(s.charAt(s.length()-1))%2 == 0)
		.forEach(s->System.out.println(s));

		//ȥ���ظ�������
		System.out.println("ȥ���ظ������ݣ�ȥ����׼�ǿ�equals:");
		strs
		.stream()
		.distinct()
		.forEach(s->System.out.println(s));

		//sorted ָ������
		System.out.println("����:");
		strs
		.stream()
		.sorted((s1,s2)->s1.compareTo(s2))
		.forEach(s->System.out.println(s));

		//limit ����
		System.out.println("����3��:");
		strs
		.stream()
		.limit(3)
		.forEach(s->System.out.println(s));

		//skip ����
		System.out.println("����ǰ3��:");
		strs
		.stream()
		.skip(3)
		.forEach(s->System.out.println(s));

		//ת���������͵�Stream
		System.out.println("ת���������͵�Stream:");
		strs
		.stream()
		.map((s)->s + ", After mapping...")
		.forEach(s->System.out.println(s));
	}
}