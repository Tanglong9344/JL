package something_interesting;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

//多功能画笔
public class Paintbrush extends Frame{
	private static final long serialVersionUID = 1L;

	private final static int POINT = 0;//点状
	private final static int LINE = 1;//线状
	private final static int RECTANGLE = 2;//矩形
	private final static int OVAL = 3;//圆形
	private int type; // 画笔类型
	Point p1;
	Point p2;
	ArrayList<Point> points = new ArrayList<Point>();
	ArrayList<DrawPoint> area = new ArrayList<DrawPoint>();
	public Paintbrush(String s) {
		super(s);
	}
	public void mainFrame() {
		MenuBar menuBar = new MenuBar();
		//选择菜单
		Menu menu = new Menu("选项");
		MenuItem fmi4 = new MenuItem("退出（E）");
		fmi4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.addSeparator();
		//添加菜单项
		menu.add(fmi4);
		//画笔种类菜单
		Menu mtype = new Menu("画笔种类");
		MenuItem menuItem1 = new MenuItem("点状（P）");
		menuItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				type = Paintbrush.POINT;
			}
		});
		MenuItem menuItem2 = new MenuItem("线状（L）");
		menuItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				type = Paintbrush.LINE;
			}
		});
		MenuItem dmi3 = new MenuItem("矩形（R）");
		dmi3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				type = Paintbrush.RECTANGLE;
			}
		});
		MenuItem dmi4 = new MenuItem("圆形（C）");
		dmi4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				type = Paintbrush.OVAL;
			}
		});
		//添加菜单项
		mtype.add(menuItem1);
		mtype.add(menuItem2);
		mtype.add(dmi3);
		mtype.add(dmi4);
		//添加菜单到菜单栏
		menuBar.add(menu);
		menuBar.add(mtype);

		setMenuBar(menuBar);
		//窗口监听器
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//鼠标监听器
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				p1 = new Point(e.getX(), e.getY());
				if (type == Paintbrush.POINT) {
					points.add(p1);
					repaint();
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if (type != Paintbrush.POINT) {
					p2 = new Point(e.getX(), e.getY());
					area.add(new DrawPoint(p1, p2, type));
					repaint();
				}
			}
		});
		setBounds(50, 50, 640, 480);
		setBackground(Color.WHITE);
		setVisible(true);
	}
	@Override
	public void paint(Graphics g) {
		Iterator<Point> ip = points.iterator(); // 使用泛型
		g.setColor(Color.black);
		while (ip.hasNext()) {
			Point p = ip.next(); // 使用泛型
			g.fillOval(p.x, p.y, 10, 10);
		}
		// 起始点坐标
		int x1, y1, x2, y2;
		for (Iterator<DrawPoint> ipp = area.iterator(); ipp.hasNext();) {
			DrawPoint pp = ipp.next();

			x1 = (int) pp.startPoint.getX();
			y1 = (int) pp.startPoint.getY();
			x2 = (int) pp.endPoint.getX();
			y2 = (int) pp.endPoint.getY();

			switch (pp.type) {
			case LINE:
				g.setColor(Color.green);
				g.drawLine(x1, y1, x2, y2);
				break;
			case RECTANGLE:
				g.setColor(Color.red);
				g.drawRect(x1, y1, x2 - x1, y2 - y1);
				// 鼠标从右向左或从下往上拖动，不能绘制出图像:负值无意义
				break;
			case OVAL:
				g.setColor(Color.blue);
				g.drawOval(x1, y1, x2 - x1, y2 - y1);
				break;
			default:
				break;
			}
		}
	}

	public static void main(String[] args) {
		Paintbrush drawApp = new Paintbrush("多功能彩色画笔");
		drawApp.mainFrame();
	}
}
class DrawPoint {
	public Point startPoint;
	public Point endPoint;
	public int type;

	public DrawPoint(Point sPoint, Point ePoint, int drawType) {
		startPoint = sPoint;
		endPoint = ePoint;
		type = drawType;
	}
}