package something_interesting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ResourceFile {
	static boolean isStop = false;// ��ʶ�߳��Ƿ�ֹͣ
	static List<String> taskList = new ArrayList<String>();// ���������б����
	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// ����ģ��������Դ�������ļ���
	private class SearchDownload extends Thread {
		private String[] file = new String[] { "51Upload_Setup.exe","eclipse-SDK-3.2.1-win32.zip", "EditPlus.rar" };
		// ����ģ������ʱ����������Դ����
		private String[] resource = new String[] { "��ʼ����......",
				"��ʼ������ѡ��Դ......", "û��������ѡ��Դ���Ժ���������",
				"ԭʼ��Դ���ӳɹ����õ����ļ����ȣ� 7725816", "��ʼ�����ļ�......",
				"�ļ������ɹ�����ʼ��������......", "�û�ȡ������" };
		int sum = 0;//����һ������ʱ�õ���ʱ��
		int time = 0;//����һ����Դʱ�õ�ʱ��
		@Override
		// ʵ���߳���ķ���
		public void run() {
			for (int i = 0; i < file.length; i++) {
				System.out.println("��ʼ���ص�" + (i + 1) + "���ļ�");
				try {
					for (int j = 0; j < resource.length; j++) {
						System.out.println(dateFormat.format(new Date()) + " "+ resource[j]);
						time = new Random().nextInt(100);// ���������ɵ�����
						Thread.sleep(time);// �߳����ߵȴ�
						sum = sum + time;
					}
					System.out.println(dateFormat.format(new Date()) + " �����ļ�" + file[i] + "��ʱ" + sum + " ����. ");
					Thread.sleep(time);// �߳����ߵȴ�
				} catch (Exception e) {// �����쳣
					System.out.println("�����ļ�����" + e.getMessage());
				}
				synchronized (taskList) {// ʵ��ͬ��
					System.out.println(dateFormat.format(new Date()) + " " + file[i] + "�ļ���������ϣ�");
					taskList.add(file[i]);// ���ļ���ӵ������б���
					taskList.notify();// ͨ�����еȴ���fileList���߳�
				}
				sum = 0;
			}
			isStop = true;// �������ñ�ʶ
			System.out.println(dateFormat.format(new Date()) + " �����̡߳��˳�");
			//ʹ�ú���ʽ������ص��ļ�
			taskList.forEach(file->System.err.println("���ص��ļ���"+file));
		}
	}
	public static void main(String[] args) {
		ResourceFile test = new ResourceFile();
		// ʵ�����ڲ��ಢ�����߳�
		test.new SearchDownload().start();
	}
}