package object_oriented_programming;

import static object_oriented_programming.CommonConstants.OPERATIONS;
import static object_oriented_programming.CommonConstants.RANGE;

/**
 * 实现可进行加减乘除运算的简易计算器 版本2
 * 使用封装思想
 * 降低代码之间耦合度
 * 使得代码更易于维护
 *
 * @author 唐龙
 */
public class CalculatorVersion2 {
	public static void main(String[] args) {
		double opNumA=Math.random() * RANGE;//操作数1
		double opNumB=Math.random() * RANGE;//操作数2
		char op = OPERATIONS[(int)(Math.random()*4)];//运算符
		double result=operation(opNumA,opNumB,op);//运算结果
		System.out.printf("%.2f%c%.2f=%.2f%n",opNumA,op,opNumB,result);
	}

	//运算方法
	public static double operation(double opNumA,double opNumB,char op){
		double result=0;
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
				result=Double.NaN;//设为非数值
				System.out.println("除数不允许为0。");//除数为0
			}
			break;
		default:
			result=Double.MAX_VALUE;//其它情况
			break;
		}
		return result;
	}
}