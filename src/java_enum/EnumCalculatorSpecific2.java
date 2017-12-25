package java_enum;

/**
 * enum calculator overriding toStrig
 *
 * @author ÌÆÁú
 *
 */
public class EnumCalculatorSpecific2 {
	public static void main(String[] args) {
		double a = 12;
		double b = 3;
		Calculator3[] ops = Calculator3.values();
		for(Calculator3 op : ops) {
			System.out.printf("%.2f %s %.2f = %.2f%n", a, op, b, op.apply(a, b));
		}
	}
}

/**Constant-specific method implementation*/
enum Calculator3{
	ADD("+")     { @Override double apply(double a, double b) { return a + b; } },
	MINUS("-")   { @Override double apply(double a, double b) { return a - b; } },
	MITIPLY("*") { @Override double apply(double a, double b) { return a * b; } },
	DIVIDE("/")  { @Override double apply(double a, double b) { return a / b; } };

	private final String symbol;

	Calculator3(String symbol){this.symbol = symbol;}

	@Override public String toString() {return symbol;}

	abstract double apply(double a, double b);
}