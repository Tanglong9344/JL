package something_interesting;

public class TrianglesTest {
	// 输出等腰三角形图形
	public static void showIsoscelesTriangle(int row) {
		int i,j,x;
		for (i = 1; i < row; i++) {
			for (j = 1; j <= row - i; j++) {
				System.out.print(" ");
			}
			for (x = 1; x <= i * 2 - 1; x++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	// 输出菱形图形
	public static void showDiamond(int row) {
		if (row >= 1) {
			int x, y;
			for (x = 1; x <= row; x++) {
				for (y = 1; y <= row - x; y++) {
					System.out.print(" ");
				}
				for (y = 1; y <= 2 * x - 1; y++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for (x = 1; x <= row; x++) {
				for (y = 1; y <= x; y++) {
					System.out.print(" ");
				}
				for (y = 1; y <= 2 * (row - x) - 1; y++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else {
			System.out.println("您输入的行数错误，请重新输入！！！");
		}
	}
	//输出直角三角形
	public static void showRightAngle(int row) {
		int i,x;
		for (i = 1; i <= row; i++) {
			for (x = 1; x < i; x++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	//输出杨辉三角
	public static void yh_Triangle(int array[][], int rows) {
		// 行循环
		for (int i = 0; i <= rows; i++) {
			// 列循环
			for (int j = 0; j <= array[i].length - 1; j++) {
				if (0 == i|| 0 == j || array[i].length - 1 == j) {
					array[i][j] = 1; // 将两边元素设为1
				} else {
					// 元素值为其正上方元素与左上角元素之和
					array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
				}
			}
		}
		for (int i = 0; i <= rows; i++) {
			for (int j = 0; j <= array[i].length - 1; j++){
				// 输出数组元素
				System.out.print(array[i][j] + " ");
			}
			System.out.println(); // 换行
		}
	}

	//九九乘法表
	public static void multiTab(){
		for (int i = 1, j = 1; j <= 9; i++) {
			System.out.print(i + "*" + j + "=" + i * j + " ");
			//换行
			if (i == j) {
				i = 0;
				j++;
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		// 输出行数为7的等腰三角形图案
		System.out.println("输出等腰三角形图案");
		showIsoscelesTriangle(7);
		// 输出行数为5的菱形图案
		System.out.println("输出菱形图案");
		showDiamond(5);
		// 输出行数为5的直角三角形图案
		System.out.println("输出直角三角形图案");
		showRightAngle(5);
		//输出杨辉三角
		final int ROWS = 10;// 设置行数
		int array[][] = new int[ROWS + 1][];
		// 循环初始化数组
		for (int i = 0; i <= ROWS; i++) {
			array[i] = new int[i + 1];
		}
		System.out.println("杨辉三角如下：");
		yh_Triangle(array, ROWS);
		//输出九九乘法表
		System.out.println("九九乘法表：");
		multiTab();
	}
}