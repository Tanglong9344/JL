package java_thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * �����߳��ò�����
 * @author ����
 */
public class ThreadYield {
	//This is a test
	public static void main(String []args){
		Vector<String> vector=new Vector<>();
		new Yield(vector).start();
		new SendFile(vector).start();
	}
}

/**
 * �߳��ò���
 * @author ����
 */
class Yield extends Thread {
	private Vector<String> vector;
	private DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss:SSSS");//���ڸ�ʽ
	private boolean isFlag = false;
	public Yield(Vector<String> vector) {
		super("�����ļ�");//�����߳�����
		this.setDaemon(true);//���SendFile�߳̽���������߳��Զ�����
		this.vector=vector;
	}
	@Override
	public void run() {
		while (!isFlag) {
			try {
				Thread.sleep(100);//����0.1s
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			//�ж��������ϴ�С
			if (vector.size()<=0) {
				System.out.println(dateFormat.format(new Date())+ "\t������û���ļ���ִ��yield������");
				Thread.yield();//�����߳��ò�
			} else {
				String ss = vector.remove(0);
				System.out.println(dateFormat.format(new Date())+"\tȡ���ļ���" + ss);
			}
		}
	}
}

/**
 * �����ļ�
 * @author ����
 */
class SendFile extends Thread {
	private String[] files = new String[] {"�����ļ�", "����������", "ɽˮ��������", "�����¸�˵��"};
	private Vector<String> vector;
	public SendFile(Vector<String> vector) {
		super("�����ļ�");
		this.vector=vector;
	}
	@Override
	public void run() {
		try {
			for (int i=0;i < files.length;i++){
				Thread.sleep(200);//�߳�����0.2s
				vector.add(files[i]);//����ļ�
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}