package java_applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

public class WordsToLarge extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	private Image myImage;// ����ͼƬ����
	private Graphics myGraphic;// ����Graphics����
	private Font font;// ����Font����
	private String myString;// ����һ���ַ�������
	private Thread mythread;// ����һ��Thread����
	private int fontSize;// ����һ��int�ͱ���

	@Override
	// AppletС�����ʼ��
	public void init() {
		this.setSize(400, 400);
		myImage = createImage(400, 400); // /����Imageͼ�����
		myGraphic = myImage.getGraphics();
		myString = "Applet JavaС����";// ��Ҫ�仯���ı�����
		font = new Font("TimesRoman", Font.BOLD, 8);
	}

	@Override
	// �������߳�
	public void start() {
		if (mythread == null) {
			mythread = new Thread(this);
			mythread.start();// �����߳�
		}
	}

	@Override
	// ���µ���paint����
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	// ��ͼ��
	public void paint(Graphics g) {
		myGraphic.setColor(Color.black);
		myGraphic.fillRect(0, 0, getSize().width, getSize().height);
		font = new Font("TimesRoman", Font.BOLD, fontSize);
		myGraphic.setFont(font);
		myGraphic.setColor(Color.white);
		FontMetrics fm = myGraphic.getFontMetrics(font);
		int fontHeight = fm.getHeight();
		int w;
		int baseLine = getSize().height / 2 + fontHeight / 2;
		w = fm.stringWidth(myString);
		w = (getSize().width - w) / 2;
		myGraphic.drawString(myString, w, baseLine -= 20);
		g.drawImage(myImage, 0, 0, this);
		fontSize++;
	}

	@Override
	// ��дThread���run����
	public void run() {
		while (true) {
			repaint();
			if (fontSize > getSize().height) {
				fontSize = 0;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}