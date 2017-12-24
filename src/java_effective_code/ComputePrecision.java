package java_effective_code;

import java.math.BigDecimal;

/**
 * Compute precision in Java
 *
 * @author ÌÆÁú
 *
 */
public class ComputePrecision{
	public static void main(String[] args) {
		// float or double is not precise enough
		System.out.println(1-0.9);

		// BigDecimal
		BigDecimal bd1 = new BigDecimal("1");
		BigDecimal bd01 = new BigDecimal(".1");
		System.out.println(bd1.subtract(bd01));

		// int or long
		System.out.println((1*10-0.1*10)/10);
	}
}