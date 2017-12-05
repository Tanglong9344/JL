package java_core_basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * 通过Comparator类完成对象之间的比较
 * @author 唐龙
 */
public class ComparatorTest {
	public static void main(String[] args) {
		Random r =new Random();
		List<Hero> heros = new ArrayList<Hero>();
		//通过随机值实例化hero的hp和damage
		for (int i=0;i<10;i++) {
			heros.add(new Hero("hero-"+ i, r.nextInt(100), r.nextInt(100)));
		}
		System.out.println("初始化后的集合:\n"+heros);
		//直接调用sort会出现编译错误，因为Hero有各种属性
		//Collections.sort(heros);
		//引入Comparator，指定比较的算法
		Comparator<Hero> c = new Comparator<Hero>() {
			@Override
			public int compare(Hero h1,Hero h2) {
				//按照hp从低到高进行排序
				if(h1.hp>=h2.hp) {
					return 1;
				} else {
					return -1;
				}
			}
		};
		Collections.sort(heros,c);
		System.out.println("按照血量低高排序后的集合：\n"+heros);
	}
}

/**
 * hero 类
 * 拥有姓名，血量，伤害度三个属性
 * @author 唐龙
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

	//重写toString方法
	@Override
	public String toString(){
		return "name="+name+" hp="+hp+" damage="+damage+"\n";
	}
}