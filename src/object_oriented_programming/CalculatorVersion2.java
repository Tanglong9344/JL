/**
 * ʵ�ֿɽ��мӼ��˳�����ļ��׼����� �汾2
 * ʹ�÷�װ˼��
 * ���ʹ���֮����϶�
 * ʹ�ô��������ά��
 */

package object_oriented_programming;

public class CalculatorVersion2 {
	public static void main(String[] args) {
		double opNumA=Math.random()*CommonFinal.RANGE;//������1
		double opNumB=Math.random()*CommonFinal.RANGE;//������2
		char op = CommonFinal.OPERATIONS[(int)(Math.random()*4)];//�����
		double result=operation(opNumA,opNumB,op);//������
		System.out.printf("%.2f%c%.2f=%.2f%n",opNumA,op,opNumB,result);
	}

	//���㷽��
	public static double operation(double opNumA,double opNumB,char op){
		double result=0;
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
				result=Double.NaN;//��Ϊ����ֵ
				System.out.println("����������Ϊ0��");//����Ϊ0
			}
			break;
		default:
			result=Double.MAX_VALUE;//�������
			break;
		}
		return result;
	}
}