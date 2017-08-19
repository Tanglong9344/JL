package java_GUI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class NotePadTextPractice {
		public static void main(String[] args) {
			JFrame f = new JFrame("新建文本文档 - 记事本");
			f.setSize(450, 500);
			f.setLocation(200, 200);

			// 菜单栏
			JMenuBar mb = new JMenuBar();
			// 菜单
			JMenu jm1 = new JMenu("文件(F)");
			//菜单项
			jm1.add(new JMenuItem("新建(N)        Ctrl + N"));
			jm1.add(new JMenuItem("打开(O)...     Ctrl + O"));
			jm1.add(new JMenuItem("保存(S)        Ctrl + S"));
			jm1.add(new JMenuItem("另存为(A)..."));
			jm1.add(new JMenuItem("------------------------"));
			jm1.add(new JMenuItem("页面设置(U)..."));
			jm1.add(new JMenuItem("打印(P)...     Ctrl + P"));
			jm1.add(new JMenuItem("------------------------"));
			jm1.add(new JMenuItem("退出(X)"));

			// 菜单
			JMenu jm2 = new JMenu("编辑(E)");
			//菜单项
			jm2.add(new JMenuItem("撤销(U)        Ctrl + Z"));
			jm2.add(new JMenuItem("------------------------"));
			jm2.add(new JMenuItem("剪切(T)        Ctrl + X"));
			jm2.add(new JMenuItem("复制(C)        Ctrl + C"));
			jm2.add(new JMenuItem("粘贴(P)        Ctrl + V"));
			jm2.add(new JMenuItem("删除(L)        Del"));
			jm2.add(new JMenuItem("------------------------"));
			jm2.add(new JMenuItem("查找(F)...     Ctrl + F"));
			jm2.add(new JMenuItem("查找下一个(N)    F3"));
			jm2.add(new JMenuItem("替换(R)...     Ctrl + H"));
			jm2.add(new JMenuItem("转到(G)...     Ctrl + G"));
			jm2.add(new JMenuItem("全选(A)        Ctrl + A"));
			jm2.add(new JMenuItem("时间/日期(D)    F5"));

			// 菜单
			JMenu jm3 = new JMenu("格式(O)");
			//菜单项
			jm3.add(new JMenuItem("自动换行(W)"));
			jm3.add(new JMenuItem("字体(F)..."));

			// 菜单
			JMenu jm4 = new JMenu("查看(V)");
			//菜单项
			jm4.add(new JMenuItem("状态栏(S)"));

			// 菜单
			JMenu jm5 = new JMenu("帮助(H)");
			jm5.add(new JMenuItem("查看帮助(H)"));
			jm5.add(new JMenuItem("------------------------"));
			jm5.add(new JMenuItem("关于记事本(A)"));

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