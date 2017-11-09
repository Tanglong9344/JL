package java_core_basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ComparableTest {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero2> heros = new ArrayList<Hero2>();
		//ͨ�����ֵʵ����hero��hp��damage
		for (int i=0;i<10;i++) {
			heros.add(new Hero2("hero-"+ i,r.nextInt(100),r.nextInt(100)));
		}
		System.out.println("��ʼ����ļ���:\n"+heros);
		//Hero2��ʵ���˽ӿ�Comparable�����Դ��Ƚ���Ϣ��
		//Collectionsֱ�ӽ���������������Comparator
		Collections.sort(heros);
		System.out.println("�����˺��͸������ļ���:\n"+heros);
	}
}

/**
 * Hero2��
 * ӵ��������Ѫ�����˺�����������
 * ʵ�ֽӿ�Comparable<>
 * ����compareTo����������demage���Դӵ͵�������
 * @author ����
 */
class Hero2 implements Comparable<Hero2>{
	public String name;
	public float hp;
	public int damage;

	public Hero2(String name) {this.name =name;}
	//��ʼ��name,hp,damage�Ĺ��췽��
	public Hero2(String name,float hp, int damage) {
		this.name =name;
		this.hp = hp;
		this.damage = damage;
	}

	@Override
	public int compareTo(Hero2 anotherHero) {
		if(damage>=anotherHero.damage) {
			return 1;
		} else {
			return -1;
		}
	}

	//��дtoString����
	@Override
	public String toString(){
		return "name="+name+" hp="+hp+" damage="+damage+"\n";
	}
}