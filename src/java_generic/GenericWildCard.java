package java_generic;

import java.util.ArrayList;
import java.util.List;

/**
 * java ����ͨ���
 * @author ����
 */
public class GenericWildCard {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//?����ͨ�������ʾ���ⷺ��
		//?��ȱ��1�� ?�������ⷺ�ͣ����㲻֪���������������ʲô����
		List<?> gList = new ArrayList<String>();
		//����ֻ����Object����ʽȡ����
		Object object = gList.get(0);
		//String str = gList.get(0);
		//Long l = gList.get(0);
		//?��ȱ��2�� ��Ȼ?�������ⷺ�ͣ����ԣ������ֶ����ȥ���з��գ������ʲôʲô���͵Ķ��󶼲��ܷŽ�ȥ
		//gList.add("str001");
		//gList.add(new Integer(002));
		//gList.add(new String("003"));
	}
}