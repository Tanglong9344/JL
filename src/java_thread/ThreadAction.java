package java_thread;

/**
 * �����鿴JVM������������̺߳��߳������
 * @author ����
 */
public class ThreadAction {
	// ��ʾ�߳���Ϣ
	private static void threadMessage(Thread thread, String index) {
		if (thread == null) {
			return;
		}
		System.out.println(index + "ThreadName:" + thread.getName()
		+ "\n Priority:" + thread.getPriority()
		+ (thread.isDaemon() ? "\n Daemon" : "")
		+ (thread.isAlive() ? "" : "\n Inactive"));
	}
	// ��ʾ�߳�����Ϣ
	private static void threadGroupMessage(ThreadGroup group, String index) {
		if (group == null){
			return;
		}
		// ��û���߳���
		int count = group.activeCount();
		// ��û���߳�����
		int countGroup = group.activeGroupCount();
		// ���ݻ���߳�������ָ���������߳�����
		Thread[] threads = new Thread[count];
		// ���ݻ���߳���������ָ���������߳�������
		ThreadGroup[] groups = new ThreadGroup[countGroup];
		group.enumerate(threads, false); // �����л��������ø��Ƶ�ָ�������У�false��ʾ����������������л���������
		group.enumerate(groups, false);
		System.out.println(index + "ThreadGroupName:" + group.getName()
		+ "\nMaxPriority:" + group.getMaxPriority()
		+ (group.isDaemon() ? "\nDaemon" : ""));
		// ѭ����ʾ��ǰ����߳���Ϣ
		for (int i = 0; i < count; i++) {
			threadMessage(threads[i], index + " ");
		}
		for (int i = 0; i < countGroup; i++){
			// ѭ����ʾ��ǰ����߳�����Ϣ
			threadGroupMessage(groups[i], index + "    ");// �ݹ���÷���
		}
	}

	//�ҵ����߳��鲢�г����ݹ����Ϣ
	public static void threadsList() {
		ThreadGroup currentThreadGroup; // ��ǰ�߳���
		ThreadGroup rootThreadGroup; // ���߳���
		ThreadGroup parent;
		// ��õ�ǰ����߳���
		currentThreadGroup = Thread.currentThread().getThreadGroup();
		rootThreadGroup = currentThreadGroup; // ��ø��߳���
		parent = rootThreadGroup.getParent(); // ��ø��߳�
		//ѭ���Ը��߳������¸�ֵ
		while (parent != null) {
			rootThreadGroup = parent;
			parent = parent.getParent();
		}
		threadGroupMessage(rootThreadGroup, ""); // ��ʾ���߳���
	}
	public static void main(String[] args) { // java��������ڴ�
		System.out.println("�鿴JVM�����е��̵߳Ļ״�����£�");
		ThreadAction.threadsList(); // ���÷�����ʾ�����̵߳���Ϣ
	}
}