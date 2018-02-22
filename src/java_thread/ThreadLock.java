package java_thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock��synchronized������
 * 1. Lock��һ���ӿڣ���synchronized��Java�еĹؼ��֣�
 *    synchronized�����õ�����ʵ�֣�Lock�Ǵ�������ʵ�֡�
 * 2. Lock����ѡ���ԵĻ�ȡ�������һ��ʱ���ȡ���������Է�����synchronized��һֱ��ȡ��ȥ��
 *    ����Lock��������ԣ����ܹ����������synchronized����ͨ�����������õ���ƣ����ܼ��������ķ�����
 * 3. synchronized�ڷ����쳣��ͬ���������ʱ�򣬻��Զ��ͷ�����
 *    ��Lock�����ֶ��ͷţ� ��������������ͷ�����һ�������������
 *
 * @author ����
 *
 */
public class ThreadLock {
	//This is a test
	public static void main(String[] args) {
		//������
		Lock lock=new ReentrantLock();

		ThreadLockTest th1 = new ThreadLockTest(lock);
		ThreadLockTest th2 = new ThreadLockTest(lock);
		th1.setName("�߳�-1");
		th2.setName("�߳�-2");
		th1.start();
		th2.start();
	}
}

/** ��������  */
class ThreadLockTest extends Thread{
	//������
	private Lock lock;

	public ThreadLockTest(Lock lock){
		this.lock=lock;
	}
	@Override
	public void run() {
		try {
			PrintLog.log("�߳�����");
			PrintLog.log("��ͼռ�ж���lock");
			lock.lock();
			PrintLog.log("ռ�ж���lock");
			PrintLog.log("����5���ҵ�����");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			PrintLog.log("�ͷŶ���lock");
			lock.unlock();
		}
		PrintLog.log("�߳̽���");
	}
}