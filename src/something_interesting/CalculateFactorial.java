package something_interesting;

import java.util.Scanner;

public class CalculateFactorial {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("������һ����������");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int n;
		int j;

		//���ѭ��
		System.out.println("���ѭ��ʵ�֣�");
		n = num;
		j=1;
		loop: while (true) {
			// ��ײ�ľ���ʵ��
			n = n * (num - j);
			j++;
			if (j == num){
				break loop;
			}
		}
		System.out.println(num + "�Ľ׳�Ϊ��" + n);

		System.out.println("whileѭ��ʵ�֣�");
		n = num;
		j=1;
		while (j != num) {
			// ��ײ�ľ���ʵ��
			n = n * (num - j);
			j++;
		}
		System.out.println(num + "�Ľ׳�Ϊ��" + n);

		System.out.println("forѭ��ʵ�֣�");
		n = num;
		for(j=1;j<num-1;j++) {
			// ��ײ�ľ���ʵ��
			n = n * (num - j);
		}
		System.out.println(num + "�Ľ׳�Ϊ��" + n);

		System.out.println("�ݹ�ʵ�֣�");
		System.out.println(num + "�Ľ׳�Ϊ��" + recursive(num));
	}

	//�ݹ���׳�
	//�㷨�ı�����һϵ�����޲������������С�
	static public int recursive(int n){
		if(1 == n){
			return 1;
		}else{
			return n*recursive(n-1);
		}
	}
}