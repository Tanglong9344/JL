package object_oriented_programming;

import static object_oriented_programming.CommonConstants.OPERATIONS;
import static object_oriented_programming.CommonConstants.RANGE;

/**
 * ʵ�ֿɽ��мӼ��˳�����ļ��׼����� �汾1
 * δʹ���κ��������˼��
 *
 * @author ����
 */
public class CalculatorVersion1 {
	public static void main(String[] args) {
		double opNumA=Math.random() * RANGE;//������1
		double opNumB=Math.random() * RANGE;//������2
		char op = OPERATIONS[(int)(Math.random()*4)];//�����
		double result;//������
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
				System.out.println("����������Ϊ0��");//����Ϊ0
				result=Double.NaN;//��Ϊ����ֵ
			}
			break;
		default:
			result=Double.MAX_VALUE;//�������
			break;
		}
		System.out.printf("%.2f%c%.2f=%.2f%n",opNumA,op,opNumB,result);
	}
}