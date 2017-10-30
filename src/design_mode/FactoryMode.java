/**
 * ʵ�ֿɽ��мӼ��˳�����ļ��׼����� �汾3
 * ʹ�÷�װ���̳кͶ�̬˼��
 * ʹ�ô��������ά������չ����ǿ���븴����
 */

package design_mode;

import object_oriented_programming.CommonFinal;

public class FactoryMode {
	public static void main(String[] args) {
		double opNumA=Math.random()*CommonFinal.RANGE;//������1
		double opNumB=Math.random()*CommonFinal.RANGE;//������2
		char op = CommonFinal.OPERATIONS[(int)(Math.random()*4)];//�����
		//�ɲ����������ݲ�ͬ�����������Ӧ�Ĳ�����
		Operation operation = OperationFactory.createOperation(op);
		operation.setOpNumA(opNumA);//���ò�����1
		operation.setOpNumB(opNumB);//���ò�����2
		double result=operation.getResult();//������
		System.out.printf("%.2f%c%.2f=%.2f%n",opNumA,op,opNumB,result);
	}
}

//����������
class Operation{
	private double opNumA;//������1
	private double opNumB;//������2
	private double result=Double.MAX_VALUE;//������

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

//�ӷ���
class OpAdd extends Operation{
	@Override
	public double getResult() {
		return getOpNumA()+getOpNumB();
	}
}

//������
class OpMinus extends Operation{
	@Override
	public double getResult() {
		return getOpNumA()-getOpNumB();
	}
}

//�˷���
class OpMultiple extends Operation{
	@Override
	public double getResult() {
		return getOpNumA()*getOpNumB();
	}
}

//������
class OpDivide extends Operation{
	@Override
	public double getResult() {
		if((int)getOpNumB()!=0) {
			return getOpNumA()/getOpNumB();
		}else{
			System.out.println("����������Ϊ0��");//����Ϊ0
			return Double.NaN;
		}
	}
}

//����������
class OperationFactory{
	//��ȡ�������
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
			operation=new OpMultiple();
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