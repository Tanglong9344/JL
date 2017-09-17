package java_applet;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class FlyBall extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	Thread artist = null;
	int bubble = 0, thisbubble = 0; // ������������ǰ������
	int MAXBUBBLES = 25; // �����������
	int stepper = 4; // Counter for which bubbles to move when
	int record[][] = new int[MAXBUBBLES][5]; // ��¼����Ķ�ά����
	@Override
	// ��ʼ��applet
	public void init() {
		resize(400, 400);
	}

	/**
	 * ��������
	 * @param x
	 * @param y
	 * @param r
	 * @param col
	 * @param g
	 */
	public void draw_bubble(int x, int y, int r, Color col, Graphics g) {
		// �������
		int i;
		// ���һ��Բ��
		for (i = x - r; i <= x + r; i++) {
			g.setColor(col);
			g.drawLine(i, y - (int) (Math.sqrt(r * r - ((i - x) * (i - x)))),
					i, y + (int) (Math.sqrt(r * r - ((i - x) * (i - x)))));
		}
	}

	/**
	 * �ƶ�����
	 * @param x
	 * @param y
	 * @param r
	 * @param col
	 * @param step
	 * @param g
	 */
	public void move_bubble(int x, int y, int r, Color col, int step, Graphics g) {
		// �ƶ�����
		int i;
		// ���������ϰ벿��
		for (i = x - r; i <= x + r; i++) {
			g.setColor(col);
			g.drawLine(i, y - (int) (Math.sqrt(r * r - ((i - x) * (i - x)))),
					i, y + step
					- (int) (Math.sqrt(r * r - ((i - x) * (i - x)))));
		}
		// ���������°벿��
		for (i = x - r; i <= x + r; i++) {
			g.setColor(Color.white);
			g.drawLine(i, y + (int) (Math.sqrt(r * r - ((i - x) * (i - x)))),
					i, y + step
					+ (int) (Math.sqrt(r * r - ((i - x) * (i - x)))));
		}
	}
	@Override
	public void paint(Graphics g) {
		int i, j, tmp;
		if (bubble < MAXBUBBLES || thisbubble < MAXBUBBLES) {
			record[thisbubble][0] = (int) (Math.random() * 300);
			record[thisbubble][1] = 320;
			record[thisbubble][2] = (int) (Math.random() * 400) / 20;
			record[thisbubble][3] = (int) (Math.random() * 255);
			record[thisbubble][4] = (int) (Math.random() * 255);
			// �������
			draw_bubble(record[thisbubble][0], record[thisbubble][1],
					record[thisbubble][2], new java.awt.Color(
							record[thisbubble][3], record[thisbubble][4], 255),g);
			// ��������С�����ֵ����������������1����ǰ����������1
			if (bubble < MAXBUBBLES) {
				bubble++;
				thisbubble++;
			} else {
				// �������������ֵ
				thisbubble = MAXBUBBLES;
			}
		}
		for (i = 0; i < bubble; i++) {
			if (i % 5 <= stepper) {
				record[i][1] -= 1;
				// �ƶ�����
				move_bubble(record[i][0], record[i][1], record[i][2],
						new java.awt.Color(record[i][3], record[i][4], 255), 1,
						g);
				for (j = 0; j < i; j++) {
					tmp = ((record[i][1] - record[j][1])
							* (record[i][1] - record[j][1]) + (record[i][0] - record[j][0])
							* (record[i][0] - record[j][0]));
					if (j != i && Math.sqrt(tmp) < record[i][2] + record[j][2]) {
						for (tmp = record[i][2]; tmp >= -1; tmp = tmp - 2) {
							draw_bubble(record[i][0], record[i][1],
									record[i][2] - tmp, Color.white, g);
						}
						draw_bubble(record[j][0], record[j][1], record[j][2],
								new java.awt.Color(record[j][3], record[j][4],
										255), g);
						record[i][1] = -1;
						record[i][2] = 0;
					}
				}
			}
			if (record[i][1] + record[i][2] < 0 && bubble >= MAXBUBBLES) {
				thisbubble = i;
			}
			stepper = (int) (Math.random() * 10);
		}
	}
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	@Override
	public void start() {
		// ����applet,�����������߳�
		if (artist == null) {
			artist = new Thread(this);
			artist.start();
		}
	}
	@Override
	public void stop() {
		// ����applet
		artist = null;
	}
	@Override
	public void run() {
		// �����߳�
		while (artist != null) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
			repaint();
		}
		artist = null;
	}
}