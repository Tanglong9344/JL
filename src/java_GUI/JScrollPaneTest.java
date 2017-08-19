package java_GUI;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JScrollPaneTest {
	public static void main(String[] args) {
		final int NUM=1000;
		JFrame f=new JFrame("滚动面板");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(null);

		//准备一个文本域，在里面放很多数据
		JTextArea ta=new JTextArea();
		for (int i=0; i < NUM; i++) {
			ta.append(String.valueOf(i*i));
		}
		//自动换行
		ta.setLineWrap(true);
		//滚动条
		JScrollPane sp=new JScrollPane(ta);
		f.setContentPane(sp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}