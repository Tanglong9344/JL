package something_interesting;

public class GetPI {
	public static void main(String[] args) {
		final int N = 10000_0000;// Ͷ�ĵ���
		int m = 0;// Ͷ�еĸ���
		double x, y;// x��y�����
		for (int i = 0; i < N; i++) {
			// �������һ����
			x = Math.random();
			y = Math.random();
			// �����������λ��Բ�ڻ���Բ��
			if (x * x + y * y <= 1) {
				m++;
			}
		}
		// ͳ�Ƶõ��е�ֵ
		System.out.println("�������������еĽ�����£�");
		System.out.println("PI:" + (double) m / N * 4);
	}
}