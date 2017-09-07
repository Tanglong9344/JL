package something_interesting;

public class TrianglesTest {
	// �������������ͼ��
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
	// �������ͼ��
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
			System.out.println("������������������������룡����");
		}
	}
	//���ֱ��������
	public static void showRightAngle(int row) {
		int i,x;
		for (i = 1; i <= row; i++) {
			for (x = 1; x < i; x++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	//����������
	public static void yh_Triangle(int array[][], int rows) {
		// ��ѭ��
		for (int i = 0; i <= rows; i++) {
			// ��ѭ��
			for (int j = 0; j <= array[i].length - 1; j++) {
				if (0 == i|| 0 == j || array[i].length - 1 == j) {
					array[i][j] = 1; // ������Ԫ����Ϊ1
				} else {
					// Ԫ��ֵΪ�����Ϸ�Ԫ�������Ͻ�Ԫ��֮��
					array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
				}
			}
		}
		for (int i = 0; i <= rows; i++) {
			for (int j = 0; j <= array[i].length - 1; j++){
				// �������Ԫ��
				System.out.print(array[i][j] + " ");
			}
			System.out.println(); // ����
		}
	}

	//�žų˷���
	public static void multiTab(){
		for (int i = 1, j = 1; j <= 9; i++) {
			System.out.print(i + "*" + j + "=" + i * j + " ");
			//����
			if (i == j) {
				i = 0;
				j++;
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		// �������Ϊ7�ĵ���������ͼ��
		System.out.println("�������������ͼ��");
		showIsoscelesTriangle(7);
		// �������Ϊ5������ͼ��
		System.out.println("�������ͼ��");
		showDiamond(5);
		// �������Ϊ5��ֱ��������ͼ��
		System.out.println("���ֱ��������ͼ��");
		showRightAngle(5);
		//����������
		final int ROWS = 10;// ��������
		int array[][] = new int[ROWS + 1][];
		// ѭ����ʼ������
		for (int i = 0; i <= ROWS; i++) {
			array[i] = new int[i + 1];
		}
		System.out.println("����������£�");
		yh_Triangle(array, ROWS);
		//����žų˷���
		System.out.println("�žų˷���");
		multiTab();
	}
}