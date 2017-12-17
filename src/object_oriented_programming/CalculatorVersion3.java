package object_oriented_programming;

import static object_oriented_programming.CommonConstants.OPERATIONS;
import static object_oriented_programming.CommonConstants.RANGE;

/**
 * ʵ�ֿɽ��мӼ��˳�����ļ��׼����� �汾3
 * ʹ�÷�װ���̳кͶ�̬˼��
 * ʹ�ô��������ά������չ����ǿ���븴����
 *
 * @author ����
 */
public class CalculatorVersion3 {
	public static void main(String[] args) {
		double opNumA=Math.random() * RANGE;//������1
		double opNumB=Math.random() * RANGE;//������2
		char op = OPERATIONS[(int)(Math.random()*4)];//�����
		Operation operation = createOperation(opNumA,opNumB,op);//��ȡ�������
		double result=operation.getResult();//������
		System.out.printf("%.2f%c%.2f=%.2f%n",opNumA,op,opNumB,result);
	}

	//��ȡ�������
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

//����������
class Operation{
	private double opNumA;//������1
	private double opNumB;//������2
	private double result=Double.MAX_VALUE;//������

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

//�ӷ���
class OpAdd extends Operation{
	public OpAdd(double opNumA, double opNumB) {
		super(opNumA,opNumB);//���ø���Ĺ��췽��
	}

	@Override
	public double getResult() {
		return getOpNumA()+getOpNumB();
	}
}

//������
class OpMinus extends Operation{
	public OpMinus(double opNumA, double opNumB) {
		super(opNumA, opNumB);
	}

	@Override
	public double getResult() {
		return getOpNumA()-getOpNumB();
	}
}

//�˷���
class OpMultiply extends Operation{
	public OpMultiply(double opNumA, double opNumB) {
		super(opNumA, opNumB);
	}

	@Override
	public double getResult() {
		return getOpNumA()*getOpNumB();
	}
}

//������
class OpDivide extends Operation{
	public OpDivide(double opNumA, double opNumB) {
		super(opNumA, opNumB);
	}

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