/**
 * Lock和synchronized的区别
 * 1. Lock是一个接口，而synchronized是Java中的关键字，
 * 		synchronized是内置的语言实现，Lock是代码层面的实现。
 * 2. Lock可以选择性的获取锁，如果一段时间获取不到，可以放弃。
 * 		synchronized不行，会一根筋一直获取下去。
 * 		借助Lock的这个特性，就能够规避死锁，synchronized必须通过谨慎和良好的设计，才能减少死锁的发生。
 * 3. synchronized在发生异常和同步块结束的时候，会自动释放锁。
 * 		而Lock必须手动释放， 所以如果忘记了释放锁，一样会造成死锁。
 */

package java_thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLockConditionTest {
	//获取当前时间
	public static String now() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}
	//打印当前时间下的信息
	public static void log(String msg) {
		System.out.printf("%s %s %s %n", now() , Thread.currentThread().getName() , msg);
	}

	public static void main(String[] args) {
		//创建锁
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();

		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					log("线程启动");
					log("试图占有对象：lock");
					lock.lock();
					log("占有对象：lock");
					log("进行5秒的业务操作");
					Thread.sleep(5000);
					log("临时释放对象 lock， 并等待");
					//临时释放资源并等待
					condition.await();
					log("重新占有对象 lock，并进行5秒的业务操作");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					log("释放对象：lock");
					lock.unlock();
				}
				log("线程结束");
			}
		};
		t1.setName("t1");
		t1.start();
		try {
			//先让t1飞2秒
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					log("线程启动");
					log("试图占有对象：lock");
					lock.lock();
					log("占有对象：lock");
					log("进行5秒的业务操作");
					Thread.sleep(5000);
					log("唤醒等待中的线程");
					//唤醒等待的线程
					condition.signal();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					log("释放对象：lock");
					lock.unlock();
				}
				log("线程结束");
			}
		};
		t2.setName("t2");
		t2.start();
	}
}