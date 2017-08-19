package java_GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyListenerTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("图片的上下左右移动·");
		f.setSize(500, 400);//大小
		f.setLocation(600, 200);//位置
		f.setLayout(null);//样式

		final JLabel l = new JLabel();
		ImageIcon i = new ImageIcon("f:/Firefox.png");
		l.setIcon(i);
		l.setBounds(180, 100, i.getIconWidth(), i.getIconHeight());
		// 增加键盘监听
		f.addKeyListener(new KeyListener() {
			// 键被弹起
			public void keyReleased(KeyEvent e) {
				// 37 表示向左移动的按键
				if(e.getKeyCode() == 37){
					// 图片向右移动 （x坐标减少，y坐标不变）
					l.setLocation(l.getX()-10, l.getY());
				}
				// 38 表示向上移动的按键
				if(e.getKeyCode() == 38){
					// 图片向右移动 （x坐标不变，y坐标减少）
					l.setLocation(l.getX(), l.getY()-10);
				}
				// 39 表示向右移动的按键
				if (e.getKeyCode() == 39) {
					// 图片向右移动 （y坐标不变，x坐标增加）
					l.setLocation(l.getX() + 10, l.getY());
				}
				// 40 表示向下移动的按键
				if(e.getKeyCode() == 40){
					// 图片向右移动 （x坐标不变，y坐标增加）
					l.setLocation(l.getX(), l.getY()+10);
				}
			}
			//键被按下
			public void keyPressed(KeyEvent e) {
				// 37 表示向左移动的按键
				if(e.getKeyCode() == 37){
					// 图片向右移动 （x坐标减少，y坐标不变）
					l.setLocation(l.getX()-10, l.getY());
				}
				// 38 表示向上移动的按键
				if(e.getKeyCode() == 38){
					// 图片向右移动 （x坐标不变，y坐标减少）
					l.setLocation(l.getX(), l.getY()-10);
				}
				// 39 表示向右移动的按键
				if (e.getKeyCode() == 39) {
					// 图片向右移动 （y坐标不变，x坐标增加）
					l.setLocation(l.getX() + 10, l.getY());
				}
				// 40 表示向下移动的按键
				if(e.getKeyCode() == 40){
					// 图片向右移动 （x坐标不变，y坐标增加）
					l.setLocation(l.getX(), l.getY()+10);
				}
			}
			// 一个按下弹起的组合动作
			public void keyTyped(KeyEvent e) {
				// 37 表示向左移动的按键
				if(e.getKeyCode() == 37){
					// 图片向右移动 （x坐标减少，y坐标不变）
					l.setLocation(l.getX()-10, l.getY());
				}
				// 38 表示向上移动的按键
				if(e.getKeyCode() == 38){
					// 图片向右移动 （x坐标不变，y坐标减少）
					l.setLocation(l.getX(), l.getY()-10);
				}
				// 39 表示向右移动的按键
				if (e.getKeyCode() == 39) {
					// 图片向右移动 （y坐标不变，x坐标增加）
					l.setLocation(l.getX() + 10, l.getY());
				}
				// 40 表示向下移动的按键
				if(e.getKeyCode() == 40){
					// 图片向右移动 （x坐标不变，y坐标增加）
					l.setLocation(l.getX(), l.getY()+10);
				}
			}
		});
		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}

