package java_thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
	//This is a test
	public static void main(String[] args) {
		AutomicOperation ao = new AutomicOperation();
		//原子操作
		ao.atomicOperation();
		//非原子操作
		ao.nonAtomicOperation();
	}
}

/**
 * 原子操作与非原子操作对比
 * @author 唐龙
 */
class AutomicOperation{
	private static final int THREAD_NUMBER=100;
	static Thread[] ts = new Thread[THREAD_NUMBER];
	static Integer nonValue = 0;
	AtomicInteger atomicValue =new AtomicInteger();

	/**
	 * 非原子操作
	 */
	public void nonAtomicOperation(){
		threadsCreate('0');
		System.out.printf("%d个线程进行加1操作后，数值变成:%d%n", THREAD_NUMBER,nonValue);
	}

	/**
	 * 原子操作
	 */
	public void atomicOperation(){
		threadsCreate('1');
		System.out.printf("%d个线程进行加1操作后，数值变成:%d%n", THREAD_NUMBER,atomicValue.intValue());
	}


	/**
	 * @param ch ‘0’：非原子操作，‘1’：原子操作
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
						//nonValue进行同步，效果与原子操作相同
						//synchronized(nonValue){nonValue++;}
					}
				}
			};
			t.start();
			ts[i] = t;
		}

		//等待这些线程全部结束
		for (Thread t : ts) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}