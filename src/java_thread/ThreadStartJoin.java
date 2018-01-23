package java_thread;

/**
 * Thread join
 *
 * @author ����
 *
 */
public class ThreadStartJoin {
	public static void main(String[] args) throws InterruptedException {
		final int MARRY_NUMBER = 100;//ƥ�����
		for(int i=1;i<=MARRY_NUMBER;i++){
			MatchMarry group = new MatchMarry("Boy-"+i, "Girl-"+i);
			group.start();//�����߳�
			group.join();//�ȴ����߳����н���
		}
		System.out.println("�������...");
	}
}

/** ����ƥ������� */
class MatchMarry extends Thread {
	private String name;//��Ա����
	private String otherName;//������
	private boolean isMarry = false;//�Ƿ���
	public MatchMarry(String name, String otherName) {
		this.name = name;
		this.otherName = otherName;
	}
	@Override
	public void run() {
		try {
			int person = (int) Math.floor((Math.random() * 10 + 1));// ��������
			if (person % 2 == 0) {
				isMarry = true;//���ñ�ʶ
			} else {
				isMarry = false;
			}
			if (!isMarry) {
				System.out.println(name + " ������ " + otherName + " ��飬ף������");
			} else {
				System.out.println(otherName + " �ѻ顣");
			}
			Thread.sleep(10);//�߳�����10ms
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}