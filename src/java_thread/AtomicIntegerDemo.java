package java_thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程安全的自增，自减方法
 */

public class AtomicIntegerDemo {
	public static void main(String[] args) throws InterruptedException {
		AtomicInteger atomicI = new AtomicInteger();
		System.out.println("new AtomicInteger():"+atomicI);
		int i = atomicI.decrementAndGet();
		System.out.println("atomicI.decrementAndGet():"+i);
		int j = atomicI.incrementAndGet();
		System.out.println("atomicI.incrementAndGet():"+j);
		int k = atomicI.addAndGet(3);
		System.out.println("atomicI.addAndGet(3):"+k);
	}
}
