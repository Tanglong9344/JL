package java_core_basic;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Java BigNumber
 * @author 唐龙
 */
public class BigNumber {
	static final int N = 10;
	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int i = N;

		System.out.println("------------------BigInteger----------------");
		//BigInteger
		//数据初始化
		while((i--)>0){
			sb1.append("8");
			sb2.append("3");
		}
		BigInteger bi1 = new BigInteger(sb1.toString());
		System.out.println("bi1=" + bi1);
		BigInteger bi2 = new BigInteger(sb2.toString());
		System.out.println("bi2=" + bi2);
		//add
		System.out.println("bi1 + bi2=" + bi1.add(bi2));
		//subtract
		System.out.println("bi1 - bi2=" + bi1.subtract(bi2));
		//multiply
		System.out.println("bi1 * bi2=" + bi1.multiply(bi2));
		//divide
		System.out.println("bi1 / bi2=" + bi1.divide(bi2));
		//max
		System.out.println("max(bi1,bi2)=" + bi1.max(bi2));
		//min
		System.out.println("min(bi1,bi2)=" + bi1.min(bi2));
		//mod
		System.out.println("bi1 % bi2=" + bi1.mod(bi2));

		System.out.println("\n------------------BigDecmal----------------");
		//BigDecmal
		//数据初始化
		i = N;
		sb1 = new StringBuilder();
		sb2 = new StringBuilder();
		while((i--)>0){
			sb1.append("8");
			sb2.append("3");
			if(i == (N/2)){
				sb1.append(".");
				sb2.append(".");
			}
		}
		BigDecimal bd1 = new BigDecimal(sb1.toString());
		System.out.println("bd1=" + bd1);
		BigDecimal bd2 = new BigDecimal(sb2.toString());
		System.out.println("bd2=" + bd2);
		//add
		System.out.println("bd1 + bd2=" + bd1.add(bd2));
		//subtract
		System.out.println("bd1 - bd2=" + bd1.subtract(bd2));
		//multiply
		System.out.println("bd1 * bd2=" + bd1.multiply(bd2));
		//divide
		System.out.println("bd1 / bd2=" + bd1.divide(bd2,1));
		//max
		System.out.println("max(bd1,bd2)=" + bd1.max(bd2));
		//min
		System.out.println("min(bd1,bd2)=" + bd1.min(bd2));
	}
}
