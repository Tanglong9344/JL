/**
 * <strong>��������ģʽ</strong>
 * ����һ�����ڴ�������Ľӿڣ�
 * ���������������ʵ�����Ǹ��ࡣ
 * ��������ʹһ�����ʵ�����ӳٵ������ࡣ
 *
 * ��������ģʽ�ǶԼ򵥹���ģʽ�Ľ�һ������
 *
 * ʵ�ּӼ��˳����׼�����
 * ���ݲ�ͬ�Ĳ��������ֱ�ʵ����Ӧ�ķ�������
 */

package design_mode;

import object_oriented_programming.CommonFinal;

public class FactoryMethodMode {
	public static void main(String[] args) {
		double opNumA=Math.random()*CommonFinal.RANGE;//������1
		double opNumB=Math.random()*CommonFinal.RANGE;//������2
		char op = CommonFinal.OPERATIONS[(int)(Math.random()*4)];//�����
		//�ɲ����������ݲ�ͬ�����������Ӧ�Ĳ�����
		Factory factory = createOperation(op);
		if(factory!=null){
			Operation operation = factory.createOperation();
			operation.setOpNumA(opNumA);
			operation.setOpNumB(opNumB);
			double result=operation.getResult();//������
			System.out.printf("%.2f%c%.2f=%.2f%n",opNumA,op,opNumB,result);
		}
	}

	//��ȡ�������
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

//������ӿ�
interface Factory{
	public Operation createOperation();
}

//�ӷ��๤��
class AddFactory implements Factory{
	@Override
	public Operation createOperation() {
		return new OpAdd();
	}
}

//�����๤��
class MinusFactory implements Factory{
	@Override
	public Operation createOperation() {
		return new OpMinus();
	}
}

//�˷��๤��
class MultiplyFactory implements Factory{
	@Override
	public Operation createOperation() {
		return new OpMultiply();
	}
}

//�����๤��
class DivideFactory implements Factory{
	@Override
	public Operation createOperation() {
		return new OpDivide();
	}
}