/**
 * Java 垃圾回收机制
 */

package java_core_basic;

public class GCTest {
	static final int N = 5;
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<N;i++){
			new GCTest();
		}
		System.gc();//向垃圾回收方法发出垃圾回收请求
		Thread.sleep(500);//暂停0.5s
		System.out.println("The program is over!");
	}

	//finalize方法，在对象被垃圾回收方法回收之前执行
	@Override
	public void finalize(){
		System.out.println("Garbage Collection!");
	}
}