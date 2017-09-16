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
	//模拟现场场景
	//定义全局成员常量
	protected static final int num_agents=10;
	protected static final int num_initial_agents=6;
	protected static final int max_Customer2_delay=9000;
	protected static final int max_teller_break=1000;
	protected static final int max_no_Customer2s=2000;
	//创建Button组件
	private Button open = new Button("开门");
	private Button close = new Button("关门");
	private Button add = new Button("欢迎光临");
	private Button del = new Button("请慢走");
	private Bank2 Bank2 = new Bank2();
	private Finance supermarket = new Finance("");
	//添加窗口关闭事件
	private class WindowCloser extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e){
			Bank2.stop();
			supermarket.stop();
			System.exit(0);
		}
	}
	//构造方法，进行组件初始化和布局
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
	//为单击按扭做事件监听
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
	protected Label labelQueue = new Label("已服务的顾客数:0");
	protected Label labelServed = new Label("Customer2s servers:0");
	protected Label labelWait = new Label("Customer2s wait:0");
	protected int numAgents = SimulationSite.num_initial_agents;
	protected int numCustomer2 = 0;// 顾客数
	protected long totalWait = 0L;// 等待顾客数
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
	// 更新顾客的数量，和正在等待的总人数
	public void checkoutCustomer2(int handled, long waitTime) {
		numCustomer2++;
		totalWait += waitTime;
	}
	// 增加人员
	public void addAgent() {
		if (numAgents < SimulationSite.num_agents) {
			person[numAgents] = new Penson(this, numAgents);
			person[numAgents].start();
			numAgents++;
		}
	}
	// 减少人员
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
			thread.start();// 启动当前线程
			for (int i = 0; i < numAgents; i++) {
				person[i].start();// 启动Person类中的线程
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
	// 营业
	public void openDoor() {
		doorIsOpen = true;
	}
	// 打烊
	public void closeDoor() {
		doorIsOpen = false;
	}
	@Override
	// 重写Runnable的run方法
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
	// 设置状态
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
 * 创建一个Thread类的子类Penson类
 */
class Penson extends Thread {
	private boolean running = false;// 是否停止运行的标志
	private Finance bn = null;
	private int id = -1;// 客户id
	private int numCustomer2s = 0;// 顾客数量
	public Penson(Finance _bn, int _id) {
		this.bn = _bn;
		this.id = _id;
	}
	@Override
	public void start() {
		running = true;
		super.start();// 启动线程
	}
	public void setRunING() {// 设置执行状态
		running = false;
	}
	public int getNum() {// 获取顾客数量
		return numCustomer2s;
	}
	private void releaseCustomer2(Customer2 Customer2) {// 释放顾客对象
		numCustomer2s++;
		bn.checkoutCustomer2(numCustomer2s, Customer2.getWaitTime(new Date()));
	}
	@Override
	// 重写Thread的run方法
	public void run() {
		while (running) {
			try {
				sleep((int) (Math.random() * SimulationSite.max_teller_break) + 1000);// 随面休眠
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
		super("中国银行");// 调用父类的带参构造方法
		queue = new ObjectQueue();// 创建ObjectQueue对象
	}
	@Override
	// 更新显示
	public void updateDisplay() {
		labelServed.setText("已服务的顾客数:" + numCustomer2);// 设置标签的显示内容
		if (numCustomer2 != 0) {
			labelWait.setText("平均等待:" + (totalWait / numCustomer2));
			for (int i = 0; i < numAgents; i++) {
				labelAgent[i].setText("顾客:" + i + ": 已服务" + person[i].getNum());
			}
			for (int i = numAgents; i < SimulationSite.num_agents; i++) {
				labelAgent[i].setText("顾客:" + i + ": 未服务");
				labelQueue.setText("正在等待的顾客数:" + queue.getSize());
			}
		}
	}
	@Override
	// 增加新的顾客，表示又有新的顾客光临
	public void generateCustomer2() {
		queue.insert(new Customer2());
	}
	@Override
	// 表示有顾客发出想进行服务的需求
	public Customer2 requestCustomer2For(int id) {
		return queue.requestCustomer2();
	}
}

/**
 * 线程队列
 * @author tanglong
 */
class ObjectQueue {
	private List<Object> Customer2s = new ArrayList<Object>();
	private synchronized Object performAction(String cmd, Object obj) {
		// 增加方法的操作流程
		if (cmd.equals("insert")) {
			if (Customer2s.isEmpty()) {
				Customer2s.add(obj);
			}
			notify();
			return null;
		}
		// 获取容量
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
	// 增加操作
	public void insert(Customer2 c) {
		performAction("insert", c);
	}
	public int getSize() {
		return (((Integer) performAction("size", null)).intValue());
	}
	// 请求服务
	public Customer2 requestCustomer2() {
		return (Customer2) performAction("retrieve", null);
	}
}

/**
 * 顾客类
 * @author tanglong
 *
 */
class Customer2 {
	private Date date;
	public Customer2() {
		date = new Date();
	}
	// 获取超时的时间
	public int getDelayTime() {
		return (int) (Math.random() * SimulationSite.max_Customer2_delay);
	}
	// 获取等待的时间
	public long getWaitTime(Date now) {
		return now.getTime() - date.getTime();
	}
}