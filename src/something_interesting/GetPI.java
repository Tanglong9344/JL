package something_interesting;

public class GetPI {
	public static void main(String[] args) {
		final int N = 10000_0000;// 投的点数
		int m = 0;// 投中的个数
		double x, y;// x和y坐标点
		for (int i = 0; i < N; i++) {
			// 随机产生一个点
			x = Math.random();
			y = Math.random();
			// 计算这个点是位于圆内还是圆外
			if (x * x + y * y <= 1) {
				m++;
			}
		}
		// 统计得到π的值
		System.out.println("根据随机数计算π的结果如下：");
		System.out.println("PI:" + (double) m / N * 4);
	}
}