package java_core_basic;

public class OverrideTest extends FatherClass {
	public static void main(String[] args) {
		run();
		System.out.println(talk());
		InnerClass ic = new InnerClass();
		System.out.println(ic.toString());
		System.out.println("name:" + ic.name + "\tage:" + ic.age);
		ic.setName("李小龙");
		ic.setAge(32);
		System.out.println("name:" + ic.name + "\tage:" + ic.age);
		System.out.println("对象的哈希码:" + ic.hashCode());
	}

	public static String talk() {
		return "Chinese and English";
	}

	static class InnerClass {

		public InnerClass() {

		}

		private int age = 12;
		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		private String name = "Tom";
	}
}
