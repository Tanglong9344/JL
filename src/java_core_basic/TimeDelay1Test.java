package java_core_basic;

public class TimeDelay1Test {
	public static void main(String[] args) {
		// ��ʱ1
		Thread.currentThread();
		for (int i = 0; i <= 10; i++) {
			try {
				Thread.sleep(500);// ��ʱ0.5s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("i=" + i);
		}
	}
}