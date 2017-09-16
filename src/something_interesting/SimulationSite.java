package something_interesting;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SimulationSite extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	//ģ���ֳ�����
	//����ȫ�ֳ�Ա����
	protected static final int num_agents=10;
	protected static final int num_initial_agents=6;
	protected static final int max_Customer2_delay=9000;
	protected static final int max_teller_break=1000;
	protected static final int max_no_Customer2s=2000;
	//����Button���
	private Button open = new Button("����");
	private Button close = new Button("����");
	private Button add = new Button("��ӭ����");
	private Button del = new Button("������");
	private Bank2 Bank2 = new Bank2();
	private Finance supermarket = new Finance("");
	//��Ӵ��ڹر��¼�
	private class WindowCloser extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e){
			Bank2.stop();
			supermarket.stop();
			System.exit(0);
		}
	}
	//���췽�������������ʼ���Ͳ���
	@SuppressWarnings("deprecation")
	public SimulationSite(){
		super("SimulationSite");
		Panel buttons = new Panel();
		buttons.setLayout(new FlowLayout());
		buttons.add(open);
		open.addActionListener(this);
		buttons.add(close);
		close.addActionListener(this);
		buttons.add(add);
		add.addActionListener(this);
		buttons.add(del);
		del.addActionListener(this);
		this.addWindowListener(new WindowCloser());
		this.setLayout(new BorderLayout());
		add("West",Bank2);
		add("East",supermarket);
		add("South",buttons);
		validate();
		pack();
		show();
		Bank2.start();
		supermarket.start();
	}
	@Override
	//Ϊ������Ť���¼�����
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==open){
			Bank2.openDoor();
			supermarket.openDoor();
		}else if(e.getSource()==close){
			Bank2.closeDoor();
			supermarket.closeDoor();
		}else if(e.getSource()==add){
			Bank2.addAgent();
			supermarket.addAgent();
		}else if(e.getSource()==del){
			Bank2.retireAgent();
			supermarket.retireAgent();
		}
	}
	public static void main(String[] args){
		@SuppressWarnings("unused")
		SimulationSite sl = new SimulationSite();
	}
}
class Finance extends Panel implements Runnable {
	private static final long serialVersionUID = 1L;
	protected Penson[] person = new Penson[SimulationSite.num_agents];
	protected Label[] labelAgent = new Label[SimulationSite.num_agents];
	protected Label labelQueue = new Label("�ѷ���Ĺ˿���:0");
	protected Label labelServed = new Label("Customer2s servers:0");
	protected Label labelWait = new Label("Customer2s wait:0");
	protected int numAgents = SimulationSite.num_initial_agents;
	protected int numCustomer2 = 0;// �˿���
	protected long totalWait = 0L;// �ȴ��˿���
	private Thread thread = null;
	private boolean doorIsOpen = false;
	public Finance(String title) {
		super();
		setup(title);
	}
	public  void updateDisplay() {
	}
	public  void generateCustomer2() {
	}
	public  Customer2 requestCustomer2For(int id) {
		return null;
	}
	// ���¹˿͵������������ڵȴ���������
	public void checkoutCustomer2(int handled, long waitTime) {
		numCustomer2++;
		totalWait += waitTime;
	}
	// ������Ա
	public void addAgent() {
		if (numAgents < SimulationSite.num_agents) {
			person[numAgents] = new Penson(this, numAgents);
			person[numAgents].start();
			numAgents++;
		}
	}
	// ������Ա
	public void retireAgent() {
		if (numAgents > 1) {
			person[numAgents - 1].setRunING();
			numAgents--;
		}
	}
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			doorIsOpen = true;
			thread.start();// ������ǰ�߳�
			for (int i = 0; i < numAgents; i++) {
				person[i].start();// ����Person���е��߳�
			}
		}
	}
	public void stop() {
		doorIsOpen = false;
		thread = null;
		for (int i = 0; i < numAgents; i++) {
			person[i].setRunING();
		}
	}
	// Ӫҵ
	public void openDoor() {
		doorIsOpen = true;
	}
	// ����
	public void closeDoor() {
		doorIsOpen = false;
	}
	@Override
	// ��дRunnable��run����
	public void run() {
		while (thread == Thread.currentThread()) {
			try {
				Thread.sleep((int) Math.random() * SimulationSite.max_no_Customer2s);
				if (doorIsOpen) {
					generateCustomer2();
					updateDisplay();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	// ����״̬
	private void setup(String title) {
		Panel agentPanel = new Panel();
		agentPanel.setLayout(new GridLayout(SimulationSite.num_agents + 3, 1));
		for (int i = 0; i < SimulationSite.num_agents; i++) {
			labelAgent[i] = new Label("Penson" + i + ":served 0");
			agentPanel.add(labelAgent[i]);
			person[i] = new Penson(this, i);
		}
		for (int i = numAgents; i < SimulationSite.num_agents; i++) {
			labelAgent[i].setText("Penson" + i + ":inactive");
		}
		agentPanel.add(labelQueue);
		agentPanel.add(labelServed);
		agentPanel.add(labelWait);
		setLayout(new BorderLayout());
		add("Center", agentPanel);
		add("North", new Label(title));
	}
}

/**
 * ����һ��Thread�������Penson��
 */
class Penson extends Thread {
	private boolean running = false;// �Ƿ�ֹͣ���еı�־
	private Finance bn = null;
	private int id = -1;// �ͻ�id
	private int numCustomer2s = 0;// �˿�����
	public Penson(Finance _bn, int _id) {
		this.bn = _bn;
		this.id = _id;
	}
	@Override
	public void start() {
		running = true;
		super.start();// �����߳�
	}
	public void setRunING() {// ����ִ��״̬
		running = false;
	}
	public int getNum() {// ��ȡ�˿�����
		return numCustomer2s;
	}
	private void releaseCustomer2(Customer2 Customer2) {// �ͷŹ˿Ͷ���
		numCustomer2s++;
		bn.checkoutCustomer2(numCustomer2s, Customer2.getWaitTime(new Date()));
	}
	@Override
	// ��дThread��run����
	public void run() {
		while (running) {
			try {
				sleep((int) (Math.random() * SimulationSite.max_teller_break) + 1000);// ��������
				Customer2 Customer2 = bn.requestCustomer2For(id);
				if (Customer2 != null) {
					sleep(Customer2.getDelayTime());
					releaseCustomer2(Customer2);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class Bank2 extends Finance implements Runnable {
	private static final long serialVersionUID = 1L;
	private ObjectQueue queue = null;
	public Bank2() {
		super("�й�����");// ���ø���Ĵ��ι��췽��
		queue = new ObjectQueue();// ����ObjectQueue����
	}
	@Override
	// ������ʾ
	public void updateDisplay() {
		labelServed.setText("�ѷ���Ĺ˿���:" + numCustomer2);// ���ñ�ǩ����ʾ����
		if (numCustomer2 != 0) {
			labelWait.setText("ƽ���ȴ�:" + (totalWait / numCustomer2));
			for (int i = 0; i < numAgents; i++) {
				labelAgent[i].setText("�˿�:" + i + ": �ѷ���" + person[i].getNum());
			}
			for (int i = numAgents; i < SimulationSite.num_agents; i++) {
				labelAgent[i].setText("�˿�:" + i + ": δ����");
				labelQueue.setText("���ڵȴ��Ĺ˿���:" + queue.getSize());
			}
		}
	}
	@Override
	// �����µĹ˿ͣ���ʾ�����µĹ˿͹���
	public void generateCustomer2() {
		queue.insert(new Customer2());
	}
	@Override
	// ��ʾ�й˿ͷ�������з��������
	public Customer2 requestCustomer2For(int id) {
		return queue.requestCustomer2();
	}
}

/**
 * �̶߳���
 * @author tanglong
 */
class ObjectQueue {
	private List<Object> Customer2s = new ArrayList<Object>();
	private synchronized Object performAction(String cmd, Object obj) {
		// ���ӷ����Ĳ�������
		if (cmd.equals("insert")) {
			if (Customer2s.isEmpty()) {
				Customer2s.add(obj);
			}
			notify();
			return null;
		}
		// ��ȡ����
		else if (cmd.equals("size")) {
			return new Integer(Customer2s.size());
		} else if (cmd.equals("retrieve")) {
			while (Customer2s.size() == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Customer2 c = (Customer2) Customer2s.get(0);
			Customer2s.remove(0);
			return c;
		}
		return null;
	}
	// ���Ӳ���
	public void insert(Customer2 c) {
		performAction("insert", c);
	}
	public int getSize() {
		return (((Integer) performAction("size", null)).intValue());
	}
	// �������
	public Customer2 requestCustomer2() {
		return (Customer2) performAction("retrieve", null);
	}
}

/**
 * �˿���
 * @author tanglong
 *
 */
class Customer2 {
	private Date date;
	public Customer2() {
		date = new Date();
	}
	// ��ȡ��ʱ��ʱ��
	public int getDelayTime() {
		return (int) (Math.random() * SimulationSite.max_Customer2_delay);
	}
	// ��ȡ�ȴ���ʱ��
	public long getWaitTime(Date now) {
		return now.getTime() - date.getTime();
	}
}