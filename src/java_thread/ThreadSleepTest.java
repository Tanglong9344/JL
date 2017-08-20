package java_thread;

public class ThreadSleepTest {
	public static void main(String[] args) {
		Thread t1= new Thread(){
			@Override
			public void run(){
				int seconds =0;
				boolean run = true;
				while(run){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.printf("�Ѿ������� %d ��%n", seconds++);
					//�������һ�������˳�
					if(seconds>60){
						System.out.printf("�Ѿ������� %d ����,�ټ�!%n", seconds/60);
						run = false;
					}
				}
			}
		};
		t1.start();
	}
}
