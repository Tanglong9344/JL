/**
 * Java �������ջ���
 */

package java_core_basic;

public class GCTest {
	static final int N = 5;
	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<N;i++){
			new GCTest();
		}
		System.gc();//���������շ�������������������
		Thread.sleep(500);//��ͣ0.5s
		System.out.println("The program is over!");
	}

	//finalize�������ڶ����������շ�������֮ǰִ��
	@Override
	public void finalize(){
		System.out.println("Garbage Collection!");
	}
}