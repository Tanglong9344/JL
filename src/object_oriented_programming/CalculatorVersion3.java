/**
 * ʵ�ֿɽ��мӼ��˳�����ļ��׼����� �汾3
 * ʹ�÷�װ���̳кͶ�̬˼��
 * ʹ�ô��������ά������չ����ǿ���븴����
 */

package object_oriented_programming;

public class CalculatorVersion3 {
	public static void main(String[] args) {
		double opNumA=Math.random()*CommonFinal.RANGE;//������1
		double opNumB=Math.random()*CommonFinal.RANGE;//������2
		char op = CommonFinal.OPERATIONS[(int)(Math.random()*4)];//�����
		Operation operation = findOperation(opNumA,opNumB,op);//��ȡ�������
		double result=operation.getResult();//������
		System.out.printf("%.2f%c%.2f=%.2f%n",opNumA,op,opNumB,result);
	}

	//��ȡ�������
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
class Add extends Operation{
	public Add(double opNumA, double opNumB) {
		super(opNumA,opNumB);//���ø���Ĺ��췽��
	}

	@Override
	public double getResult() {
		return getOpNumA()+getOpNumB();
	}
}

//������
class Minus extends Operation{
	public Minus(double opNumA, double opNumB) {
		super(opNumA, opNumB);
	}

	@Override
	public double getResult() {
		return getOpNumA()-getOpNumB();
	}
}

//�˷���
class Multiple extends Operation{
	public Multiple(double opNumA, double opNumB) {
		super(opNumA, opNumB);
	}

	@Override
	public double getResult() {
		return getOpNumA()*getOpNumB();
	}
}

//������
class Divide extends Operation{
	public Divide(double opNumA, double opNumB) {
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