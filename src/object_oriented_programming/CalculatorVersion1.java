/**
 * ʵ�ֿɽ��мӼ��˳�����ļ��׼����� �汾1
 * δʹ���κ��������˼��
 */

package object_oriented_programming;

public class CalculatorVersion1 {
	public static void main(String[] args) {
		double opNumA=Math.random()*CommonFinal.RANGE;//������1
		double opNumB=Math.random()*CommonFinal.RANGE;//������2
		char op = CommonFinal.OPERATIONS[(int)(Math.random()*4)];//�����
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