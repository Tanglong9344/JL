package java_core_basic;

public class MathMethodTest {
	public static void main(String[] args) {
		float f1 = 5.4f;
		float f2 = 5.5f;
		// 5.4四舍五入即5
		System.out.println("5.4四舍五入即5:" + Math.round(f1));
		// 5.5四舍五入即6
		System.out.println("5.5四舍五入即6:" + Math.round(f2));
		// 得到一个0-1之间的随机浮点数（取不到1）
		System.out.println("得到一个0-1之间的随机浮点数（取不到1）:" + Math.random());
		// 得到一个0-10之间的随机整数 （取不到10）
		System.out.println("得到一个0-10之间的随机整数 （取不到10）:" + (int) (Math.random() * 10));
		// 开方
		System.out.println("9的平方根:" + Math.sqrt(9));
		// 次方2的4次方
		System.out.println("2的4次方:" + Math.pow(2, 4));
		// π
		System.out.println("PI常量:" + Math.PI);
		// 自然常数
		System.out.println("E常量：" + Math.E);
	}
}
