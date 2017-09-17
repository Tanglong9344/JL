package java_applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;
import java.util.Random;

public class MissileDemo extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	public int speed, variability, Max_Number, Max_Energy, Max_Patch,
	Max_Length, G;
	public String sound;
	private int width, height;// ��ȡ��ǰ�����߽�Ŀ�͸�
	private Thread thread = null;// �����߳�
	private BeaClassDemo bcd[];// ����BeaClassDemo������bcd
	@Override
	// Applet��ʼ��
	public void init() {
		int i;
		this.setSize(400, 400); // ���õ�ǰ�����Ŀ�͸�
		width = getSize().width - 1;
		height = getSize().height - 1;
		speed = 30;// �̻����ŵ��ٶ�
		variability = 10;
		Max_Number = 100;// �ɷ����̻��������Ŀ
		Max_Energy = width + 50;
		Max_Patch = 80;// ���İߵ���
		Max_Length = 200;// �ߵ��������
		G = 50;// ���������������
		bcd = new BeaClassDemo[Max_Number];// ��ʼ��BeaClassDemo����
		for (i = 0; i < Max_Number; i++){
			bcd[i] = new BeaClassDemo(width, height, G);// ����BeaClassDemo�����
		}
	}
	@Override
	// �����߳�
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}
	@SuppressWarnings("deprecation")
	@Override
	// ֹͣ�߳�
	public void stop() {
		if (thread != null) {
			thread.stop();
			thread = null;
		}
	}
	@Override
	public void run() {
		int i;
		int E = (int) (Math.random() * Max_Energy * 3 / 4) + Max_Energy / 4 + 1;
		int P = (int) (Math.random() * Max_Patch * 3 / 4)// �̻��İߵ���
				+ Max_Patch / 4 + 1;
		int L = (int) (Math.random() * Max_Length * 3 / 4)// �̻��ɷ�����ľ���
				+ Max_Length / 4 + 1;
		long S = (long) (Math.random() * 10000);// �����������
		boolean sleep;// ���ߵı�־
		Graphics g = getGraphics();
		@SuppressWarnings("unused")
		URL u = null;
		while (true) {
			try {
				Thread.sleep(1000 / speed);
			} catch (InterruptedException x) {
			}
			sleep = true;
			for (i = 0; i < Max_Number; i++) {
				sleep = sleep && bcd[i].sleep;
			}
			if (sleep && Math.random() * 100 < variability) {
				E = (int) (Math.random() * Max_Energy * 3 / 4) + Max_Energy / 4
						+ 1;
				P = (int) (Math.random() * Max_Patch * 3 / 4) + Max_Patch / 4
						+ 1;
				L = (int) (Math.random() * Max_Length * 3 / 4) + Max_Length / 4
						+ 1;
				S = (long) (Math.random() * 10000);
			}
			for (i = 0; i < Max_Number; i++) {
				if (bcd[i].sleep && Math.random() * Max_Number * L < 1) {
					bcd[i].init(E, P, L, S);
					bcd[i].start();
				}
				bcd[i].show(g);
			}
		}
	}
	@Override
	public void paint(Graphics g) {// �������
		g.setColor(Color.black);// ���ñ�����ɫΪ��
		g.fillRect(0, 0, width + 1, height + 1);// ���ݲ���������
	}
}
class BeaClassDemo {
	public boolean sleep = true;
	private int energy, patch, length, width, height, G, Xx, Xy, Ex[], Ey[], x,
	y, Red, Blue, Green, t;
	private Random random;// ����Random�����
	public BeaClassDemo(int a, int b, int g) {// ��BeaClassDemo�Ĺ��췽��
		width = a;
		height = b;
		G = g;
	}
	public void init(int e, int p, int l, long seed) {// ��ʼ��
		int i;
		// ��ֵ����
		energy = e;
		patch = p;
		length = l;
		// ����һ�������ӵ������������
		random = new Random(seed);
		Ex = new int[patch];// ��ʼ��int����Ex���䳤��Ϊpatch
		Ey = new int[patch];// ��ʼ��int����Ey���䳤��Ϊpatch
		// ������ɲ�͸����sRGB��ɫֵ
		Red = (int) (random.nextDouble() * 128) + 128;
		Blue = (int) (random.nextDouble() * 128) + 128;
		Green = (int) (random.nextDouble() * 128) + 128;
		Xx = (int) (Math.random() * width / 2) + width / 4;
		Xy = (int) (Math.random() * height / 2) + height / 4;
		for (i = 0; i < patch; i++) {
			Ex[i] = (int) (Math.random() * energy) - energy / 2;
			Ey[i] = (int) (Math.random() * energy * 7 / 8) - energy / 8;
		}
	}
	public void start() {
		t = 0;
		sleep = false;
	}
	// ����̻�
	public void show(Graphics g) {
		if (!sleep) {
			if (t < length) {
				int i, c;
				double s;
				Color color;
				c = (int) (random.nextDouble() * 64) - 32 + Red;
				if (c >= 0 && c < 256) {
					Red = c;
				}
				c = (int) (random.nextDouble() * 64) - 32 + Blue;
				if (c >= 0 && c < 256) {
					Blue = c;
				}
				c = (int) (random.nextDouble() * 64) - 32 + Green;
				if (c >= 0 && c < 256) {
					Green = c;
				}
				color = new Color(Red, Blue, Green);
				for (i = 0; i < patch; i++) {
					s = (double) t / 100;
					x = (int) (Ex[i] * s);
					y = (int) (Ey[i] * s - G * s * s);
					g.setColor(color);
					g.drawLine(Xx + x, Xy - y, Xx + x, Xy - y);
					if (t >= length / 2) {
						int j;
						for (j = 0; j < 2; j++) {
							s = (double) ((t - length / 2) * 2 + j) / 100;
							x = (int) (Ex[i] * s);
							y = (int) (Ey[i] * s - G * s * s);
							g.setColor(Color.black);
							g.drawLine(Xx + x, Xy - y, Xx + x, Xy - y);
						}
					}
				}
				t++;
			} else {
				sleep = true;
			}
		}
	}
}