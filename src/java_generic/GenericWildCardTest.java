package java_generic;

import java.util.ArrayList;

public class GenericWildCardTest {
	//java ����ͨ���
	public static void main(String[] args) {
		ArrayList<Hero> heroList = new ArrayList<Hero>();
		//?����ͨ�������ʾ���ⷺ��
		ArrayList<?> generalList = heroList;
		//?��ȱ��1�� ��Ȼ?�������ⷺ�ͣ���ô���仰˵����Ͳ�֪���������������ʲô����
		//����ֻ����Object����ʽȡ����
		System.out.println("���Ͷ���"+generalList);
		//?��ȱ��2�� ��Ȼ?�������ⷺ�ͣ���ô���п�����Hero,Ҳ�п�����Item
		//���ԣ������ֶ����ȥ�����з��գ������ʲôʲô���͵Ķ��󣬶����ܷŽ�ȥ
		//generalList.add(new String()); //������� ��Ϊ?�������ⷺ�ͣ����п��ܲ���String
		//generalList.add(new Hero()); //������� ��Ϊ?�������ⷺ�ͣ����п��ܲ���Hero
		//generalList.add(new HeroChild()); //�������  ��Ϊ?�������ⷺ�ͣ����п��ܲ���HeroChild
	}
}