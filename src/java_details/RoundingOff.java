package java_details;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * float number's rounding off
 * 1. round
 * 2. BigDecimal
 * 3. NumberFormat
 * 4. DecimalFormat
 * 5. String.format
 *
 * @author tanglong
 *
 */
public class RoundingOff {
	public static void main(String[] args) {
		double number = Math.PI;
		int precision = 4;
		System.out.println("M1: " + roundingOff1(number, precision));
		System.out.println("M2: " + roundingOff2(number, precision));
		System.out.println("M3: " + roundingOff3(number, precision));
		System.out.println("M4: " + roundingOff4(number, precision));
		System.out.println("M5: " + roundingOff5(number, precision));
	}

	/**
	 * mehtod1
	 *
	 * @param, number the number need to be transform
	 * @param n, precision
	 * @return, the trandform result
	 */
	private static double roundingOff1(double number, int n) {
		int tmp = (int) Math.pow(10, n);
		return (double)Math.round(number * tmp) / tmp;
	}

	/** method2 */
	private static double roundingOff2(double number, int n) {
		BigDecimal bg = new BigDecimal(number).setScale(n, BigDecimal.ROUND_HALF_UP);
		return bg.doubleValue();
	}

	/** method3 */
	private static double roundingOff3(double number, int n) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(n); // precision
		nf.setRoundingMode(RoundingMode.UP); // rounding off
		return Double.valueOf(nf.format(number));
	}

	/** method4 */
	private static double roundingOff4(double number, int n) {
		StringBuilder precision = new StringBuilder();
		precision.append("#.");
		while(n-->0) {
			precision.append("0");
		}
		DecimalFormat df = new DecimalFormat(precision.toString());
		return Double.valueOf(df.format(number));
	}

	/** method5 */
	private static double roundingOff5(double number, int n) {
		return Double.valueOf(String.format("%." + n + "f", number));
	}
}