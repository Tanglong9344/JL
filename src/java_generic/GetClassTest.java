package java_generic;

import java.lang.reflect.Field;

public class GetClassTest {

	public static void main(String[] args) {
		Hero hero = new Hero();
		System.out.println("对象的getClass():"+hero.getClass());

		//获取对象的所有属性
		Field[] fields = hero.getClass().getDeclaredFields();
		for(Field field : fields){
			System.out.print("属性名类型"+field.getType()+"\t");
			System.out.println("属性名:"+field.getName());
		}
	}
}
