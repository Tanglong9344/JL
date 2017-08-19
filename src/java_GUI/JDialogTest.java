package java_GUI;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class JDialogTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("外部窗体");
		f.setSize(800, 600);
		f.setLocation(100, 100);
		f.setVisible(true);

		// 根据外部窗体实例化JDialog
		JDialog d = new JDialog(f);
		// 设置为模态
		d.setModal(true);
		d.setTitle("模态的对话框");
		d.setSize(400, 300);
		d.setLocation(200, 200);
		d.setLayout(null);

		JButton b = new JButton("第二层框体");
		b.setBounds(50, 50, 280, 30);
		d.add(b);
		d.setVisible(true);//只有放在JButton实例之后按钮才会显示

		// 根据外部窗体实例化JDialog
		JDialog d1 = new JDialog(f);
		// 设置为模态
		d1.setModal(true);
		d1.setTitle("模态的对话框");
		d1.setSize(400, 300);
		d1.setLocation(200, 200);
		d1.setLayout(null);

		JButton b1 = new JButton("第一层框体");
		b1.setBounds(50, 50, 280, 30);
		d1.add(b1);
		d1.setVisible(true);
	}
}
