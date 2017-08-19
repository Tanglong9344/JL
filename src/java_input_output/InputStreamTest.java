package java_input_output;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class InputStreamTest {

	public static void main(String[] args){
		Workbook workbook;
		Sheet sheet = null;
		int row;
		int col;
		try {
			File f = new File("f:/test.xls");
			workbook = Workbook.getWorkbook(f);//获取表格
			sheet = workbook.getSheet(0);//获取表格第一个表
			row = sheet.getRows();//获取行数
			col = sheet.getColumns();//获取列数
			System.out.println("行数:"+row);
			System.out.println("列数:"+col);
			//获取所有单元格的内容
			for(int i=0;i<row-1;i++){
				for(int j=0;j<col-1;j++) {
					System.out.print(sheet.getCell(j, i).getContents()+"\t");
				}
				System.out.println();
			}
		}catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
