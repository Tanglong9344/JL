package java_generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型对象
 * 上界类型通配符（?extends）与 下界类型通配符（?super）
 * @author 唐龙
 */
public class GenericExtendsSuper{
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//上界类型通配符（?extends）
		//eList存储Parent及其子类对象
		//即new ArrayList<T>,T只能是Parent或其子类
		List<? extends Parent> eList = new ArrayList<Child>();//正确
		List<? extends Parent> eList2 = new ArrayList<Child2>();//正确
		//List<? extends Parent> eList3 = new ArrayList<String>();//错误
		//因为无法确定eList内存储的具体类型，故无法添加
		//eList.add(new Parent());//错误
		//eList.add(new Child());//错误
		//eList.add(new Child2());//错误
		Parent eParent = eList.get(0);//正确
		//Child eChild = eList.get(0);//错误
		//Child2 eChild2 = eList.get(0);//错误

		//下界类型通配符（?super）
		//sList存储Child及其父类对象
		List<? super Child> sList = new ArrayList<Parent>();//正确
		List<? super Child> sList2 = new ArrayList<Child>();//正确
		//List<? super Child> sList3 = new ArrayList<Child2>();//错误
		//只能添加Child及其子类对象
		sList.add(new Child());//正确
		//sList.add(new Child2());//错误
		//sList.add(new Parent());//错误
		//获取的全部是Object对象
		//Parent sParent = sList.get(0);//错误
		//Child sChild = sList.get(0);//错误
		//Child2 sChild2 = sList.get(0);//错误
	}
}