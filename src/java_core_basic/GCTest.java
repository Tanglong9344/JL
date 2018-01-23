package java_core_basic;

/**
 * Java �������ջ���
 * @author ����
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

		System.gc();//���������շ�������������������
		Thread.sleep(1000);//��ͣ1s
		System.out.println("The program is over!");
	}

	//finalize�������ڶ����������շ�������֮ǰִ��
	@Override
	public void finalize(){
		System.out.println("Garbage Collection!");
	}
}