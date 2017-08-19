package java_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class JDialogTest2 {
	public static void main(String[] args) {
		JFrame f = new JFrame("外部窗体");
		f.setSize(800, 600);
		f.setLocation(100, 100);
		
		JButton b = new JButton("创建模态窗体");
		b.setBounds(50, 50, 280, 30);
		f.add(b);
		f.setVisible(true);

		
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){
				System.out.println("点击事件！");
				// 根据外部窗体实例化JDialog
				JDialog d = new JDialog(f);
				// 设置为模态
				d.setModal(true);
				d.setTitle("模态的对话框");
				d.setSize(400, 300);
				d.setLocation(200, 200);
				d.setLayout(null);

				JButton b1 = new JButton("这是模态的对话框");
				b1.setBounds(50, 50, 280, 30);
				d.add(b1);
				d.setVisible(true);//只有放在JButton实例之后按钮才会显示
			}
			
		});
	}
}
