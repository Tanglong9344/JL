package java_GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableSelectionModelTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("表格");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setLayout(new BorderLayout());

		//创建一个TableModel
		TableModel tm= new TableModel();
		//根据 TableModel来创建 Table
		JTable t = new JTable(tm);
		// 准备一个Panel上面放一个Label用于显示哪条被选中了
		JPanel p = new JPanel();
		final JLabel l = new JLabel("暂时未选中条目");
		p.add(l);
		JScrollPane sp = new JScrollPane(t);
		// 使用selection监听器来监听table的哪个条目被选中
		t.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
					//当选择了某一行的时候触发该事件
					@Override
					public void valueChanged(ListSelectionEvent e) {
						int row = t.getSelectedRow();//第几列
						int col = t.getSelectedColumn();//第几行
						// 根据选中的行列获取相应的数据
						Object val = tm.getValueAt(row, col);
						// 更新标签内容
						l.setText("当前选中的数值是: " + val);
					}
				});
		f.add(p, BorderLayout.NORTH);

		f.add(sp, BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}