package java_effective_code;

/**
 * Test Fraction class
 *
 * @author ÌÆÁú
 *
 */
public class FractionTest {
	public static void main(String[] args) {
		Fraction f1 = new Fraction(1,2);
		System.out.println(f1.toString());
		System.out.println(f1.toDecimal());

		Fraction f2 = new Fraction(3,5);
		System.out.println(f2.toString());
		System.out.println(f2.toDecimal());

		// faction(+ - * /)fraction,return fraction
		System.out.println(f1.add(f2).toString());
		System.out.println(f1.substract(f2).toString());
		System.out.println(f1.multiply(f2).toString());
		System.out.println(f1.divide(f2).toString());
		// faction(+ - * /)int,return fraction
		System.out.println(f1.add(2).toString());
		System.out.println(f1.substract(2).toString());
		System.out.println(f1.multiply(2).toString());
		System.out.println(f1.divide(2).toString());

		// faction(+ - * /)fraction,return decimal
		System.out.println(f1.add(f2).toDecimal());
		System.out.println(f1.substract(f2).toDecimal());
		System.out.println(f1.multiply(f2).toDecimal());
		System.out.println(f1.divide(f2).toDecimal());
		// faction(+ - * /)int,return decimal
		System.out.println(f1.add(2).toDecimal());
		System.out.println(f1.substract(2).toDecimal());
		System.out.println(f1.multiply(2).toDecimal());
		System.out.println(f1.divide(2).toDecimal());
	}
}