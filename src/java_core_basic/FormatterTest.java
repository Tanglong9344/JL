package java_core_basic;

import java.util.Date;
import java.util.Formatter;

/**
 * Formatter���ʽ����ʾ
 * @author ����
 */
public class FormatterTest {
	public static void main(String[] args) {
		Formatter fmt = new Formatter(System.out);
		Date date = new Date();
		fmt.format("��ǰϵͳ��ʾ��ʱ�������Ϊ��%tc\n", date);
		fmt.format("��ǰ������Ϊ[�й���ʽ������]��%tF\n", date);
		fmt.format("��ǰ������Ϊ[������ʽ������]��%tD\n", date);
		fmt.format("���������ڼ�����%tA\n", date);
		fmt.format("����ʱ��Ϊ[24Сʱ��]��%tT\n", date);
		fmt.format("����ʱ��Ϊ[12Сʱ��]��%tR\n", date);
		fmt.format("�����Ǽ��·ݣ�%tB\n", date);
		fmt.format("�����Ǽ��ţ�%te��\n", date);
		fmt.close();
	}
}