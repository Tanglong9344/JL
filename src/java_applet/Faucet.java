package java_applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 * ˮ������Ч��
 */
public class Faucet extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	private static final int MAX_DROP = 1500;// ˮ�ε�������
	Drop d[];// ����һ��ˮ�ζ���
	int width, height, X, Y;// ����AppletС����Ŀ��͸ߣ�����XY��������
	Image off;// ����һ��ͼƬ����
	Graphics graphics;// ����һ��Graphics����
	Thread thread;// ����һ���̶߳���

	@Override
	// AppletС�����ʼ��
	public void init() {
		this.setSize(500, 500);
		setBackground(Color.gray);
		width = getSize().width;
		height = getSize().height;
		d = new Drop[MAX_DROP];
		for (int i = 0; i < MAX_DROP; i++) {
			d[i] = new Drop();
		}
		off = createImage(width, height);
		graphics = off.getGraphics();
	}

	@Override
	// ��ʼִ��С����
	public void start() {
		thread = new Thread(this);
		thread.start();
	}

	@Override
	// ִֹͣ��С����
	public void stop() {
		thread = null;
	}

	@Override
	// ���»���С����
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	// �������
	public void paint(Graphics g) {
		g.drawImage(off, 0, 0, this);
	}

	@Override
	// �����߳�
	public void run() {
		int i;
		while (true) {
			graphics.clearRect(0, 0, width, height);
			graphics.setColor(Color.white);
			graphics.drawLine(0, 15, 10, 15);
			for (i = 0; i < MAX_DROP; i++) {
				graphics.fillOval((int) d[i].X, (int) d[i].Y, 3, 3);
				d[i].X = d[i].X + d[i].newX;
				if (d[i].X > 10) {
					d[i].Y += d[i].newY * d[i].time / 1000;
					d[i].newY = (int) 9.8 * d[i].time;
					d[i].time++;
				}
				if (d[i].Y > height) {
					d[i].reset();
				}
			}
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

/**
 * ˮ����
 */
class Drop {
	double X, Y;
	double newX, newY;
	int time;

	public Drop() {
		reset();
	}

	// �������û���ˮ�ε�λ�úʹ�С
	public void reset() {
		X = (int) (Math.random() * (-40));
		Y = (int) (Math.random() * 5 + 10);
		newX = Math.random() * 3 + 1.0;
		newY = 0;
		time = 0;
	}
}