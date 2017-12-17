package java_lamda_expression;

import static java_lamda_expression.CommonConstant.N;
import static java_lamda_expression.CommonConstant.RANGE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * �ۺϲ���
 * 1. Stream��Collection�ṹ�������ݲ�һ����Stream��һϵ�е�Ԫ�أ���ͬˮ��һ�����಻����
 * 2. �ܵ�ָ����һϵ�еľۺϲ�����
 * 2.1 �ܵ�Դ������������Դ��һ��List
 * 2.2 �м������ ÿ���м�������ֻ᷵��һ��Stream��
 *     ����.filter()�ַ���һ��Stream, �м�����ǡ������������������������б�����
 * 2.3 �������������������ִ�к����ͱ�ʹ�á��⡱�ˣ��޷��ٱ�������������ض����������һ��������
 *     �����������᷵��Stream�����ǻ᷵��int��float��String�� Collection
 *     ������forEach��ʲô��������, ���������Ž��������ı�����Ϊ���ڱ�����ʱ�򣬲Ż�ȥ�����м����������ж�
 *
 * ע�� ���Stream��I/O�½ڵ�InputStream,OutputStream�ǲ�һ���ĸ��
 *
 * @author ����
 */
public class AggregateOperation {
	public static void main(String[] args) {
		Random r = new Random();
		List<String> strs = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			strs.add("String" + r.nextInt(RANGE));
		}
		System.out.println("��ʼ����ļ���:\n" + strs);

		System.out.println("ͨ����ͳ������ʽ�ҳ��������������ݣ�");
		for (String str : strs) {
			if ((str.charAt(str.length()-1))%2 == 0) {
				System.out.println(str);
			}
		}
		System.out.println("ͨ���ۺϲ�����ʽ�ҳ��������������ݣ�");
		//�ۺϲ���
		strs
		.stream()
		.filter(s -> (s.charAt(s.length()-1))%2 == 0)
		.forEach(s -> System.out.println(s));
	}
}