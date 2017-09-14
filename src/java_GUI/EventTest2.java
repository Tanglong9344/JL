package java_GUI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventTest2 extends WindowAdapter implements MouseListener {
	JFrame f = null;
	JButton b1 = null;
	JLabel label = null;
	public EventTest2() {
		f = new JFrame("EventTest2");
		Container contentPane = f.getContentPane();
		contentPane.setLayout(new GridLayout(2, 1));
		b1 = new JButton("按钮");
		label = new JLabel("起始状态，还没有鼠标事件", JLabel.CENTER);
		b1.addMouseListener(this);
		contentPane.add(label);
		contentPane.add(b1);
		f.pack();
		f.show();
		f.addWindowListener(this);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		label.setText("你已经压下鼠标按钮");
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		label.setText("你已经放开鼠标按钮");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		label.setText("鼠标光标进入按钮");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		label.setText("鼠标光标离开按钮");
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		label.setText("你已经按下按钮");
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	public static void main(String[] args) {
		new EventTest2();
	}
}
