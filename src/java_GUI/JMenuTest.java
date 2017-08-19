package java_GUI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JMenuTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("菜单");
		f.setSize(400, 300);
		f.setLocation(200, 200);

		// 菜单栏
		JMenuBar mb = new JMenuBar();
		// 菜单
		JMenu jm1 = new JMenu("水果");
		//菜单项
		jm1.add(new JMenuItem("苹果"));
		jm1.add(new JMenuItem("香蕉"));
		jm1.add(new JMenuItem("菠萝"));
		jm1.add(new JMenuItem("西瓜"));

		// 菜单
		JMenu jm2 = new JMenu("蔬菜");
		//菜单项
		jm2.add(new JMenuItem("番茄"));
		jm2.add(new JMenuItem("茄子"));
		jm2.add(new JMenuItem(""));
		jm2.add(new JMenuItem(""));
		jm2.add(new JMenuItem("黄瓜"));
		jm2.add(new JMenuItem("豆角"));

		// 菜单
		JMenu jm3 = new JMenu("面食");
		//菜单项
		jm3.add(new JMenuItem("面条"));
		jm3.add(new JMenuItem("馒头"));
		jm3.add(new JMenuItem("包子"));
		jm3.add(new JMenuItem("油条"));
		jm3.add(new JMenuItem("面包"));
		jm3.add(new JMenuItem("饺子"));

		// 菜单
		JMenu jm4 = new JMenu("");
		//菜单项
		jm4.add(new JMenuItem("辣椒"));
		jm4.add(new JMenuItem("醋"));
		jm4.add(new JMenuItem("酱油"));
		jm4.add(new JMenuItem("豆豉"));
		jm4.add(new JMenuItem("葱姜蒜"));

		// 菜单
		JMenu jm5 = new JMenu("肉类");

		// 把菜单加入到菜单栏
		mb.add(jm1);
		mb.add(jm2);
		mb.add(jm3);
		mb.add(jm4);
		mb.add(jm5);

		// 把菜单栏加入到frame，这里用的是set而非add
		f.setJMenuBar(mb);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
