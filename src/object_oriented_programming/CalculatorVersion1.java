/**
 * 实现可进行加减乘除运算的简易计算器 版本1
 * 未使用任何面向对象思想
 */

package object_oriented_programming;

public class CalculatorVersion1 {
	public static void main(String[] args) {
		double opNumA=Math.random()*CommonFinal.RANGE;//操作数1
		double opNumB=Math.random()*CommonFinal.RANGE;//操作数2
		char op = CommonFinal.OPERATIONS[(int)(Math.random()*4)];//运算符
		double result;//运算结果
		switch(op){
		case '+':
			result=opNumA+opNumB;
			break;
		case '-':
			result=opNumA-opNumB;
			break;
		case '*':
			result=opNumA*opNumB;
			break;
		case '/':
			if((int)opNumB!=0) {
				result=opNumA/opNumB;
			}else{
				System.out.println("除数不允许为0。");//除数为0
				result=Double.NaN;//设为非数值
			}
			break;
		default:
			result=Double.MAX_VALUE;//其它情况
			break;
		}
		System.out.printf("%.2f%c%.2f=%.2f%n",opNumA,op,opNumB,result);
	}
}