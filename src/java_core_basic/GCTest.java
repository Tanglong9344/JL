package java_core_basic;

/**
 * Java 垃圾回收机制
 * @author 唐龙
 */
public class GCTest {
	static final int N = 10;
	public static void main(String[] args) throws InterruptedException {
		GCTest[] gcs = new GCTest[N];
		// create objects
		for(int i=0;i<N;i++){
			gcs[i] = new GCTest();
		}

		for(int i=0,n=N/2;i<n;i++){
			gcs[i] = null; // tell gc thread that this object is garbage now
		}

		System.gc();//向垃圾回收方法发出垃圾回收请求
		Thread.sleep(1000);//暂停1s
		System.out.println("The program is over!");
	}

	//finalize方法，在对象被垃圾回收方法回收之前执行
	@Override
	public void finalize(){
		System.out.println("Garbage Collection!");
	}
}