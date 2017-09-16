package something_interesting;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveBall extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	// 创建3个按扭组件，分别代表开始、停止和退出
	private Button quit = new Button("退出");
	private Button start = new Button("开始");
	private Button stop = new Button("停止");
	private DrawBall balls[] = new DrawBall[20];
	// 构造方法，对各组件进行初始化
	public MoveBall() {
		super();
		setLayout(new FlowLayout());
		add(quit);
		quit.addActionListener(this);
		add(start);
		start.addActionListener(this);
		add(stop);
		stop.addActionListener(this);
		validate();
		this.setBackground(Color.black);
		this.setSize(300, 300);
		this.setVisible(true);
		for (int i = 0; i < balls.length; i++) {
			int x = (int) (getSize().width * Math.random());
			int y = (int) (getSize().height * Math.random());
			balls[i] = new DrawBall(this, x, y);
		}
	}
	@Override
	// 为Button添加事件处理
	public void actionPerformed(ActionEvent e) {
		// 单击停止按扭
		if (e.getSource() == stop) {
			for (int i = 0; i < balls.length; i++) {
				balls[i].setRun();
			}
		}
		// 单击开始按扭
		if (e.getSource() == start) {
			for (int i = 0; i < balls.length; i++) {
				balls[i].setRun();
				balls[i] = new DrawBall(this, balls[i].x, balls[i].y);
			}
		}
		if (e.getSource() == quit) {
			System.exit(0);
		}
	}
	@Override
	// 绘制组件
	public void paint(Graphics g) {
		for (int i = 0; i < balls.length; i++) {
			if (balls[i] != null) {
				balls[i].paintBall(g);
			}
		}
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MoveBall t = new MoveBall();
	}
}

/**
 * 绘画珠子
 * @author tanglong
 */
class DrawBall extends Thread {
	// 利用随机数获取绘制珠子的位置
	private int a = 2 * (1 - 2 * (int) Math.round(Math.random()));
	private int b = 2 * (1 - 2 * (int) Math.round(Math.random()));
	private boolean running = false;// 控制是否绘制珠子的标志
	private MoveBall table = null;// 声明一个MoveBall对象
	protected int x, y;// 定义XY坐标点
	public DrawBall(MoveBall table, int x, int y) {
		this.table = table;
		this.x = x;
		this.y = y;
		start();
	}
	@Override
	public void start() {
		running = true;
		super.start();// 启动线程
	}
	public void setRun() {
		running = false;
	}
	@Override
	// 重写Thread类的run方法
	public void run() {
		while (running) {
			move();
			try {
				sleep(50);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			table.repaint();
		}
	}
	// 自定义绘制珠子的方法
	public void paintBall(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x, y, 20, 20);
	}
	// 珠子在滚动
	private void move() {
		x += a;
		y += b;
		if ((x > table.getSize().width) || (x < 0)) {
			a *= (-1);
		}
		if ((y > table.getSize().height) || (y < 0)) {
			b *= (-1);
		}
	}
}