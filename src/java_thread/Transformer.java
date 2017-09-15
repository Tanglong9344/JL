package java_thread;

public class Transformer {
	public static void main(String[] args) {
		Defensor defensor = new Defensor();
		defensor.start();
		try {
			Thread.sleep(500);//休眠5s
		} catch (InterruptedException e) {
			System.out.println("唤醒异常:" + e.getMessage());
		}
	}
}

/**
 * 操作守护神线程的类
 * @author 唐龙
 */
class Defensor extends Thread {
	@Override
	public void run() {
		System.out.print("当霸天虎在袭击地球的危难关头，守护神是否采取自我保护? ");
		System.out.println(this.isDaemon() ? "是" : "没有");// 测试该线程是否为守护线程。
		System.out.println("守护神Defensor是机器卫兵的组合战士，个性善良，愿意牺牲自己去保护人类");
		Human people = new Human();
		people.setDaemon(true); // 设置守护线程，在本程序中将其子类people设置为守护线程也就是被保护的对象
		people.start();// 启动守护线程
		try {
			Thread.sleep(1000); // 休眠1秒
		} catch (InterruptedException e) { // 捕获唤醒异常
			System.out.println("唤醒异常:" + e.getMessage());
		} finally {
			System.out.println("在面对危险的时候，守候神舍身捍卫地球，保护人类的安全");
		}
		System.out.println("守候神太伟大了...");
	}
}

/**
 * 人类进程
 * @author 唐龙
 */
class Human extends Thread {
	static final int NUM = 5;
	@Override
	public void run() {
		System.out.print("人类的安全是否被保护？");
		System.out.println(this.isDaemon() ? "是" : "没有");// 判断此线程是否是守护线程
		System.out.printf("现在有%d处场所的人们正处于危险之中！！！%n",NUM);
		int i = 0;
		try {
			while (i < NUM) {
				System.out.println("第" + (1 + i++) + "处场所的人类");
				Thread.sleep(200); // 休眠0.2秒
			}
		} catch (InterruptedException e) {
			System.out.println("唤醒异常:" + e.getMessage());
		} finally {
			System.out.println("守候神尽心尽力，帮助人类安全的躲过霸天虎的疯狂袭击");
		}
		System.out.println("终于脱离危险了～～～");
	}
}