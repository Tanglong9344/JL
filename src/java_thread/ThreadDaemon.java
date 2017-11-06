package java_thread;

/**
 * �ػ��̵߳ĸ����ǣ� ��һ����������е��̶߳����ػ��̵߳�ʱ�򣬽�����ǰ���̡�
 * �ͺ���һ����˾�����۲�����������Щ��ҵ��ҹ��Ĳ��š�
 * ����֮�⣬���к��ڣ���������Щ֧�ֲ��š�
 * ���һ�ҹ�˾���۲�������������ɢ�ˣ���ôֻʣ�º��ں���������ô��ҹ�˾Ҳ���Խ�ɢ�ˡ�
 * �ػ��߳̾��൱����Щ֧�ֲ��ţ����һ������ֻʣ���ػ��̣߳���ô���̾ͻ��Զ�������
 * �ػ��߳�ͨ���ᱻ��������־������ͳ�Ƶȹ�����
 */

public class ThreadDaemon {
	public static void main(String[] args) throws InterruptedException {
		ThreadNew t1= new ThreadNew();
		//���õ�ǰ�߳�Ϊ�ػ��̣߳����̻߳�����������ȫ������֮���Զ�����
		t1.setDaemon(true);
		t1.setName("Thread-1");
		t1.start();

		ThreadNew t2= new ThreadNew();
		t2.setName("Thread-2");
		t2.start();

		ThreadNew t3= new ThreadNew();
		t3.setName("Thread-3");
		t3.start();
	}
}

/**�߳���*/
class ThreadNew extends Thread{
	@Override
	public void run(){
		int cnt =0;
		boolean run = true;
		while(run){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf(this.getName()+"�Ѿ�������  %d ��%n", cnt++);
			if(cnt>5 && this.getName().equals("Thread-2")){
				run = false;
			}
			if(cnt>10 && this.getName().equals("Thread-3")){
				run = false;
			}
		}
	}
}