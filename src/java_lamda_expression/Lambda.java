package java_lamda_expression;

import static java_lamda_expression.CommonConstant.N;
import static java_lamda_expression.CommonConstant.RANGE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Lambda Filter
 *
 * @author ����
 */
public class Lambda{
	public static void main(String[] args) {
		Random r = new Random();
		List<String> strs = new ArrayList<String>();
		//��ʼ��
		for (int i = 1; i <= N; i++) {
			strs.add("String" + r.nextInt(RANGE));
		}
		System.out.println("��ʼ����ļ���:\n" + strs);
		System.out.println("ʹ��Lamdba�ķ�ʽ��ɸѡ�����һ���ַ�Ϊż�����ַ���:");
		Checker.filter(strs,new Checker());
	}
}