package java_thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskTest {
	public static void main(String[] args) {
		Timer timer = new Timer();
		//��0sʱ�̿�ʼÿ���1sִ��һ��
		timer.schedule(new ScheduleTask("�ظ�����"),0,1*1000);
		//��5sʱ��ִ��
		timer.schedule(new ScheduleTask("��ʱ����"),5000);
	}
}

/**
 * ��ִ�е�����
 *
 * �̳�TimerTask
 *
 * @author ����
 *
 */
class ScheduleTask extends TimerTask{
	private String msg;
	public ScheduleTask(String msg){
		this.msg=msg;
	}

	@Override
	public void run() {
		System.out.println("ִ��-"+msg);
	}
}