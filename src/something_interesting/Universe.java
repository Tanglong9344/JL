package something_interesting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Universe extends java.applet.Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	static final int THE_SPEED_INIT = 125;//�ٶ�Ĭ��ֵ
	static final int THE_STARTS_INIT = 6250;//��������Ĭ��ֵ
	static final int DEPTH = 250;//�������
	static final int POSITION_X = 0;//�����ʼλ��x����
	static final int POSITION_Y = 0;//�����ʼλ��y����
	int Width, Height;// ����С����ĳ��Ϳ�
	Thread thread = null;// ����һ���̶߳���
	boolean suspend = false;// �Ƿ���ͣ
	Image im;// ����һ��ͼ�����
	Graphics graphics;// ����һ��Graphics����
	double rot, dx, ddx;// ����double�ͱ���
	int speed, stars, type;// ����int�ͱ���
	double defddx, max;// ����double�ͱ���
	Star pol[]; // �ǹ�
	// ��ʼ��AppletС����
	@Override
	public void init() {
		rot = 0;
		dx = 0;
		ddx = 0;
		Toolkit kit = Toolkit.getDefaultToolkit(); //���幤�߰�
		Dimension screenSize = kit.getScreenSize(); //��ȡ��Ļ�ĳߴ�
		Width = (int) screenSize.getWidth();//��ȡ��Ļ���
		Height = (int) screenSize.getHeight();//��ȡ��Ļ�߶�
		//Width = this.getWidth();//��ȡ��ǰ���ڵĿ��
		//Height = this.getHeight();//��ȡ��ǰ���ڵĸ߶�
		String theSpeed = "";
		Show("speed", theSpeed);
		speed = (null == theSpeed || "".equals(theSpeed) ) ? THE_SPEED_INIT : Integer.valueOf(theSpeed).intValue();
		String theStars = "";
		Show("stars", theStars);
		stars = (null == theStars || "".equals(theStars)) ? THE_STARTS_INIT : Integer.valueOf(theStars).intValue();
		try {
			im = createImage(Width, Height);
			graphics = im.getGraphics();
		} catch (Exception e) {
			graphics = null;
		}
		pol = new Star[stars];
		for (int i = 0; i < stars; i++) {
			pol[i] = new Star(Width, Height,DEPTH, type);
		}
		System.out.println(Width + "," + Height);
	}
	@Override
	// �������
	public void paint(Graphics g) {
		if (null != graphics) {
			paintStart(graphics);
			g.drawImage(im, POSITION_X, POSITION_Y, this);
		} else {
			paintStart(g);
		}
	}
	public void paintStart(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, Width, Height);
		for (int i = 0; i < stars; i++) {
			pol[i].DrawSelf(g, rot);
		}
	}
	@Override
	// ����AppletС����
	public void start() {
		if (null == thread) {
			thread = new Thread(this);
			thread.start();// �����߳�
		}
	}
	@SuppressWarnings("deprecation")
	@Override
	// ֹͣ����AppletС����
	public void stop() {
		if (thread != null) {
			thread.stop();
			thread = null;
		}
	}
	@Override
	// �����߳�
	public void run() {
		while (null != thread) {
			rot += dx;
			dx += ddx;
			if (dx > max) {
				ddx = -defddx;
			}
			if (dx < -max) {
				ddx = defddx;
			}
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
			}
			repaint();
		}
	}
	@Override
	// ���»����鲮
	public void update(Graphics g) {
		paint(g);
	}
	//���ն���ʾ��Ӧ
	public void Show(String theString, String theValue) {
		if (null == theValue) {
			System.out.println(theString + " : null");
		} else {
			System.out.println(theString + " : " + theValue);
		}
	}
}

/**
 * ������
 * @author tanglong
 */
class Star {
	int H, V;
	int x, y, z;
	int type;
	// ���캯��Ϊ��������ʼ��
	Star(int width, int height, int depth, int type) {
		this.type = type;
		H = width / 2;
		V = height / 2;
		x = (int) (Math.random() * width) - H;
		y = (int) (Math.random() * height) - V;
		if ((0 == x) && (0 == y)) {
			x = 10;
		}
		z = (int) (Math.random() * depth);
	}

	/**
	 * ���������������
	 * @param g
	 * @param rot
	 */
	public void DrawSelf(Graphics g, double rot) {
		double X, Y;
		int h, v, hh, vv;
		int d;
		z -= 2;
		if (z < -63) {
			z = 100;
		}
		hh = (x * 64) / (64 + z);
		vv = (y * 64) / (64 + z);
		X = (hh * Math.cos(rot)) - (vv * Math.sin(rot));
		Y = (hh * Math.sin(rot)) + (vv * Math.cos(rot));
		h = (int) X + H;
		v = (int) Y + V;
		if ((h < 0) || (h > (2 * H))) {
			z = 100;
		}
		if ((v < 0) || (v > (2 * H))) {
			z = 100;
		}
		setColor(g);
		if (type == 0) {
			d = (100 - z) / 50;
			if (d == 0) {
				d = 1;
			}
			g.fillRect(h, v, d, d);
		} else {
			d = (100 - z) / 20;
			g.drawLine(h - d, v, h + d, v);
			g.drawLine(h, v - d, h, v + d);
			if (z < 50) {
				d /= 2;
				g.drawLine(h - d, v - d, h + d, v + d);
				g.drawLine(h + d, v - d, h - d, v + d);
			}
		}
	}

	/**
	 * �����ƵĶ���������ɫ
	 * @param g
	 */
	public void setColor(Graphics g) {
		if (z > 55) {
			g.setColor(Color.GREEN);
		} else if (z > 30) {
			g.setColor(Color.BLUE);
		} else {
			g.setColor(Color.YELLOW);
		}
	}
}