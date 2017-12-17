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
		List<Person> ps = new ArrayList<Person>();
		//��ʼ������
		for (int i=1;i<=10;i++) {
			ps.add(new Person("P-"+ i, r.nextInt(100), "Addr" + i));
		}
		System.out.println("��ʼ����ļ���:\n" + ps);
		//ֱ�ӵ���sort����ֱ��������ΪPerson�и�������
		//����Comparator��ָ���Ƚϵ��㷨
		Comparator<Person> cmpAge = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				//����Age�ӵ͵��߽�������
				return p1.getAge() >= p2.getAge() ? 1 : -1;
			}
		};
		Collections.sort(ps,cmpAge);
		System.out.println("��������͸������ļ��ϣ�\n" + ps);
	}
}

/**
 * Person Class with name, age and address
 *
 * @author ����
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

	//��дtoString����
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