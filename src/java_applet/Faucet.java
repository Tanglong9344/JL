/**
 * 水流下落效果
 */

package java_applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Faucet extends Applet implements Runnable {
	private static final long serialVersionUID = 1L;
	private static final int MAX_DROP = 1500;// 水滴的最大个数
	Drop d[];// 声明一个水滴对象
	int width, height, X, Y;// 声明Applet小程序的宽和高，及以XY坐标中心
	Image off;// 声明一个图片对象
	Graphics graphics;// 声明一个Graphics对象
	Thread thread;// 声明一个线程对象

	@Override
	// Applet小程序初始化
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
	// 开始执行小程序
	public void start() {
		thread = new Thread(this);
		thread.start();
	}

	@Override
	// 停止执行小程序
	public void stop() {
		thread = null;
	}

	@Override
	// 重新绘制小程序
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	// 绘制组件
	public void paint(Graphics g) {
		g.drawImage(off, 0, 0, this);
	}

	@Override
	// 运行线程
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
 * 水滴类
 */
class Drop {
	double X, Y;
	double newX, newY;
	int time;

	public Drop() {
		reset();
	}

	// 重新设置绘制水滴的位置和大小
	public void reset() {
		X = (int) (Math.random() * (-40));
		Y = (int) (Math.random() * 5 + 10);
		newX = Math.random() * 3 + 1.0;
		newY = 0;
		time = 0;
	}
}