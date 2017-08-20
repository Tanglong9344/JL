package java_thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
	private static int value = 0;
	private static AtomicInteger atomicValue =new AtomicInteger();
	public static void main(String[] args) {
		int number = 10000;
		Thread[] ts1 = new Thread[number];
		for (int i = 0; i < number; i++) {
			Thread t =new Thread(){
				@Override
				public void run(){
					value++;
				}
			};
			t.start();
			ts1[i] = t;
		}

		//�ȴ���Щ�߳�ȫ������
		for (Thread t : ts1) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("%d���߳̽���value++��value��ֵ���:%d%n", number,value);

		Thread[] ts2 = new Thread[number];
		for (int i = 0; i < number; i++) {
			Thread t =new Thread(){
				@Override
				public void run(){
					atomicValue.incrementAndGet();
				}
			};
			t.start();
			ts2[i] = t;
		}

		//�ȴ���Щ�߳�ȫ������
		for (Thread t : ts2) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("%d���߳̽���atomicValue.incrementAndGet();��atomicValue��ֵ���:%d%n", number,atomicValue.intValue());
	}
}