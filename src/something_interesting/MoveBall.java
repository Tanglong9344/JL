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
	// ����3����Ť������ֱ����ʼ��ֹͣ���˳�
	private Button quit = new Button("�˳�");
	private Button start = new Button("��ʼ");
	private Button stop = new Button("ֹͣ");
	private DrawBall balls[] = new DrawBall[20];
	// ���췽�����Ը�������г�ʼ��
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
	// ΪButton����¼�����
	public void actionPerformed(ActionEvent e) {
		// ����ֹͣ��Ť
		if (e.getSource() == stop) {
			for (int i = 0; i < balls.length; i++) {
				balls[i].setRun();
			}
		}
		// ������ʼ��Ť
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
	// �������
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
 * �滭����
 * @author tanglong
 */
class DrawBall extends Thread {
	// �����������ȡ�������ӵ�λ��
	private int a = 2 * (1 - 2 * (int) Math.round(Math.random()));
	private int b = 2 * (1 - 2 * (int) Math.round(Math.random()));
	private boolean running = false;// �����Ƿ�������ӵı�־
	private MoveBall table = null;// ����һ��MoveBall����
	protected int x, y;// ����XY�����
	public DrawBall(MoveBall table, int x, int y) {
		this.table = table;
		this.x = x;
		this.y = y;
		start();
	}
	@Override
	public void start() {
		running = true;
		super.start();// �����߳�
	}
	public void setRun() {
		running = false;
	}
	@Override
	// ��дThread���run����
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
	// �Զ���������ӵķ���
	public void paintBall(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(x, y, 20, 20);
	}
	// �����ڹ���
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