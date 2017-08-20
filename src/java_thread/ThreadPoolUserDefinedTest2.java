package java_thread;

public class ThreadPoolUserDefinedTest2 {
	public static void main(String[] args) {
		ThreadPoolUserDefined pool= new ThreadPoolUserDefined();
		int sleep=1000;
		while(true){
			pool.add(new Runnable(){
				@Override
				public void run() {
					System.out.println("	---ִ������---");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			//���������ٶ��������������ٶ�Խ��Խ��
			try {
				Thread.sleep(sleep);
				sleep = sleep>100?sleep-100:sleep;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
