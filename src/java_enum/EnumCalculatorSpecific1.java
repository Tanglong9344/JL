package java_enum;

/**
 * enum calculator with a abstarct method
 *
 * @author ÌÆÁú
 *
 */
public class EnumCalculatorSpecific1 {
	public static void main(String[] args) {
		double a = 12;
		double b = 3;
		Calculator2[] ops = Calculator2.values();
		for(Calculator2 op : ops) {
			System.out.printf("%.2f %7s %.2f = %.2f%n", a, op, b, op.apply(a, b));
		}
	}
}

/**Constant-specific method implementation*/
enum Calculator2{
	ADD     { @Override double apply(double a, double b) { return a + b; } },
	MINUS   { @Override double apply(double a, double b) { return a - b; } },
	MITIPLY { @Override double apply(double a, double b) { return a * b; } },
	DIVIDE  { @Override double apply(double a, double b) { return a / b; } };

	abstract double apply(double a, double b);
}