package java_generic;

import java.lang.reflect.Field;

public class GetClassTest {

	public static void main(String[] args) {
		Hero hero = new Hero();
		System.out.println("�����getClass():"+hero.getClass());

		//��ȡ�������������
		Field[] fields = hero.getClass().getDeclaredFields();
		for(Field field : fields){
			System.out.print("����������"+field.getType()+"\t");
			System.out.println("������:"+field.getName());
		}
	}
}
