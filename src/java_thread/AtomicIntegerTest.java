package java_thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
	//This is a test
	public static void main(String[] args) {
		AutomicOperation ao = new AutomicOperation();
		//ԭ�Ӳ���
		ao.atomicOperation();
		//��ԭ�Ӳ���
		ao.nonAtomicOperation();
	}
}

/**
 * ԭ�Ӳ������ԭ�Ӳ����Ա�
 * @author ����
 */
class AutomicOperation{
	private static final int THREAD_NUMBER=100;
	static Thread[] ts = new Thread[THREAD_NUMBER];
	static Integer nonValue = 0;
	AtomicInteger atomicValue =new AtomicInteger();

	/**
	 * ��ԭ�Ӳ���
	 */
	public void nonAtomicOperation(){
		threadsCreate('0');
		System.out.printf("%d���߳̽��м�1��������ֵ���:%d%n", THREAD_NUMBER,nonValue);
	}

	/**
	 * ԭ�Ӳ���
	 */
	public void atomicOperation(){
		threadsCreate('1');
		System.out.printf("%d���߳̽��м�1��������ֵ���:%d%n", THREAD_NUMBER,atomicValue.intValue());
	}


	/**
	 * @param ch ��0������ԭ�Ӳ�������1����ԭ�Ӳ���
	 */
	private void threadsCreate(char ch){
		for (int i = 0; i < THREAD_NUMBER; i++) {
			Thread t = new Thread(){
				@Override
				public void run(){
					if('1' == ch) {
						atomicValue.incrementAndGet();
					}else{
						nonValue++;
						//nonValue����ͬ����Ч����ԭ�Ӳ�����ͬ
						//synchronized(nonValue){nonValue++;}
					}
				}
			};
			t.start();
			ts[i] = t;
		}

		//�ȴ���Щ�߳�ȫ������
		for (Thread t : ts) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}