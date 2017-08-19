package java_GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class JTextAreaTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("文本域");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new FlowLayout());

		JLabel l = new JLabel("文本域：");
		JTextArea ta = new JTextArea();
		ta.setPreferredSize(new Dimension(200, 150));
		//'\n'换行符
		ta.setText("文本域！\n换行！\n");
		//追加数据
		ta.append("输入文本，接着换行！\n 再输入文本！");
		//设置自动换行
		ta.setLineWrap(true);
		f.add(l);
		f.add(ta);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
