package java_GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Calculator extends WindowAdapter implements ActionListener {
	JFrame list;
	JTextField show;
	JButton bc;		// 按钮退格
	JButton c;		// 按钮清空
	JButton ce;		// 按钮复位
	JButton ab;		// 按钮关于
	JButton add;	// 按钮加
	JButton minus;	// 按钮减
	JButton multi;	// 按钮乘
	JButton divide;	// 按钮除
	JButton equ;	// 按钮等号
	JButton point;	// 按钮小数点
	JButton sqrt;	// 按钮2次方根
	JButton ds;		// 按钮倒数
	JButton bfh;	// 按钮百分号
	JButton zf;//正负号
	JButton b[] = new JButton[10]; // 按钮数组，数字键0～9
	double sum = 0, getValue;
	int i = 0, j = 0, p = 0, l, action;
	JDialog about;
	final int slength = 30; // 设置结果显示有效长度
	public void disp() {
		list = new JFrame("简易计算器");
		list.setSize(360, 230);
		list.setLocation(380, 260);
		list.setBackground(Color.LIGHT_GRAY);
		list.setLayout(new FlowLayout(FlowLayout.CENTER));
		list.setResizable(false);
		show = new JTextField(31);
		show.setText("0");
		show.setHorizontalAlignment(SwingConstants.RIGHT);
		show.setEditable(false);
		list.add(show);
		Panel dispTop = new Panel();
		list.add(dispTop);
		dispTop.setLayout(new GridLayout(1, 4, 3, 3));
		bc = new JButton("  Back    ");
		bc.setForeground(Color.BLUE);
		dispTop.add(bc);
		ce = new JButton("  CE   ");
		ce.setForeground(Color.BLUE);
		dispTop.add(ce);
		c = new JButton("  C   ");
		c.setForeground(Color.BLUE);
		dispTop.add(c);
		ab = new JButton("   About   ");
		ab.setForeground(Color.BLUE);
		dispTop.add(ab);
		about = new JDialog(list, "关于计算器", true);
		Label ct = new Label("http://blog.csdn.net/wibnmo", 1);
		ct.setForeground(Color.RED);
		about.add(ct, "Center");
		about.setSize(200, 100);
		about.setLocation(500, 300);
		about.addWindowListener(this);
		Panel dispMain = new Panel();
		list.add(dispMain);
		dispMain.setLayout(new GridLayout(1, 2, 10, 10));
		Panel dispLeft = new Panel();
		dispMain.add(dispLeft);
		dispLeft.setLayout(new GridLayout(4, 3, 3, 3));
		Panel dispRight = new Panel();
		dispMain.add(dispRight);
		dispRight.setLayout(new GridLayout(4, 2, 3, 3));
		for (l = 9; l >= 0; l--) {
			b[l] = new JButton(String.valueOf(l));
			dispLeft.add(b[l]);
			b[l].addActionListener(this);
		}
		add = new JButton("+");
		add.setForeground(Color.RED);
		minus = new JButton("-");
		minus.setForeground(Color.RED);
		multi = new JButton("*");
		multi.setForeground(Color.RED);
		divide = new JButton("/");
		divide.setForeground(Color.RED);
		equ = new JButton("=");
		equ.setForeground(Color.RED);
		point = new JButton(".");
		zf = new JButton(" +/- ");
		sqrt = new JButton("sqrt");
		bfh = new JButton("%");
		ds = new JButton("1/x");
		dispRight.add(divide);
		dispRight.add(sqrt);
		dispRight.add(multi);
		dispRight.add(bfh);
		dispRight.add(minus);
		dispRight.add(ds);
		dispRight.add(add);
		dispRight.add(equ);
		dispLeft.add(zf);
		dispLeft.add(point);
		bc.addActionListener(this);
		ce.addActionListener(this);
		c.addActionListener(this);
		ab.addActionListener(this);
		add.addActionListener(this);
		minus.addActionListener(this);
		multi.addActionListener(this);
		divide.addActionListener(this);
		equ.addActionListener(this);
		point.addActionListener(this);
		zf.addActionListener(this);
		sqrt.addActionListener(this);
		bfh.addActionListener(this);
		ds.addActionListener(this);
		list.addWindowListener(this);
		list.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		getValue = Double.valueOf(show.getText()).doubleValue();
		if (e.getSource() == add) { // 加运算，可连加
			if (j == 0) {
				sum = getValue;
			} else if (action == 1) {
				sum += getValue;
			}
			setSum();
			j++;
			p = 0;
			i = 0;
			action = 1;
		} else if (e.getSource() == minus) { // 减运算，可连减
			if (j == 0) {
				sum = getValue;
			} else if (action == 2) {
				sum -= getValue;
			}
			setSum();
			j++;
			p = 0;
			i = 0;
			action = 2;
		} else if (e.getSource() == multi) { // 乘运算，可连乘
			if (j == 0) {
				sum = getValue;
			} else if (action == 3) {
				sum *= getValue;
			}
			setSum();
			j++;
			p = 0;
			i = 0;
			action = 3;
		} else if (e.getSource() == divide) { // 除运算，可连除
			if (j == 0) {
				sum = getValue;
			} else if (action == 4) {
				sum /= getValue;
			}
			setSum();
			j++;
			p = 0;
			i = 0;
			action = 4;
		} else if (e.getSource() == equ) { // 等号,运算最后一个操作数
			switch (action) {
			case 1:
				show.setText(String.valueOf(sum += getValue));
				break;
			case 2:
				show.setText(String.valueOf(sum -= getValue));
				break;
			case 3:
				show.setText(String.valueOf(sum *= getValue));
				break;
			case 4:
				show.setText(String.valueOf(sum /= getValue));
				break;
			}
			setSum();
			i = 0;
			j = 0;
			action = 0;
		} else if (e.getSource() == point) { // 小数点,只能按一个小数点
			if (p == 0) {
				show.setText(show.getText() + e.getActionCommand());
			}
			p = 1;
		} else if (e.getSource() == c || e.getSource() == ce) { // 清空与复位
			i = 0;
			j = 0;
			p = 0;
			sum = 0;
			action = 0;
			show.setText("0");
		} else if (e.getSource() == bc) { // 退格
			String s = show.getText();
			if (s.length() > 1) {
				show.setText("");
				for (l = 0; l < s.length() - 1; l++) { // 按一下,删除尾部一位
					char a = s.charAt(l);
					show.setText(show.getText() + a);
				}
			} else {
				show.setText("0");
			}
		} else if (e.getSource() == ab) { // 关于
			about.setVisible(true);
		} else if (e.getSource() == sqrt) { // 开2次方根
			sum = Math.sqrt(getValue);
			setSum();
			i = 0;
		} else if (e.getSource() == ds) { // 求倒数
			sum = 1 / getValue;
			setSum();
			i = 0;
		} else if (e.getSource() == bfh) { // 百分号
			sum = getValue / 100;
			setSum();
			i = 0;
		} else if (e.getSource() == zf) { // 正负号切换,正号不显示
			String s = show.getText();
			char a = s.charAt(0);
			if (a == '-') {
				show.setText("");
				for (l = 1; l < s.length(); l++) { // 去掉负号
					show.setText(show.getText() + s.charAt(l));
				}
			} else if (getValue != 0) { // 加上负号
				show.setText("-" + s);
			}
		}
		for (l = 0; l < 10; l++) { // 0~9数字键触发
			if (e.getSource() == b[l]) {
				if (i == 0) {
					show.setText("");
				}
				String s = show.getText();
				if (s.length() < slength) {
					show.setText(show.getText() + e.getActionCommand());
				}
				if (e.getSource() == b[0] && getValue == 0 && p == 0) {
					show.setText("0");
				}
				if (e.getSource() != b[0] && getValue == 0 && p == 0) {
					show.setText(e.getActionCommand());
				}
				i++;// i用来标记数字键触发的状态
			}
		}
	}
	public void setSum() { // 把计算结果显示出来
		show.setText(String.valueOf(sum));
		String s = show.getText();
		char a = s.charAt((s.length() - 1));
		char b = s.charAt((s.length() - 2));
		if (a == '0' && b == '.') { // 如果是整数,则去掉后面的小数点和0
			show.setText(String.valueOf(Math.round(sum)));
		}
	}
	@Override
	public void windowClosing(WindowEvent e) {
		if (e.getSource() == about) {
			about.setVisible(false);
		} else if (e.getSource() == list) {
			System.exit(0);
		}
	}
	public static void main(String args[]) {
		new Calculator().disp();
	}
}