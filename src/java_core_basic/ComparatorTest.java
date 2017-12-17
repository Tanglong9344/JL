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
		List<Person> ps = new ArrayList<Person>();
		//初始化数据
		for (int i=1;i<=10;i++) {
			ps.add(new Person("P-"+ i, r.nextInt(100), "Addr" + i));
		}
		System.out.println("初始化后的集合:\n" + ps);
		//直接调用sort会出现编译错误，因为Person有各种属性
		//引入Comparator，指定比较的算法
		Comparator<Person> cmpAge = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				//按照Age从低到高进行排序
				return p1.getAge() >= p2.getAge() ? 1 : -1;
			}
		};
		Collections.sort(ps,cmpAge);
		System.out.println("按照年龄低高排序后的集合：\n" + ps);
	}
}

/**
 * Person Class with name, age and address
 *
 * @author 唐龙
 */
class Person {
	private String name;
	private int age;
	private String address;

	public Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	//重写toString方法
	@Override
	public String toString(){
		return "Name: " + name+ ", Age: " + age + ", Address: " + address + "\n";
	}

	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}