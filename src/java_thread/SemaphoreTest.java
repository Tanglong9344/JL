package java_thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Java Semaphore
 *
 * @author 唐龙
 *
 */
public class SemaphoreTest {
	public static void main(String[] args){
		SemaphoreTest st = new SemaphoreTest();
		Thread[] threads = new Thread[100];
		for (int i = 0; i < 100; i++) {
			Thread thread = new Thread(new ResourceUser(st,i));//创建多个资源使用者
			threads[i] = thread;
		}
		for(int i = 0; i < 100; i++){
			Thread thread = threads[i];
			try {
				thread.start();//启动线程
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}

	private final int N = 10;
	private final Semaphore semaphore ;
	private boolean resourceArray[];
	private final ReentrantLock lock;

	/**Constructor*/
	public SemaphoreTest(){
		resourceArray = new boolean[N];
		semaphore = new Semaphore(10, true);//First come first server
		lock = new ReentrantLock(true);//First come first server

		// Initialize the resource to be usable
		for(int i=0;i<N;i++){
			resourceArray[i] = true;
		}
	}

	/**Use resource*/
	public void useResource(int userId) throws InterruptedException{
		semaphore.acquire();
		try{
			int id = getResourceId();//get usable resource
			System.out.println("userId: " + userId + "正在使用资源，资源id:" + id);
			Thread.sleep(100);//do something
			resourceArray[id] = true;//release resource
		}catch (InterruptedException e){
			e.printStackTrace();
		}finally {
			semaphore.release();//释放信号量，计数器加1
		}
	}

	/**get usable resource*/
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

/**Resource User*/
class ResourceUser implements Runnable{
	private SemaphoreTest st;
	private int userId;
	public ResourceUser(SemaphoreTest st, int userId) {
		this.st = st;
		this.userId = userId;
	}

	@Override
	public void run(){
		System.out.print("userId:" + userId + "准备使用资源...\n");
		try {
			st.useResource(userId);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("userId:" + userId + "使用资源完毕...\n");
	}
}