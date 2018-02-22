package java_thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Java Semaphore
 *
 * @author ����
 *
 */
public class SemaphoreTest {
	private final static int N = 100;
	private final Semaphore semaphore ;
	private boolean resourceArray[];
	private final ReentrantLock lock;

	/** Constructor */
	public SemaphoreTest(){
		resourceArray = new boolean[N];
		semaphore = new Semaphore(10, true); //First come first serve
		lock = new ReentrantLock(true); //First come first serve

		// Initialize the resource
		for(int i=0;i<N;i++){
			resourceArray[i] = true;
		}
	}

	public static void main(String[] args){
		SemaphoreTest st = new SemaphoreTest();
		Thread[] threads = new Thread[N];
		for (int i = 0; i < N; i++) {
			Thread thread = new Thread(new ResouceUser(st,i));//���������Դʹ����
			threads[i] = thread;
		}
		for(int i = 0; i < N; i++){
			Thread thread = threads[i];
			try {
				thread.start();//�����߳�
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}

	/** Use resource */
	public void useResource(int userId) throws InterruptedException{
		semaphore.acquire();
		try{
			int id = getResourceId();//get usable resource
			System.out.println("userId: " + userId + "����ʹ����Դ����Դid:" + id);
			Thread.sleep(100); //do something
			resourceArray[id] = true;//release resource
		}catch (InterruptedException e){
			e.printStackTrace();
		}finally {
			semaphore.release();//�ͷ��ź�������������1
		}
	}

	/** get usable resource */
	private int getResourceId(){
		int id = -1;
		lock.lock();
		try {
			for(int i=0; i< N; i++){
				if(resourceArray[i]){
					resourceArray[i] = false;
					id = i;
					break;
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		return id;
	}
}

/** Resource User */
class ResouceUser implements Runnable{
	private SemaphoreTest st;
	private int userId;
	public ResouceUser(SemaphoreTest st, int userId) {
		this.st = st;
		this.userId = userId;
	}

	@Override
	public void run(){
		System.out.print("userId: " + userId + "׼��ʹ����Դ...\n");
		try {
			st.useResource(userId);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("userId: " + userId + "ʹ����Դ���...\n");
	}
}