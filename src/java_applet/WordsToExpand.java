package java_applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class WordsToExpand extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	private Image myImage;// 声明Image图象对象
	private Graphics myGraphic;// 声明Graphics对象
	private int width = 0, height = 0;// 声明高和宽变量
	private String words;// 定义文本内容
	private Thread mythread;// 声明Thread多线程对象
	@SuppressWarnings("unused")
	private int xPosition = 0, yPosition = 0, myHeight;// 定义x和y坐标点
	private int times = 0;// 表示线条出现的方向
	private Font font;

	// 初始化Applet小程序
	@Override
	public void init() {
		this.setSize(300, 200);
		font = new Font("TimesRoman", Font.BOLD, 30);
		width = 300;
		height = 200;
		myHeight = height / 3;
		yPosition = myHeight;
		words = "大家好";
		myImage = createImage(width, height);
		myGraphic = myImage.getGraphics();
	}

	@Override
	// 起动Applet小程序和多线程
	public void start(){
		if (mythread == null) {
			mythread = new Thread(this);
			mythread.start();
		}
	}

	@Override
	// 更新组件
	public void update(Graphics g){
		paint(g);
	}

	@Override
	// 绘制组件
	public void paint(Graphics g){
		g.drawImage(myImage, 0, yPosition, width, myHeight, this);
	}

	@Override
	// 运行多线程
	public void run(){
		try {
			while (true) {
				yPosition = 0;
				myHeight = height;
				myGraphic.setColor(Color.pink);
				myGraphic.fillRect(0, 0, width, height);
				repaint();
				Thread.sleep(100);
				if (times == 0) {
					myGraphic.setColor(Color.black);
					for (int i = width; i >= 0; i--) {
						myGraphic.fillRect(i, height / 3, width, height / 10);
						repaint();
						Thread.sleep(10);
					}
				} else if (times == 1) {
					myGraphic.setColor(Color.blue);
					for (int i = 0; i <= width; i++) {
						myGraphic.fillRect(0, height / 3, i, height / 10);
						repaint();
						Thread.sleep(10);
					}
				}
				yPosition = height / 3;
				myHeight = height / 3;
				for (int i = height / 3; i >= 0; i--) {
					xPosition = 0;
					yPosition--;
					myHeight = myHeight + 2;
					// 0表示从右向左移动
					if (times == 0){
						myGraphic.setColor(Color.black);
						myGraphic.fillRect(0, 0, width, height);
						myGraphic.setFont(font);
						myGraphic.setColor(Color.yellow);
						myGraphic.drawString(words, 10, 35);
						times++;
					}
					// 1表示从左向右移动
					else if (times == 1){
						myGraphic.setColor(Color.red);
						myGraphic.fillRect(0, 0, width, height);
						myGraphic.setFont(font);
						myGraphic.setColor(Color.black);
						myGraphic.drawString(words, 10, 35);
						times = 0;
					}
					repaint();
					Thread.sleep(100);
				}
				Thread.sleep(2500);
				System.out.println(times);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}