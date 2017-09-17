package java_applet;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

public class RainbowWords extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	String str = null;
	Thread thread = null; // ����һ���߳�
	char[] ch;
	int p = 0;
	Image image;
	Graphics gphics;
	Color[] color;
	int one = 1;
	int two = 18;
	int three = 18;
	private Font f; // ����
	private FontMetrics fm;// ��ģ
	@Override
	public void init() {
		str = "Java AppletС���� "; // �����߲���������
		this.setSize(520, 200); // ����Applet�Ĵ�С
		setBackground(Color.white); // ���ñ�����ɫ
		ch = new char[str.length()];
		ch = str.toCharArray(); // ���ַ����еĸ����ַ����浽������
		image = createImage(getSize().width, getSize().height);
		gphics = image.getGraphics();
		f = new Font("", Font.BOLD, 18);
		fm = getFontMetrics(f); // ���ָ�������������
		gphics.setFont(f); // �������������
		float hue;
		color = new Color[str.length()]; // ��ɫ��ɫԪ
		for (int i = 0; i < str.length(); i++) {
			hue = ((float) i) / ((float) str.length());
			color[i] = new Color(Color.HSBtoRGB(hue, 0.8f, 1.0f)); // ��ɫ����
		}
	}
	@Override
	public void start() { // �߳̿�ʼ����
		if (thread == null) { // ����߳�Ϊ�գ���
			thread = new Thread(this);
			// ��ʼ�µ��߳�
			thread.start(); // ��ʼ
		}
	}
	// ��ֹ�߳�
	@Override
	@SuppressWarnings("deprecation")
	public void stop() {
		if (thread != null) { // ����̲߳�Ϊ�գ���
			thread.stop(); // ��ֹ�̣߳�ʹ��
			thread = null; // Ϊ��
		}
	}
	// �����߳�
	@Override
	public void run() {
		while (thread != null) {
			try {
				Thread.sleep(200); // ���̳߳�˯200����
			} catch (InterruptedException e) {
			}
			repaint(); // ���»��ƽ���
		}
	}
	@Override
	public void update(Graphics g) { // ��дupdate�����������˸����
		int x, y;
		double a;
		gphics.setColor(Color.black);
		gphics.fillRect(0, 0, getSize().width, getSize().height);
		p += one;
		p %= 7; // ��Ҫ�����ֵ��ٶȣ�������ԽС���ٶ�Խ��
		// System.out.println(p+�� p1��);
		for (int i = 0; i < str.length(); i++) {
			a = ((p - i * one) % 7) / 4.0 * Math.PI; // ��Ҫ���ƻ��ȵģ�������ԽС������Խ��
			x = 30 + fm.getMaxAdvance() * i + (int) (Math.cos(a) * two); // ��x����ֵ
			y = 80 + (int) (Math.sin(a) * three); // ��y����ֵ
			gphics.setColor(color[(p + i) % str.length()]);
			gphics.drawChars(ch, i, 1, x, y);
		}
		paint(g);
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}
}