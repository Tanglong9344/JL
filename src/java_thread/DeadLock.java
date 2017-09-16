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
	// ����һ���ַ������飬���ڴ���̵߳�����
	protected static final String[] names = { "One", "Two" };
	private int accounts[] = { 1000, 1000 };// �����˺�
	// ����TextArea���
	private TextArea info = new TextArea(5, 40);
	private TextArea status = new TextArea(5, 40);
	@SuppressWarnings("deprecation")
	public DeadLock() {
		super("������������");// ���ø���Frame�Ĵ��ι��췽��
		this.setLayout(new GridLayout(2, 1));
		add(makePanel(info, "�˺�"));
		add(makePanel(status, "�߳�"));
		validate();
		pack();
		show();
		new DeadLockThread(0, this, status);
		new DeadLockThread(1, this, status);
		// ��ӵ����¼�����
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * ͬ��ת��
	 * @param from
	 * @param into
	 * @param amount
	 */
	public synchronized void transfer(int from, int into, int amount) {
		info.append("\n�ʻ� One:$" + accounts[0]);// �������ı�׷�ӵ��ı����ĵ�ǰ�ı�
		info.append("\n�ʻ� Two:$" + accounts[1]);
		info.append("\n>=$" + amount + "��" + names[from] + "��" + names[into]);
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

	// ������壬��ѡ��Ĳ��ַ�ʽ��������в���
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
 * �����߳�
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
			display.append("\nThread" + DeadLock.names[id] + "�� $" + amount + "����" + DeadLock.names[(1 - id)]);
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			dl.transfer(id, 1 - id, amount);
		}
	}
}