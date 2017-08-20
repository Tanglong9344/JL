package java_thread;

public class ThreadPoolUserDefinedTest2 {
	public static void main(String[] args) {
		ThreadPoolUserDefined pool= new ThreadPoolUserDefined();
		int sleep=1000;
		while(true){
			pool.add(new Runnable(){
				@Override
				public void run() {
					System.out.println("	---执行任务---");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			//添加任务的速度相比消费任务的速度越来越快
			try {
				Thread.sleep(sleep);
				sleep = sleep>100?sleep-100:sleep;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
