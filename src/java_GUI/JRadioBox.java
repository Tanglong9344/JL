package java_GUI;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class JRadioBox {
	public static void main(String[] args) { 
		JFrame f = new JFrame("单选框");
		f.setSize(400, 300);
		f.setLocation(580, 200);
		f.setLayout(null);

		JRadioButton b1 = new JRadioButton("苹果");
		// 设置 为 默认被选中
		b1.setSelected(true);
		b1.setBounds(50, 50, 130, 30);

		JRadioButton b2 = new JRadioButton("香蕉");
		b2.setBounds(50, 100, 130, 30);
		System.out.println("b1是否选中:"+b1.isSelected());
		System.out.println("b2是否选中:"+b2.isSelected());
		f.add(b1);
		f.add(b2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
