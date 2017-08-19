package java_reflection;

public class ReflectionTest {
	public static void main(String[] args) {
		String className = "java_core_basic4.Hero";
		try {
			Class<?> pClass1=Class.forName(className);
			Class<Hero> pClass2=Hero.class;
			Class<? extends Hero> pClass3=new Hero().getClass();
			
			System.out.println("Class.forName(className):"+pClass1);
			System.out.println("Hero.class:"+pClass2);
			System.out.println("new Hero().getClass():"+pClass3);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
