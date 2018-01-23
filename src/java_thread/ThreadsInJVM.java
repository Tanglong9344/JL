package java_thread;

/**
 * �����鿴JVM������������̺߳��߳������
 *
 * @author ����
 */
public class ThreadsInJVM {
	private static int cnt=0;
	//This is a test
	public static void main(String[] args) {
		System.out.println("JVM��ǰ�����̵߳Ļ״����");
		ThreadsInJVM.threadsList();
	}

	//�ҵ����߳��鲢�г����Լ������ӽڵ����Ϣ
	public static void threadsList() {
		// ��õ�ǰ����߳���
		ThreadGroup root = Thread.currentThread().getThreadGroup().getParent();//��ø��߳�
		//��ȡ�߳�����ڵ�
		while (root.getParent() != null) {
			root=root.getParent();
		}
		threadGroupMessage(root,++cnt);//��ʾ���߳���
	}

	// ��ʾ�߳�����Ϣ
	private static void threadGroupMessage(ThreadGroup group,int cnt) {
		if (group == null){
			return;
		}
		// ��û���߳�����
		int countActive = group.activeGroupCount();
		ThreadGroup[] groups = new ThreadGroup[countActive];
		group.enumerate(groups, false);
		//��ʾ��ǰ�㼶
		showLevel(cnt-1);
		System.out.println("ThreadGroupName:" + group.getName()
		+ ",MaxPriority:" + group.getMaxPriority()
		+ (group.isDaemon() ? ",Daemon" : ",NonDaemon"));
		// ��û���߳���
		int count = group.activeCount();
		Thread[] threads = new Thread[count];
		//�����л��������ø��Ƶ�ָ�������У�false��ʾ����������������л���������
		group.enumerate(threads, false);
		//ѭ����ʾ��ǰ����߳���Ϣ
		for (int i = 0; i < count; i++) {
			threadMessage(threads[i],cnt);
		}
		//ѭ����ʾ��ǰ������߳�����Ϣ
		for (int i = 0; i < countActive; i++){
			// ѭ����ʾ��ǰ����߳�����Ϣ
			threadGroupMessage(groups[i],++cnt);
		}
	}

	// ��ʾ�߳���Ϣ
	private static void threadMessage(Thread thread,int cnt) {
		if (thread == null) {
			return;
		}
		//��ʾ��ǰ�㼶
		showLevel(cnt);
		System.out.println("ThreadName:" + thread.getName()
		+",Priority:" + thread.getPriority()
		+ (thread.isDaemon() ? ",Daemon" : ",NonDaemon")
		+ (thread.isAlive() ? ",Alive" : ",NonActive"));
	}

	/**��ʾ�̲߳㼶*/
	private static void showLevel(int cnt){
		for(int i=0;i<cnt;i++){
			System.out.print("-");
		}
	}
}