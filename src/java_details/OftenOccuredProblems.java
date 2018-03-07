package java_details;

/**
 * Some problems that often encounter
 *
 * @author tanglong
 *
 */
public class OftenOccuredProblems {
	public static void main(String[] args) {
		// 1. short number operation
		short s1 = 1;
		s1 += 1; // transfer to 'int' automatically
		s1 = (short)(s1 + 1);
		// 's1' and other number that is shorter than 'int'
		// will be transfered to 'int' before calculating
		// s1 = s1 + 1;

		// float number operation
		System.out.println(3*0.1);
		System.out.println(3*0.1 == 0.3); // false

		// logical operator
		// &&: 逻辑运算
		// 左边为假则终止运算
		int n = 1;
		if(n>1 && ++n<3) {;}
		System.out.println("n=" + n);
		// &: 位运算和逻辑运算
		// 先运算左右部分，在进行逻辑运算
		n = 1;
		if(n>1 & ++n<3) {;}
		System.out.println("n=" + n);

		char ch2 = '唐';
		char ch1 = 'T';
		System.out.println("ch1=" + ch1 + "\nch2=" + ch2);

		// type transform
		// double vs long
		double pi = Math.PI;
		long piL = (long) pi;
		System.out.println("pi: " + pi);
		System.out.println("piL: " + piL);
		// byte vs int
		// in the range of byte
		int i1  = 127;
		byte b1 = (byte)i1;
		System.out.println("i1: " + i1);
		System.out.println("b1: " + b1);
		// beyond the range of byte
		int i2  = 129;
		byte b2 = (byte)i2;
		System.out.println("i2: " + i2);
		System.out.println("b2: " + b2);
	}
}