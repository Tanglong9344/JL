/**
 * Java GC机制
 */

package java_core_basic;

public class GCTest {
	private String str = "Garbage Collection.";
	public static void main(String[] args) throws InterruptedException {
		GCTest gc = new GCTest();
		System.out.println("调用System.gc()之前："+gc.str);
		System.gc();//发起回收请求
		//Thread.sleep(1000);//暂停1s
		System.out.println("调用System.gc()之后："+gc.str);
		try {
			gc.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("调用finalize()之后："+gc.str);
	}
}