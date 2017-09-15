package java_thread;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DeadLock extends Frame {
	private static final long serialVersionUID = 1L;
	// 创建一个字符串数组，用于存放线程的名字
	protected static final String[] names = { "One", "Two" };
	private int accounts[] = { 1000, 1000 };// 存入账号
	// 创建TextArea组件
	private TextArea info = new TextArea(5, 40);
	private TextArea status = new TextArea(5, 40);
	@SuppressWarnings("deprecation")
	public DeadLock() {
		super("致命的死锁！");// 调用父类Frame的带参构造方法
		this.setLayout(new GridLayout(2, 1));
		add(makePanel(info, "账号"));
		add(makePanel(status, "线程"));
		validate();
		pack();
		show();
		new DeadLockThread(0, this, status);
		new DeadLockThread(1, this, status);
		// 添加单击事件监听
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * 同步转帐
	 * @param from
	 * @param into
	 * @param amount
	 */
	public synchronized void transfer(int from, int into, int amount) {
		info.append("\n帐户 One:$" + accounts[0]);// 将给定文本追加到文本区的当前文本
		info.append("\n帐户 Two:$" + accounts[1]);
		info.append("\n>=$" + amount + "从" + names[from] + "到" + names[into]);
		while (accounts[from] < amount) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			accounts[from] = amount;
			accounts[into] = amount;
			notify();
		}
	}

	// 创建面板，按选择的布局方式将组件进行布局
	private Panel makePanel(TextArea ta, String title) {
		Panel p = new Panel();
		p.setLayout(new BorderLayout());
		p.add("North", new Label(title));
		p.add("Center", ta);
		return p;
	}

	public static void main(String[] args) {
		new DeadLock();
	}
}

/**
 * 死锁线程
 * @author tanglong
 */
class DeadLockThread extends Thread {
	private DeadLock dl;
	private int id;
	private TextArea display;
	public DeadLockThread(int id, DeadLock dl, TextArea display) {
		this.dl = dl;
		this.id = id;
		this.display = display;
		start();
	}
	@Override
	public void run() {
		while (true) {
			int amount = (int) (1500 * Math.random());
			display.append("\nThread" + DeadLock.names[id] + "将 $" + amount + "存入" + DeadLock.names[(1 - id)]);
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			dl.transfer(id, 1 - id, amount);
		}
	}
}