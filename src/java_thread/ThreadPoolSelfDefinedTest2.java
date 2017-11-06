package java_thread;

public class ThreadPoolSelfDefinedTest2 {
	public static void main(String[] args) throws InterruptedException {
		ThreadPoolSelfDefined pool= new ThreadPoolSelfDefined();
		int sleepTime=1000;
		while(true){
			pool.add(new Runnable(){
				@Override
				public void run() {
					System.out.println("---执行任务---");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			//添加任务的速度相比消费任务的速度越来越快
			Thread.sleep(sleepTime);
			sleepTime = sleepTime>100?sleepTime-50:sleepTime;
		}
	}
}