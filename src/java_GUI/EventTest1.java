package java_GUI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventTest1 extends WindowAdapter implements ActionListener {
	JButton b1 = null;
	JButton b2 = null;
	@SuppressWarnings("deprecation")
	public EventTest1() {
		JFrame f = new JFrame("EventTest1");
		Container contentPane = f.getContentPane();
		contentPane.setLayout(new GridLayout(1, 2));
		b1 = new JButton("点我有声音喔");
		b2 = new JButton("点我可开新窗口");
		b1.addActionListener(this);
		b2.addActionListener(this);
		contentPane.add(b1);
		contentPane.add(b2);
		f.pack();
		f.show();
		f.addWindowListener(this);
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			Toolkit.getDefaultToolkit().beep();
		}
		if (e.getSource() == b2) {
			JFrame jf = new JFrame("新窗口");
			jf.setSize(200, 200);
			jf.show();
		}
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	public static void main(String args[]) {
		new EventTest1();
	}
}