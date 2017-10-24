/**
 * Java GC����
 */

package java_core_basic;

public class GCTest {
	private String str = "Garbage Collection.";
	public static void main(String[] args) throws InterruptedException {
		GCTest gc = new GCTest();
		System.out.println("����System.gc()֮ǰ��"+gc.str);
		System.gc();//�����������
		//Thread.sleep(1000);//��ͣ1s
		System.out.println("����System.gc()֮��"+gc.str);
		try {
			gc.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("����finalize()֮��"+gc.str);
	}
}