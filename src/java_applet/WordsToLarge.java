package java_applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

public class WordsToLarge extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	private Image myImage;// 定义图片对象
	private Graphics myGraphic;// 定义Graphics对象
	private Font font;// 定义Font对象
	private String myString;// 定义一个字符串对象
	private Thread mythread;// 定义一个Thread对象
	private int fontSize;// 定义一个int型变量

	@Override
	// Applet小程序初始化
	public void init() {
		this.setSize(400, 400);
		myImage = createImage(400, 400); // /创建Image图像对像
		myGraphic = myImage.getGraphics();
		myString = "Applet Java小程序";// 需要变化的文本内容
		font = new Font("TimesRoman", Font.BOLD, 8);
	}

	@Override
	// 启动多线程
	public void start() {
		if (mythread == null) {
			mythread = new Thread(this);
			mythread.start();// 启动线程
		}
	}

	@Override
	// 重新调用paint方法
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	// 绘图像
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
	// 重写Thread类的run方法
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