/**
 * <strong>工厂方法模式</strong>
 * 定义一个用于创建对象的接口，
 * 让其子类决定具体实例化那个类。
 * 工厂方法使一个类的实例化延迟到其子类。
 *
 * 工厂方法模式是对简单工厂模式的进一步抽象
 *
 * 实现加减乘除简易计算器
 * 根据不同的操作方法分别实现相应的方法工厂
 */

package design_mode;

import object_oriented_programming.CommonFinal;

public class FactoryMethodMode {
	public static void main(String[] args) {
		double opNumA=Math.random()*CommonFinal.RANGE;//操作数1
		double opNumB=Math.random()*CommonFinal.RANGE;//操作数2
		char op = CommonFinal.OPERATIONS[(int)(Math.random()*4)];//运算符
		//由操作工厂根据不同运算符创建相应的操作类
		Factory factory = createOperation(op);
		if(factory!=null){
			Operation operation = factory.createOperation();
			operation.setOpNumA(opNumA);
			operation.setOpNumB(opNumB);
			double result=operation.getResult();//运算结果
			System.out.printf("%.2f%c%.2f=%.2f%n",opNumA,op,opNumB,result);
		}
	}

	//获取运算对象
	private static Factory createOperation(char op){
		switch(op){
		case '+':
			return new AddFactory();
		case '-':
			return new MinusFactory();
		case '*':
			return new MultiplyFactory();
		case '/':
			return new DivideFactory();
		default:
			return null;
		}
	}
}

//工厂类接口
interface Factory{
	public Operation createOperation();
}

//加法类工厂
class AddFactory implements Factory{
	@Override
	public Operation createOperation() {
		return new OpAdd();
	}
}

//减法类工厂
class MinusFactory implements Factory{
	@Override
	public Operation createOperation() {
		return new OpMinus();
	}
}

//乘法类工厂
class MultiplyFactory implements Factory{
	@Override
	public Operation createOperation() {
		return new OpMultiply();
	}
}

//除法类工厂
class DivideFactory implements Factory{
	@Override
	public Operation createOperation() {
		return new OpDivide();
	}
}