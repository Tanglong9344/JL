package something_interesting;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerThread {
	public static void main(String[] args) {
		Timer timer = new Timer(); // ������ʱ����
		TimerTask t1 = new MyTask(1);
		timer.schedule(t1, 200); // 0.2���ִ������
		TimerTask t2 = new MyTask(2);
		timer.schedule(t2, 500, 1000); // 0.5���ִ������ÿ��1��ִ��һ��
		TimerTask t3 = new MyTask(3);
		Date date = new Date(System.currentTimeMillis() + 1000);
		timer.schedule(t3, date); // ��ָ��ʱ��1���ִ������
		try {
			Thread.sleep(3000); // ����3����
		} catch (InterruptedException e) { // ���������쳣
			System.out.println("���ִ���" + e.getMessage());
		}
		timer.cancel(); // ��ֹ��ʱ��ȡ����ʱ���е�����
		System.out.println("����ʱ���Ѿ���ȡ��");
	}
}

/**�̳�ʱ��������ִ������*/
class MyTask extends TimerTask {
	private int taskID = 0; // ������
	public MyTask(int id) {
		this.taskID = id;
	}
	@Override
	@SuppressWarnings("deprecation")
	public void run() {
		System.out.println("��ʼִ���ҵĵ�" + this.taskID + "������ ��ִ��ʱ��Ϊ" + new Date().toLocaleString());
	}
}