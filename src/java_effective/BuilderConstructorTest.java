package java_effective;

/**
 * 建造者测试类
 * @author 唐龙
 */
public class BuilderConstructorTest {
	public static void main(String[] args) {
		BuilderConstructor bc = null;
		// name
		bc = new BuilderConstructor
				.Builder("Tanglong")
				.build();
		System.out.println(bc.toString());

		// name, sex
		bc = new BuilderConstructor
				.Builder("Tanglong")
				.sex("男")
				.build();
		System.out.println(bc.toString());

		// name, sex, age
		bc = new BuilderConstructor
				.Builder("Tanglong")
				.sex("男")
				.age("18")
				.build();
		System.out.println(bc.toString());

		// name, sex, age, address
		bc = new BuilderConstructor
				.Builder("Tanglong")
				.sex("男")
				.age("18")
				.address("杭州")
				.build();
		System.out.println(bc.toString());
	}
}