package java_jdbc;

import java.util.List;

public class HeroDaoTest {
	public static void main(String[] args) {
		HeroDAO hd = new HeroDAO();
		Hero h = new Hero();
		h.setName("�ܲ�");
		h.setHp(1000);
		h.setDamage(10);
		//�������
		hd.add(h);
		//��������
		h.setId(3);
		hd.update(h);
		//ɾ������
		hd.delete(2);
		//��ѯ����
		System.out.println("��ѯid=5�����ݣ�");
		System.out.println(hd.get(5).getName());
		//��ȡ�����б�
		System.out.println("��ȡ�����б�");
		List<Hero> list = hd.list();
		list.forEach(l->System.out.println(l.getName()));
	}
}
