package something_interesting;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SavingOffice extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Label label = new Label("ת�������:0");
	// ����AWT�����ı����
	private TextArea area = new TextArea();
	// ����AWT��Ť���
	private Button display = new Button("��ʾ�ʻ�");
	private Button start = new Button("��������");
	private Button stop = new Button("ֹͣ");
	// �����˺ŵĸ���
	protected final static int NUM_ACCOUNTS = 8;
	// �����˷ѵ�ʱ��
	private final static int WASTE_TIME = 1;
	// ����һ��int�����飬���ڴ����˺ŵĳ�ʼ���
	private int accounts[] = new int[NUM_ACCOUNTS];
	// ����һ��Customer���飬���ڴ��Customerʵ��������
	private Customer customer[] = new Customer[NUM_ACCOUNTS];
	// ת�˵Ľ��
	private int count = 0;
	// ���췽����Ϊ��AWT��Ա�������г�ʼ��
	public SavingOffice() {
		super("�ҵ�����С���");
		Panel btn_Panel = new Panel();
		btn_Panel.setLayout(new FlowLayout());
		btn_Panel.add(display);
		display.addActionListener(this);
		btn_Panel.add(start);
		start.addActionListener(this);
		btn_Panel.add(stop);
		stop.addActionListener(this);
		setLayout(new BorderLayout());
		add("North", label);
		add("South", btn_Panel);
		add("Center", area);
		for (int i = 0; i < accounts.length; i++){
			accounts[i] = 50000;// ÿ���˻��ϵĳ�ʼ���Ϊ5��Ԫ
		}
		start();// ����ͨ�ķ����������̵߳�start����
		validate();
		setSize(300, 300);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	// ����ת��
	public void transfer(int from, int into, int amount) {
		if ((accounts[from] >= amount) && (from != into)) {
			int newAmountFrom = accounts[from] - amount;
			int newAmountTo = accounts[into] + amount;
			wastrSomeTime();
			accounts[from] = newAmountFrom;
			accounts[into] = newAmountTo;
		}
		label.setText("ת����ɣ�" + count++);
	}

	// ��������
	public void start() {
		stop();
		for (int i = 0; i < accounts.length; i++) {
			customer[i] = new Customer(i, this);
		}
	}

	// ֹͣ
	private void stop() {
		for (int i = 0; i < accounts.length; i++) {
			if (customer[i] != null) {
				customer[i].setFlagValue();
			}
		}
	}

	// ���ڵȴ�������
	private void wastrSomeTime() {
		try {
			Thread.sleep(WASTE_TIME);
		} catch (InterruptedException ie) {
			System.out.println(ie);
		}
	}

	// ��ʾ���
	private void showAccounts() {
		int sum = 0;
		for (int i = 0; i < accounts.length; i++) {
			sum += accounts[i];
			area.append("\n�ʻ� " + i + "��$" + accounts[i]);
		}
		area.append("\n�ܽ�$" + sum);
		area.append("\nת���ܴ�����" + count + "\n");
	}

	@Override
	// Ϊbutton�������¼�����
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == display) {
			showAccounts();
		} else if (ae.getSource() == start) {
			start();
		} else if (ae.getSource() == stop) {
			stop();
		}
	}

	public static void main(String args[]) {
		@SuppressWarnings("unused")
		SavingOffice bank = new SavingOffice();
	}
}

/**
 * �˿���
 * @author li.jie
 */
class Customer extends Thread {
	private SavingOffice bank = null;

	private int id = -1;

	private boolean flag = false;

	public Customer(int _id, SavingOffice _bank) {
		bank = _bank;
		id = _id;
		start();
	}
	@Override
	public void start() {
		flag = true;
		super.start();// �����߳�
	}

	// ����Ϊ��ת��״̬
	public void setFlagValue() {
		flag = false;
	}
	@Override
	public void run() {
		while (flag) {
			int into = (int) (SavingOffice.NUM_ACCOUNTS * Math.random());
			int amount = (int) (1000 * Math.random());
			bank.transfer(id, into, amount);
			yield();
		}
	}
}