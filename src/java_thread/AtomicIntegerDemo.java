package java_thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程安全的自增，自减方法
 * @author 唐龙
 */
public class AtomicIntegerDemo {
	public static void main(String[] args) throws InterruptedException {
		//创建并初始化(默认值为0)
		AtomicInteger atomicI = new AtomicInteger();
		System.out.println("new AtomicInteger():"+atomicI);
		//减1
		int i = atomicI.decrementAndGet();
		System.out.println("atomicI.decrementAndGet():"+i);
		//加1
		int j = atomicI.incrementAndGet();
		System.out.println("atomicI.incrementAndGet():"+j);
		//加3
		int k = atomicI.addAndGet(3);
		System.out.println("atomicI.addAndGet(3):"+k);
	}
}