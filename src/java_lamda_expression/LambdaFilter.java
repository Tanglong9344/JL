package java_lamda_expression;

import static java_common.CommonValue.N;

import java.util.List;

/**
 * Lambda Filter
 *
 * @author ����
 */
public class LambdaFilter{
	public static void main(String[] args) {
		List<String> strs = java_common.CommonUtils.getList(N);
		System.out.println("��ʼ����ļ���:\n" + strs);
		System.out.println("ʹ��Lamdba�ķ�ʽ��ɸѡ�����һ���ַ�Ϊż�����ַ���:");
		Checker.filter(strs,new Checker());
	}
}