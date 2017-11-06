/**
 * Lock��synchronized������
 * 1. Lock��һ���ӿڣ���synchronized��Java�еĹؼ��֣�
 * synchronized�����õ�����ʵ�֣�Lock�Ǵ�������ʵ�֡�
 * 2. Lock����ѡ���ԵĻ�ȡ�������һ��ʱ���ȡ���������Է�����
 * synchronized��һֱ��ȡ��ȥ��
 * ����Lock��������ԣ����ܹ����������synchronized����ͨ�����������õ���ƣ����ܼ��������ķ�����
 * 3. synchronized�ڷ����쳣��ͬ���������ʱ�򣬻��Զ��ͷ�����
 * ��Lock�����ֶ��ͷţ� ��������������ͷ�����һ�������������
 */

package java_thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLockTry {
	//This is a test
	public static void main(String[] args) {
		//������
		Lock lock=new ReentrantLock();

		ThreadLockTryTest th1 = new ThreadLockTryTest(lock);
		ThreadLockTryTest th2 = new ThreadLockTryTest(lock);
		th1.setName("�߳�-1");
		th2.setName("�߳�-2");
		th1.start();
		th2.start();
	}
}

/**��������*/
class ThreadLockTryTest extends Thread{
	//������
	private Lock lock;

	public ThreadLockTryTest(Lock lock){
		this.lock=lock;
	}
	@Override
	public void run() {
		boolean locked = false;
		try {
			PrintLog.log("�߳�����");
			PrintLog.log("��ͼռ�ж���lock");
			locked=lock.tryLock(1, TimeUnit.SECONDS);
			if(locked){
				PrintLog.log("ռ�ж���lock");
				PrintLog.log("����5���ҵ�����");
				Thread.sleep(5000);
			}else{
				PrintLog.log("����1���ӵ�Ŭ������û��ռ�ж��󣬷���ռ��");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if(locked){
				PrintLog.log("�ͷŶ���lock");
				lock.unlock();
			}
		}
		PrintLog.log("�߳̽���");
	}
}