package java_core_basic;

import java.util.Locale;

/**
 * ��ʽ�����
 * @author ����
 */
public class FormatInput {
	public static void main(String[] args) {
		String name = "����";
		int kill = 8;
		String title = "����";
		System.out.printf("Hello ���ף�Ŭ���ɣ�%n");// %n���з�����ƽ̨�޹�
		String sentenceFormat = "%s �ڽ��������� %d �λ�ɱ�󣬻���� %s �ĳƺ�%n";
		// ʹ��printf��ʽ�����
		System.out.printf(sentenceFormat, name, kill, title);// print()ֱ�ӵ���format()
		// ʹ��format��ʽ�����
		System.out.format(sentenceFormat, name, kill, title);
		int year = 2020;
		// �ܳ��ȣ�����룬��0��ǧλ�ָ�����С����λ�������ػ����
		// ֱ�Ӵ�ӡ����
		System.out.format("%d%n", year);
		// �ܳ�����8,Ĭ���Ҷ���
		System.out.format("%8d%n", year);
		// �ܳ�����8,�����
		System.out.format("%-8d%n", year);
		// �ܳ�����8,������0
		System.out.format("%08d%n", year);
		// ǧλ�ָ���
		System.out.format("%,8d%n", year * 10000);
		// С����λ��
		System.out.format("%.5f%n", Math.PI);
		// ��ͬ���ҵ�ǧλ�ָ���
		System.out.format(Locale.FRANCE, "%,.2f%n", Math.PI * 10000);
		System.out.format(Locale.US, "%,.2f%n", Math.PI * 10000);
		System.out.format(Locale.UK, "%,.2f%n", Math.PI * 10000);
	}
}