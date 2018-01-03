package java_core_basic;

/**
 * While loop in Java
 *
 * @author ÌÆÁú
 *
 */
public class WhileLoop {
	public static void main(String[] args) {
		int flag = 1;
		System.out.println("------------while-do while-----------");
		// while
		while(flag<=3) {
			System.out.println(flag++);
		}

		// do while
		do {
			System.out.println(flag++);
		} while(flag<=3);

		System.out.println("------------do while-while-----------");
		flag = 1;
		// do while
		do {
			System.out.println(flag++);
		} while(flag<=3);

		// while
		while(flag<=3) {
			System.out.println(flag++);
		}
	}
}