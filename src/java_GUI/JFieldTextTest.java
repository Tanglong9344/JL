package java_GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JFieldTextTest {
	public static void main(String[] args) {
		final int MAX_NAME_LENTH = 10;//姓名最大输入长度
		final JFrame f = new JFrame("输入检验");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new BorderLayout());

		//输入框·
		JPanel p = new JPanel();
		final JLabel lName = new JLabel("名称");
		final JTextField tfName = new JTextField("");
		final JLabel lAge= new JLabel("年龄");
		final JTextField tfAge= new JTextField("");
		JButton bAdd = new JButton("检验");
		tfName.setPreferredSize(new Dimension(80, 30));
		tfAge.setPreferredSize(new Dimension(80, 30));

		p.add(lName);
		p.add(tfName);
		p.add(lAge);
		p.add(tfAge);
		p.add(bAdd);
		//检验动作
		bAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//姓名检验
				String name = tfName.getText().trim();
				//通过name长度判断 名称是否为空
				if (0 == name.length()) {
					// 弹出对话框提示用户
					JOptionPane.showMessageDialog(f, "名称不能为空");
					// 名称输入框获取焦点
					tfName.grabFocus();
					return;
				}
				//判断输入长度是否符合要求
				if (name.length()>MAX_NAME_LENTH) {
					// 弹出对话框提示用户
					JOptionPane.showMessageDialog(f, "输入名称过长[1-10]!");
					// 名称输入框获取焦点
					tfName.grabFocus();
					return;
				}
				//年龄检验
				String age = tfAge.getText().trim();
				//检测是否为空
				if(0 == age.length()){
					JOptionPane.showMessageDialog(f, "年龄不能为空!");
					tfAge.grabFocus();
					return;
				}
				//格式检验
				try {
					//把age转换为整型，如果出现异常NumberFormatException表示不是整型格式
					Integer.parseInt(age);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(f, "年龄只能是整数 !");
					tfAge.grabFocus();
					return;
				}
				//范围检验
				if(Integer.valueOf(age)<0 || Integer.valueOf(age)>200){
					JOptionPane.showMessageDialog(f, "年龄超出范围[0-200]!");
					tfAge.grabFocus();
					return;
				}
				//检验成功
				JOptionPane.showMessageDialog(f, "检验成功 !");
				return;
			}
		});

		f.add(p, BorderLayout.NORTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}