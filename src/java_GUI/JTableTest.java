package java_GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTable;

public class JTableTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("表格");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new BorderLayout());

		// 表格上的title
		String[] header = new String[] { "姓名", "性别", "身高", "体重" };
		// 表格中的内容，是一个二维数组
		String[][] content = new String[][] {
			 { "张衡", "男", "九尺", "未知" }
			,{ "曹操", "男", "七尺", "70kg" }
			, { "小红", "女", "168cm", "45kg" }
			, { "大绿", "女", "172cm", "55kg" }
			, { "李白", "男", "188cm", "70kg" }
			, { "刘飞扬", "男", "178cm", "65kg" }
			, { "貂蝉", "女", "171cm", "53kg" }
			};
		JTable t = new JTable(content, header);
		f.add(t, BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
