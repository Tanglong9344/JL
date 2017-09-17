package java_applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.Random;

public class SnowFlake extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	static final int WIDTH =300;
	static final int HEIGHT =300;
	Thread thread;// �������߳�
	Image off, images[];// ����ͼƬ�����ͼƬ����
	Random random;// ����һ�����������
	int flag, sonwNum, wind, thread_1, size;// ����һЩint�ͱ���
	int[] X, Y;// ��������int�����飬�ֱ��ʾX��Y�����
	long time = 0;// ��ʾʱ��
	Dimension ds;// ����һ��Dimension����
	MediaTracker mt;// ����һ��MediaTracker����
	// ��ȡHTML���������������ֵ
	int getValue(String s1, int s2, int max, int min) {
		String s = getParameter(s1);
		if (s != null) {
			if ((s2 = Integer.parseInt(s)) > max) {
				return max;
			} else if (s2 < min) {
				return min;
			} else {
				return s2;
			}
		} else {
			return s2;
		}
	}
	@Override
	// AppletС�����ʼ��
	public void init() {
		this.setSize(WIDTH,HEIGHT);
		random = new Random();
		ds = getSize();
		off = createImage(ds.width, ds.height);// ����һ��ͼ��
		sonwNum = getValue("sonwNum", 100, 500, 0);// ��ȡѩƬ�ĸ���
		size = getValue("size", 3, 10, 3);// ��ȡѩƬ�Ĵ�С
		thread_1 = getValue("threadsleep", 80, 1000, 10);// ��ȡ���ߵ�ʱ��
		// ��ȡ����ѩƬ��XY����ֵ
		X = new int[sonwNum];
		Y = new int[sonwNum];
		for (int i = 0; i < sonwNum; i++) {
			X[i] = random.nextInt() % (ds.width / 2) + ds.width / 2;
			Y[i] = random.nextInt() % (ds.height / 2) + ds.height / 2;
		}
		mt = new MediaTracker(this);
		images = new Image[1];
		images[0] = getImage(getDocumentBase(), "xue.jpg");
		mt.addImage(images[0], 0);
		try {
			mt.waitForID(0);
		} catch (InterruptedException _ex) {
			return;
		}
		flag = 0;
	}
	@Override
	// ����С����
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();// �����߳�
		}
	}
	@Override
	// ֹͣ����С����
	public void stop() {
		thread = null;
	}
	@Override
	// �����߳�
	public void run() {
		while (thread != null) {
			try {
				Thread.sleep(thread_1);
			} catch (InterruptedException _ex) {
				return;
			}
			repaint();
		}
	}
	// ����ѩƬ
	public void snow(Graphics g) {
		g.setColor(Color.white);
		for (int i = 0; i < sonwNum; i++) {
			g.fillOval(X[i], Y[i], size, size);
			X[i] += random.nextInt() % 2 + wind;
			Y[i] += (random.nextInt() % 6 + 5) / 5 + 1;
			if (X[i] >= ds.width) {
				X[i] = 0;
			}
			if (X[i] < 0) {
				X[i] = ds.width - 1;
			}
			if (Y[i] >= ds.height || Y[i] < 0) {
				X[i] = Math.abs(random.nextInt() % ds.width);
				Y[i] = 0;
			}
		}
		wind = random.nextInt() % 5 - 2;
	}
	@Override
	// �������
	public void paint(Graphics g) {
		off.getGraphics().setColor(Color.black);
		off.getGraphics().fillRect(0, 0, ds.width, ds.height);
		off.getGraphics().drawImage(images[0], 0, 0, this);
		snow(off.getGraphics());
		g.drawImage(off, 0, 0, null);
	}
	@Override
	// ���»������
	public void update(Graphics g) {
		paint(g);
	}
}