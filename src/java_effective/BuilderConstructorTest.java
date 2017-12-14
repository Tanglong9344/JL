package java_effective;

/**
 * �����߲�����
 * @author ����
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
				.sex("��")
				.build();
		System.out.println(bc.toString());

		// name, sex, age
		bc = new BuilderConstructor
				.Builder("Tanglong")
				.sex("��")
				.age("18")
				.build();
		System.out.println(bc.toString());

		// name, sex, age, address
		bc = new BuilderConstructor
				.Builder("Tanglong")
				.sex("��")
				.age("18")
				.address("����")
				.build();
		System.out.println(bc.toString());
	}
}