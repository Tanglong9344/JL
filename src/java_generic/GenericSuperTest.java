package java_generic;

import java.util.ArrayList;

public class GenericSuperTest {
	public static void main(String[] args) {
		ArrayList<? super Hero> heroList = new ArrayList<Object>();
		//? super Hero ��ʾ heroList�ķ�����Hero�����丸�෺��
		//���ԾͿ��Բ���Hero
		heroList.add(new Hero());
		//Ҳ���Բ���Hero������
		heroList.add(new HeroChild());
		//���ǣ����ܴ�����ȡ���ݳ���,��Ϊ�䷺�Ϳ�����Object,��Object��ǿתHero��ʧ��
		//Hero h= heroList.get(0);
	}
}
