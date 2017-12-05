package java_core_basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * ͨ��Comparator����ɶ���֮��ıȽ�
 * @author ����
 */
public class ComparatorTest {
	public static void main(String[] args) {
		Random r =new Random();
		List<Hero> heros = new ArrayList<Hero>();
		//ͨ�����ֵʵ����hero��hp��damage
		for (int i=0;i<10;i++) {
			heros.add(new Hero("hero-"+ i, r.nextInt(100), r.nextInt(100)));
		}
		System.out.println("��ʼ����ļ���:\n"+heros);
		//ֱ�ӵ���sort����ֱ��������ΪHero�и�������
		//Collections.sort(heros);
		//����Comparator��ָ���Ƚϵ��㷨
		Comparator<Hero> c = new Comparator<Hero>() {
			@Override
			public int compare(Hero h1,Hero h2) {
				//����hp�ӵ͵��߽�������
				if(h1.hp>=h2.hp) {
					return 1;
				} else {
					return -1;
				}
			}
		};
		Collections.sort(heros,c);
		System.out.println("����Ѫ���͸������ļ��ϣ�\n"+heros);
	}
}

/**
 * hero ��
 * ӵ��������Ѫ�����˺�����������
 * @author ����
 */
class Hero {
	public String name;
	public float hp;
	public int damage;

	public Hero(String name, int hp, int damage) {
		this.name = name;
		this.hp = hp;
		this.damage = damage;
	}

	//��дtoString����
	@Override
	public String toString(){
		return "name="+name+" hp="+hp+" damage="+damage+"\n";
	}
}