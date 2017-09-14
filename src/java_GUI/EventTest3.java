package java_GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class EventTest3 extends JFrame implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	// flag=1代表Mouse Moved,flag=2代表Mouse Dragged
	int flag;
	int x = 0;
	int y = 0;
	int startx, starty, endx, endy;// 起始坐标与终点坐标
	@SuppressWarnings("deprecation")
	public EventTest3() {
		Container contentPane = getContentPane();
		contentPane.addMouseListener(this);
		contentPane.addMouseMotionListener(this);
		setSize(300, 300);
		show();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	//由mousePressed(),mouseReleased()取得示拖曳的开始与结束坐标
	@Override
	public void mousePressed(MouseEvent e) {
		startx = e.getX();
		starty = e.getY();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		endx = e.getX();
		endy = e.getY();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	// mouseMoved(),mouseDragged()取得鼠标移动的每一个坐标，并调用repaint()方法
	@Override
	public void mouseMoved(MouseEvent e) {
		flag = 1;
		x = e.getX();
		y = e.getY();
		repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		flag = 2;
		x = e.getX();
		y = e.getY();
		repaint();
	}
	@Override
	public void update(Graphics g) {
		g.setColor(this.getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		paint(g);
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		if (flag == 1) {
			g.drawString("鼠标坐标：(" + x + "," + y + ")", 10, 50);
			g.drawLine(startx, starty, endx, endy);
		}
		if (flag == 2) {
			g.drawString("拖曳鼠标价坐标：(" + x + "," + y + ")", 10, 50);
			g.drawLine(startx, starty, x, y);
		}
	}
	public static void main(String[] args) {
		new EventTest3();
	}
}