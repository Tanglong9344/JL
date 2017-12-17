package object_oriented_programming;

import static object_oriented_programming.CommonConstants.OPERATIONS;
import static object_oriented_programming.CommonConstants.RANGE;

/**
 * 实现可进行加减乘除运算的简易计算器 版本3
 * 使用封装，继承和多态思想
 * 使得代码更易于维护和扩展，增强代码复用性
 *
 * @author 唐龙
 */
public class CalculatorVersion3 {
	public static void main(String[] args) {
		double opNumA=Math.random() * RANGE;//操作数1
		double opNumB=Math.random() * RANGE;//操作数2
		char op = OPERATIONS[(int)(Math.random()*4)];//运算符
		Operation operation = createOperation(opNumA,opNumB,op);//获取运算对象
		double result=operation.getResult();//运算结果
		System.out.printf("%.2f%c%.2f=%.2f%n",opNumA,op,opNumB,result);
	}

	//获取运算对象
	private static Operation createOperation(double opNumA,double opNumB,char op){
		switch(op){
		case '+':
			return new OpAdd(opNumA,opNumB);
		case '-':
			return new OpMinus(opNumA,opNumB);
		case '*':
			return new OpMultiply(opNumA,opNumB);
		case '/':
			return new OpDivide(opNumA,opNumB);
		default:
			return new Operation(opNumA,opNumB);
		}
	}
}

//基本运算类
class Operation{
	private double opNumA;//操作数1
	private double opNumB;//操作数2
	private double result=Double.MAX_VALUE;//运算结果

	public Operation(){}

	public Operation(double opNumA,double opNumB){
		this.opNumA=opNumA;
		this.opNumB=opNumB;
	}
	// getter and setter
	public double getOpNumA() {
		return opNumA;
	}

	public void setOpNumA(double opNumA) {
		this.opNumA = opNumA;
	}

	public double getOpNumB() {
		return opNumB;
	}

	public void setOpNumB(double opNumB) {
		this.opNumB = opNumB;
	}

	public double getResult() {
		return result;
	}
}

//加法类
class OpAdd extends Operation{
	public OpAdd(double opNumA, double opNumB) {
		super(opNumA,opNumB);//调用父类的构造方法
	}

	@Override
	public double getResult() {
		return getOpNumA()+getOpNumB();
	}
}

//减法类
class OpMinus extends Operation{
	public OpMinus(double opNumA, double opNumB) {
		super(opNumA, opNumB);
	}

	@Override
	public double getResult() {
		return getOpNumA()-getOpNumB();
	}
}

//乘法类
class OpMultiply extends Operation{
	public OpMultiply(double opNumA, double opNumB) {
		super(opNumA, opNumB);
	}

	@Override
	public double getResult() {
		return getOpNumA()*getOpNumB();
	}
}

//除法类
class OpDivide extends Operation{
	public OpDivide(double opNumA, double opNumB) {
		super(opNumA, opNumB);
	}

	@Override
	public double getResult() {
		if((int)getOpNumB()!=0) {
			return getOpNumA()/getOpNumB();
		}else{
			System.out.println("除数不允许为0。");//除数为0
			return Double.NaN;
		}
	}
}