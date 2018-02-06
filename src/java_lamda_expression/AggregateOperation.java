package java_lamda_expression;

import static java_common.CommonValue.N;

import java.util.List;

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
		List<String> strs = java_common.CommonUtils.getList(N);
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