package java_thread;

public class ThreadInteractionTest {
	public static void main(String[] args) {

		final Hero4 gareen = new Hero4();
		gareen.name = "����";
		gareen.hp = 10;
		//�߳�1��Ѫ
		Thread t1 = new Thread(){
			@Override
			public void run(){
				while(true){
					//��Ϊ��Ѫ���죬���Ը��׵�Ѫ������ᵽ��1
					//ʹ��whileѭ���ж��Ƿ���1�������1�Ͳ�ͣ��ѭ��
					//ֱ����Ѫ�̻߳ظ���Ѫ��
					while(1 == gareen.hp){
						continue;
					}
					gareen.hurt();
					System.out.printf("t1 Ϊ%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n",gareen.name,gareen.name,gareen.hp);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
		//�߳�2��Ѫ
		Thread t2 = new Thread(){
			@Override
			public void run(){
				while(true){
					gareen.recover();
					System.out.printf("t2 Ϊ%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n",gareen.name,gareen.name,gareen.hp);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t2.start();

	}
}