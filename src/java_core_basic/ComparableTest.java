package java_core_basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ComparableTest {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero2> heros = new ArrayList<Hero2>();
		//通过随机值实例化hero的hp和damage
		for (int i=0;i<10;i++) {
			heros.add(new Hero2("hero-"+ i,r.nextInt(100),r.nextInt(100)));
		}
		System.out.println("初始化后的集合:\n"+heros);
		//Hero2类实现了接口Comparable，即自带比较信息。
		//Collections直接进行排序，无需额外的Comparator
		Collections.sort(heros);
		System.out.println("按照伤害低高排序后的集合:\n"+heros);
	}
}

/**
 * Hero2类
 * 拥有姓名，血量，伤害度三个属性
 * 实现接口Comparable<>
 * 重载compareTo方法，按照demage属性从低到高排序
 * @author 唐龙
 */
class Hero2 implements Comparable<Hero2>{
	public String name;
	public float hp;
	public int damage;

	public Hero2(String name) {this.name =name;}
	//初始化name,hp,damage的构造方法
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

	//重写toString方法
	@Override
	public String toString(){
		return "name="+name+" hp="+hp+" damage="+damage+"\n";
	}
}