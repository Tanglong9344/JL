package java_thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * �̰߳�ȫ���������Լ�����
 * @author ����
 */
public class AtomicIntegerDemo {
	public static void main(String[] args) throws InterruptedException {
		//��������ʼ��(Ĭ��ֵΪ0)
		AtomicInteger atomicI = new AtomicInteger();
		System.out.println("new AtomicInteger():"+atomicI);
		//��1
		int i = atomicI.decrementAndGet();
		System.out.println("atomicI.decrementAndGet():"+i);
		//��1
		int j = atomicI.incrementAndGet();
		System.out.println("atomicI.incrementAndGet():"+j);
		//��3
		int k = atomicI.addAndGet(3);
		System.out.println("atomicI.addAndGet(3):"+k);
	}
}