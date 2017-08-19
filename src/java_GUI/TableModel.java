package java_GUI;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
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

	// 返回一共有多少行
	@Override
	public int getRowCount() {
		return content.length;
	}

	@Override
	// 返回一共有多少列
	public int getColumnCount() {
		return header.length;
	}
	// 获取每一列的名称
	public String getColName(int colIdx) {
		return header[colIdx];
	}

	// 单元格是否可以修改
	@Override
	public boolean isCellEditable(int rowIdx, int colIdx) {
		return false;
	}

	// 每一个单元格里的值
	@Override
	public Object getValueAt(int rowIdx, int colIdx) {
		return content[rowIdx][colIdx];
	}
}
