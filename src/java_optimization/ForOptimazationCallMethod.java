package java_optimization;

/**
 * �������÷���ѭ��֮��
 * @author ����
 */
public class ForOptimazationCallMethod {
	static long startTime;// ��ʼʱ��
	static long endTime;// ����ʱ��
	static int i,j;

	public static void main(String[] args) throws InterruptedException {
		// ��������
		/**�ⲿ����*/
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				int MIN = getMIN();
				int MAX = getMAX();
				startTime = System.nanoTime();
				for (i = 0; i < MIN;i++) {
					for (j = 0; j < MAX;j++) {}
				}
				endTime = System.nanoTime();
				System.out.println("��ѭ���ⲿ���÷�����ʱ��" + (endTime - startTime) + "ns");
			}
		};

		/**�ڲ�����*/
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				startTime = System.nanoTime();
				for (i = 0; i < getMIN();i++) {
					for (j = 0; j < getMAX();j++) {}
				}
				endTime = System.nanoTime();
				System.out.println("��ѭ���ڲ����÷�����ʱ��" + (endTime - startTime) + "ns");
			}
		};
		thread1.start();
		thread2.start();
	}

	public static int getMIN() {
		for (int i = 0; i < Constant.MAX;i++) {
			;
		}
		return Constant.MIN;
	}

	public static int getMAX() {
		for (int i = 0; i < Constant.MAX;i++) {
			;
		}
		return Constant.MAX;
	}
}