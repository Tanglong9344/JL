package java_generic;

import java.util.ArrayList;

public class GenericWildCardTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ArrayList<Hero> heroList = new ArrayList<Hero>();
		//?����ͨ�������ʾ���ⷺ��
		ArrayList<?> generalList = heroList;
		//?��ȱ��1�� ��Ȼ?�������ⷺ�ͣ���ô���仰˵����Ͳ�֪���������������ʲô����
		//����ֻ����Object����ʽȡ����
		Object o = generalList.get(0);
		//?��ȱ��2�� ��Ȼ?�������ⷺ�ͣ���ô���п�����Hero,Ҳ�п�����Item
		//���ԣ������ֶ����ȥ�����з��գ������ʲôʲô���͵Ķ��󣬶����ܷŽ�ȥ
		//generalList.add(new String()); //������� ��Ϊ?�������ⷺ�ͣ����п��ܲ���String
		//generalList.add(new Hero()); //������� ��Ϊ?�������ⷺ�ͣ����п��ܲ���Hero
		//generalList.add(new HeroChild()); //�������  ��Ϊ?�������ⷺ�ͣ����п��ܲ���HeroChild
	}
}