package java_enum;

/**
 * enum calculator using an interface
 *
 * @author ÌÆÁú
 *
 */
public class EnumCalculatorSpecific3 {
	public static void main(String[] args) {
		double a = 12;
		double b = 3;
		Calculator4[] ops = Calculator4.values();
		for(Calculator4 op : ops) {
			System.out.printf("%.2f %s %.2f = %.2f%n", a, op, b, op.apply(a, b));
		}
	}
}

/**Emulated extensible enum using an interface*/
interface Operation{
	double apply(double a, double b);
}

/**Constant-specific method implementation*/
enum Calculator4 implements Operation {
	ADD("+")      { @Override public double apply(double a, double b) { return a + b; } },
	MINUS("-")    { @Override public double apply(double a, double b) { return a - b; } },
	MITIPLY("*")  { @Override public double apply(double a, double b) { return a * b; } },
	DIVIDE("/")   { @Override public double apply(double a, double b) { return a / b; } },
	EXP("^")      { @Override public double apply(double a, double b) { return Math.pow(a, b); } },
	REMINDER("%") { @Override public double apply(double a, double b) { return a % b; } };

	private final String symbol;

	Calculator4(String symbol){this.symbol = symbol;}

	@Override public String toString() {return symbol;}
}