/**
 * 工厂模式(简单工厂模式)
 * 实现加减乘除简易计算器
 * 由操作工厂根据不同运算符创建相应的操作类
 */

package design_mode;

import object_oriented_programming.CommonConstants;

public class FactoryMode {
	public static void main(String[] args) {
		double opNumA=Math.random()*CommonConstants.RANGE;//操作数1
		double opNumB=Math.random()*CommonConstants.RANGE;//操作数2
		char op = CommonConstants.OPERATIONS[(int)(Math.random()*4)];//运算符
		//由操作工厂根据不同运算符创建相应的操作类
		Operation operation = OperationFactory.createOperation(op);
		operation.setOpNumA(opNumA);//设置操作数1
		operation.setOpNumB(opNumB);//设置操作数2
		double result=operation.getResult();//运算结果
		System.out.printf("%.2f%c%.2f=%.2f%n",opNumA,op,opNumB,result);
	}
}

//基本运算类
class Operation{
	private double opNumA;//操作数1
	private double opNumB;//操作数2
	private double result=Double.MAX_VALUE;//运算结果

	public Operation(){}

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
	@Override
	public double getResult() {
		return getOpNumA()+getOpNumB();
	}
}

//减法类
class OpMinus extends Operation{
	@Override
	public double getResult() {
		return getOpNumA()-getOpNumB();
	}
}

//乘法类
class OpMultiply extends Operation{
	@Override
	public double getResult() {
		return getOpNumA()*getOpNumB();
	}
}

//除法类
class OpDivide extends Operation{
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

//操作工厂类
class OperationFactory{
	//获取运算对象
	public static Operation createOperation(char op){
		Operation operation=null;
		switch(op){
		case '+':
			operation=new OpAdd();
			break;
		case '-':
			operation=new OpMinus();
			break;
		case '*':
			operation=new OpMultiply();
			break;
		case '/':
			operation=new OpDivide();
			break;
		default:
			operation=new Operation();
		}
		return operation;
	}
}