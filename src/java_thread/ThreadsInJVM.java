package java_thread;

/**
 * 操作查看JVM虚拟机中所的线程和线程组的类
 *
 * @author 唐龙
 */
public class ThreadsInJVM {
	private static int cnt=0;
	//This is a test
	public static void main(String[] args) {
		System.out.println("JVM当前所有线程的活动状况：");
		ThreadsInJVM.threadsList();
	}

	//找到根线程组并列出它以及所有子节点的信息
	public static void threadsList() {
		// 获得当前活动的线程组
		ThreadGroup root = Thread.currentThread().getThreadGroup().getParent();//获得根线程
		//获取线程组根节点
		while (root.getParent() != null) {
			root=root.getParent();
		}
		threadGroupMessage(root,++cnt);//显示根线程组
	}

	// 显示线程组信息
	private static void threadGroupMessage(ThreadGroup group,int cnt) {
		if (group == null){
			return;
		}
		// 获得活动的线程组数
		int countActive = group.activeGroupCount();
		ThreadGroup[] groups = new ThreadGroup[countActive];
		group.enumerate(groups, false);
		//显示当前层级
		showLevel(cnt-1);
		System.out.println("ThreadGroupName:" + group.getName()
		+ ",MaxPriority:" + group.getMaxPriority()
		+ (group.isDaemon() ? ",Daemon" : ",NonDaemon"));
		// 获得活动的线程数
		int count = group.activeCount();
		Thread[] threads = new Thread[count];
		//把所有活动子组的引用复制到指定数组中，false表示不包括对子组的所有活动子组的引用
		group.enumerate(threads, false);
		//循环显示当前活动的线程信息
		for (int i = 0; i < count; i++) {
			threadMessage(threads[i],cnt);
		}
		//循环显示当前活动的子线程组信息
		for (int i = 0; i < countActive; i++){
			// 循环显示当前活动的线程组信息
			threadGroupMessage(groups[i],++cnt);
		}
	}

	// 显示线程信息
	private static void threadMessage(Thread thread,int cnt) {
		if (thread == null) {
			return;
		}
		//显示当前层级
		showLevel(cnt);
		System.out.println("ThreadName:" + thread.getName()
		+",Priority:" + thread.getPriority()
		+ (thread.isDaemon() ? ",Daemon" : ",NonDaemon")
		+ (thread.isAlive() ? ",Alive" : ",NonActive"));
	}

	/**显示线程层级*/
	private static void showLevel(int cnt){
		for(int i=0;i<cnt;i++){
			System.out.print("-");
		}
	}
}