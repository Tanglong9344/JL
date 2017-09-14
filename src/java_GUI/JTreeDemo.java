package java_GUI;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class JTreeDemo {
	public static void main(String args[]) {
		JFrame f = new JFrame("JTreeDemo"); //创建窗体。
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane();

		Box box = Box.createHorizontalBox();
		JTree tree1 = new JTree(); //创建树。
		tree1.putClientProperty("JTree.lineStyle", "Angled");
		JScrollPane scrollPane1 = new JScrollPane(tree1);
		tree1.setAutoscrolls(true);
		JTree tree2 = new JTree(); //创建树。
		JScrollPane scrollPane2 = new JScrollPane(tree2);
		box.add(scrollPane1, BorderLayout.WEST);
		box.add(scrollPane2, BorderLayout.EAST);

		f.getContentPane().add(box, BorderLayout.CENTER);
		f.setSize(300, 240);
		f.setVisible(true);
	}
}
