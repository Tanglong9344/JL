package java_thread;

public class ThreadPoolSelfDefinedTest2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadPoolSelfDefined pool= new ThreadPoolSelfDefined();
		int sleepTime=1000;
		while(true){
			pool.add(new Runnable(){
				@Override
				public void run() {
					System.out.println("---ִ������---");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			//���������ٶ��������������ٶ�Խ��Խ��
			Thread.sleep(sleepTime);
			sleepTime = sleepTime>100?sleepTime-50:sleepTime;
		}
	}
}