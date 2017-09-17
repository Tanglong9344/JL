package java_applet;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class LightScan extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	private String myText;// �����ı�����
	private Font font;// �����������
	private int fontSize;// ��������Ĵ�С
	private Thread mythread;// �����̶߳���
	private int spotPosition = 100;// ����������ֵ�λ��
	private int myTextSize = 20;// �ı��Ĵ�С
	private int myTextWidth = 0;// �ı��Ŀ��
	private int fontHeight, baseLine, w;
	@Override
	// С�̳�ĳ�ʼ��
	public void init()
	{
		myText = "AppletС����";// ��С��������Ҫ��ʾ���ı�����
		fontSize = 30;// ��������Ĵ�С
		font = new Font("TimesRoman", Font.BOLD, fontSize); // ����Font����
		FontMetrics fm = getFontMetrics(font);// ��ȡFontMetrics���������
		fontHeight = fm.getHeight();
		baseLine = getSize().height / 2 + fontHeight / 3;
		myTextWidth = fm.stringWidth(myText);
		w = fm.stringWidth(myText);
		w = (getSize().width - w) / 2;
		spotPosition = w;
		setBackground(Color.black); // ����С����ı���ɫΪ��ɫ
	}
	@Override
	public void start() {
		if (mythread == null) {
			mythread = new Thread(this);// �������߳�
			mythread.start();// �������߳�
		}
	}
	@SuppressWarnings("deprecation")
	@Override
	// ֹͣ�����߳�
	public void stop() {
		mythread.stop();
		mythread = null;
	}
	@Override
	// �����߳�
	public void run()
	{
		while (true) {
			repaint();// �ػ�����
			try {
				Thread.sleep(30);
			}// �߳�����
			catch (InterruptedException e) {
			}
		}
	}
	@Override
	// �������
	public void update(Graphics g)
	{
		paint(g);
	}
	// ����clipRect()������ÿ�ε�����ʾ����paint()ʱ��
	// ���ú�ɫ�ıʻ�һ�����֣����ð�ɫ�ڲü����л�һ������
	@Override
	public void paint(Graphics g) {
		g.setFont(font);
		g.setColor(Color.red);
		g.drawString(myText, w, baseLine); // ��һ����ʾ
		g.clipRect(spotPosition, 0, myTextSize, getSize().height); // ���òü�����
		g.setColor(Color.white);
		g.drawString(myText, w, baseLine); // �ڶ�����ʾ
		spotPosition = (spotPosition + 1) % (myTextWidth + 100); // �ƶ����λ��
	}
}