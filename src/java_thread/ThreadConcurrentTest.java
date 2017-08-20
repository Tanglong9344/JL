package java_thread;

public class ThreadConcurrentTest {
	public static void main(String[] args) {
		final Hero3 gareen = new Hero3();
		gareen.name = "����";
		gareen.hp = 10000;
		System.out.printf("���׵ĳ�ʼѪ���� %.0f%n", gareen.hp);
		//���߳�ͬ������ָ���Ƕ���߳�ͬʱ�޸�һ�����ݵ�ʱ�򣬵��µ�����
		//���������10000��Ѫ�������ڻ����ͬʱ�ֱ��Է����Ӣ�۹���
		//��JAVA��������ʾ�������ж���߳��ڼ��ٸ��׵�hp
		//ͬʱ���ж���߳��ڻظ����׵�hp

		//n���߳����Ӹ��׵�hp
		final int N = 10000;
		Thread[] addThreads = new Thread[N];
		for (int i = 0; i < N; i++) {
			Thread t = new Thread(){
				@Override
				public void run(){
					//ͬ����
					synchronized(gareen){
						gareen.recover();
					}

					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			t.start();
			addThreads[i] = t;
		}

		//n���̼߳��ٸ��׵�hp
		Thread[] reduceThreads = new Thread[N];
		for (int i = 0; i < N; i++) {
			Thread t = new Thread(){
				@Override
				public void run(){
					//ͬ����
					synchronized(gareen){
						gareen.hurt();
					}
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			t.start();
			reduceThreads[i] = t;
		}

		//�ȴ����������߳̽���
		for (Thread t : addThreads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		//�ȴ����м����߳̽���
		for (Thread t : reduceThreads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//����ִ�е�����������Ӻͼ����̶߳�������
		//���Ӻͼ����̵߳�������һ���ģ�ÿ�ζ����ӣ�����1.
		//��ô�����̶߳������󣬸��׵�hpӦ�û��ǳ�ʼֵ
		//������ʵ�Ϲ۲쵽���ǣ�
		System.out.printf("%d�������̺߳�%d�������߳̽�����%n���׵�Ѫ������� %.0f%n", N,N,gareen.hp);
	}
}
