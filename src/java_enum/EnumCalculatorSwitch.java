package java_enum;

/**
 * enum calculator
 *
 * @author ÌÆÁú
 *
 */
public class EnumCalculatorSwitch {
	public static void main(String[] args) {
		double a = 12;
		double b = 3;
		Calculator1[] ops = Calculator1.values();
		for(Calculator1 op : ops) {
			System.out.printf("%.2f %7s %.2f = %.2f%n", a, op, b, op.apply(a, b));
		}
	}
}

/**enum type that switches on its own values-questionable*/
enum Calculator1{
	ADD, MINUS, MITIPLY, DIVIDE;

	/**Do the arithmetic operation*/
	public double apply(double a, double b) {
		switch(this) {
		case ADD:return a + b;
		case MINUS:return a - b;
		case MITIPLY:return a * b;
		case DIVIDE:return a / b;
		}
		throw new AssertionError("Unknown operation: " + this);
	}
}