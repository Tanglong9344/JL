package java_thread;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * �����߳��ò�����
 * @author ����
 */
public class TestThreadYield {
	private Vector<String> vector = new Vector<String>();// ������������
	// �������ڸ�ʽ
	private DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss:SSSS");
	private boolean isFlag = false;
	private class Yield extends Thread {
		public Yield() {
			this.setName("�����ļ�");//�����߳�����
			this.setDaemon(true);// ���SendFile�߳̽���������߳��Զ�����
		}
		@Override
		public void run() {
			// ��ʶΪ���˳�ѭ��
			while (!isFlag) {
				try {
					Thread.sleep(100);// ����
				}catch(InterruptedException e){
					System.out.println("�����쳣:"+e.getMessage());
				}
				//�ж��������ϴ�С
				if (0 == vector.size()) {
					System.out.println(dateFormat.format(new Date())+ "\t����������û���ļ���ִ��yield����");
					Thread.yield();//�����߳��ò�
				} else {//�ƶ��ļ���ö���
					String ss = vector.remove(0);
					System.out.println(dateFormat.format(new Date())+"\tȡ���ļ�����Ϊ" + ss);
				}
			}
		}
	}

	/**
	 * �����ļ����߳�
	 * @author ����
	 *
	 */
	private class SendFile extends Thread {
		private String[] files = new String[] { "�����ļ�", "����������", "ɽˮ��������", "�����¸�˵��" };
		public SendFile() {
			this.setName("�����ļ�");
		}
		@Override
		public void run() {
			try {
				//ѭ��ʹ�߳�����
				for (int i=0;i < files.length;i++){
					Thread.sleep(200);//�߳�����
					vector.add(files[i]);//����ļ�
				}
				Thread.sleep(100);//�߳�����
			} catch (InterruptedException e) {
				System.out.println("�����쳣:"+e.getMessage());
			}
		}
	}
	public static void main(String []args){
		TestThreadYield test=new TestThreadYield();
		test.new Yield().start();//ʵ�����������߳�
		test.new SendFile().start();
	}
}