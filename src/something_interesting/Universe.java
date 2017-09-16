package something_interesting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Universe extends java.applet.Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	static final int THE_SPEED_INIT = 125;//速度默认值
	static final int THE_STARTS_INIT = 6250;//星星数量默认值
	static final int DEPTH = 250;//星星深度
	static final int POSITION_X = 0;//画面初始位置x坐标
	static final int POSITION_Y = 0;//画面初始位置y坐标
	int Width, Height;// 定义小程序的长和宽
	Thread thread = null;// 声明一个线程对象
	boolean suspend = false;// 是否暂停
	Image im;// 声明一个图象对象
	Graphics graphics;// 声明一个Graphics对象
	double rot, dx, ddx;// 声明double型变量
	int speed, stars, type;// 声明int型变量
	double defddx, max;// 声明double型变量
	Star pol[]; // 星光
	// 初始化Applet小程序
	@Override
	public void init() {
		rot = 0;
		dx = 0;
		ddx = 0;
		Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
		Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
		Width = (int) screenSize.getWidth();//获取屏幕宽度
		Height = (int) screenSize.getHeight();//获取屏幕高度
		//Width = this.getWidth();//获取当前窗口的宽度
		//Height = this.getHeight();//获取当前窗口的高度
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
	// 绘制组件
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
	// 启动Applet小程序
	public void start() {
		if (null == thread) {
			thread = new Thread(this);
			thread.start();// 启动线程
		}
	}
	@SuppressWarnings("deprecation")
	@Override
	// 停止运行Applet小程序
	public void stop() {
		if (thread != null) {
			thread.stop();
			thread = null;
		}
	}
	@Override
	// 运行线程
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
	// 重新绘制组伯
	public void update(Graphics g) {
		paint(g);
	}
	//在终端显示相应
	public void Show(String theString, String theValue) {
		if (null == theValue) {
			System.out.println(theString + " : null");
		} else {
			System.out.println(theString + " : " + theValue);
		}
	}
}

/**
 * 星星类
 * @author tanglong
 */
class Star {
	int H, V;
	int x, y, z;
	int type;
	// 构造函数为各变量初始化
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
	 * 根据坐标绘制星星
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
	 * 给绘制的对象设置颜色
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