package java_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * ����ͼ����໥ת��
 * @author ����
 */
public class ArrayConvertList {
	public static void main(String[] args) {
		String[] strs = {"AAA","BBB","CCC"};
		//����תΪ����
		List<String> list = Arrays.asList(strs);
		//������תΪ���Ϻ�ʹ��forEach����
		Arrays.asList(strs).forEach(s->System.out.println(s));
		//ע�⣺Arrays.asList���ֵ���������ģʽ��ֻ��ת���ӿڣ���̨��������������
		//list.add("DDD");//����java.lang.UnsupportedOperationException
		//������ֵ�ı��Ӧ�ļ�����ֵҲ��ı�
		strs[0]="aaa";
		list.forEach(s->System.out.println(s));

		List<String> lists = new ArrayList<String>();
		lists.add("XXX");
		lists.add("YYY");
		lists.add("ZZZ");
		//�����ȸ��ݼ��ϴ�С�½����飬����ʹ���޲�ת������lists.toArray()
		String[] str = new String[lists.size()];
		//����ת����
		lists.toArray(str);
		lists.remove(0);//���ϲ�������Ӱ������
		System.out.println("\n"+Arrays.toString(str));
	}
}