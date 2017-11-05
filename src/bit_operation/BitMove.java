/**
 * 位移与乘除
 * 位移的效率要比直接进行乘除运算的效率高
 */

package bit_operation;

public class BitMove{
	public static void main(String[] args) {
		//乘法
		System.out.println("9*8  = " + 9*8);
		System.out.printf("9<<3 = %d%n",9<<3);

		//除法
		System.out.println("9/4  = " + 9/4);
		System.out.printf("9>>2 = %d%n",9>>2);

		//非2的倍数
		System.out.println("9*7  = " + 9*7);
		System.out.printf("(9<<3)-9 = %d%n",(9<<3)-9);
	}
}