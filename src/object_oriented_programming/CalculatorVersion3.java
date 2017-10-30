/**
 * 实现可进行加减乘除运算的简易计算器 版本3
 * 使用封装，继承和多态思想
 * 使得代码更易于维护和扩展，增强代码复用性
 */

package object_oriented_programming;

public class CalculatorVersion3 {
	public static void main(String[] args) {
		double opNumA=Math.random()*CommonFinal.RANGE;//操作数1
		double opNumB=Math.random()*CommonFinal.RANGE;//操作数2
		char op = CommonFinal.OPERATIONS[(int)(Math.random()*4)];//运算符
		Operation operation = findOperation(opNumA,opNumB,op);//获取运算对象
		double result=operation.getResult();//运算结果
		System.out.printf("%.2f%c%.2f=%.2f%n",opNumA,op,opNumB,result);
	}

	//获取运算对象
	private static Operation findOperation(double opNumA,double opNumB,char op){
		switch(op){
		case '+':
			return new Add(opNumA,opNumB);
		case '-':
			return new Minus(opNumA,opNumB);
		case '*':
			return new Multiple(opNumA,opNumB);
		case '/':
			return new Divide(opNumA,opNumB);
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
class Add extends Operation{
	public Add(double opNumA, double opNumB) {
		super(opNumA,opNumB);//调用父类的构造方法
	}

	@Override
	public double getResult() {
		return getOpNumA()+getOpNumB();
	}
}

//减法类
class Minus extends Operation{
	public Minus(double opNumA, double opNumB) {
		super(opNumA, opNumB);
	}

	@Override
	public double getResult() {
		return getOpNumA()-getOpNumB();
	}
}

//乘法类
class Multiple extends Operation{
	public Multiple(double opNumA, double opNumB) {
		super(opNumA, opNumB);
	}

	@Override
	public double getResult() {
		return getOpNumA()*getOpNumB();
	}
}

//除法类
class Divide extends Operation{
	public Divide(double opNumA, double opNumB) {
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