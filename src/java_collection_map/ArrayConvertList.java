package java_collection_map;

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
		list.forEach(s->System.out.print(s+" "));

		List<String> lists = new ArrayList<String>();
		lists.add("XXX");
		lists.add("YYY");
		lists.add("ZZZ");
		//��������
		String[] str = new String[lists.size()];
		//����ת����
		lists.toArray(str);
		System.out.println("\n"+Arrays.toString(str));
	}
}