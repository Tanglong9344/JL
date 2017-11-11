package java_excel;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * 使用jxl进行Excel文件读写
 * @author 唐龙
 */
public class ExcelJXL {
	//This is a test
	public static void main(String[] args) throws IOException, WriteException, BiffException{
		String fileName = "src/java_excel/excel.xlsx";
		//写入
		writeExcel(fileName);
		//读取
		readExcel(fileName);
	}

	//写入
	public static void writeExcel(String fileName) throws IOException, RowsExceededException, WriteException{
		final int N = 10;//行数和列数
		File file = new File(fileName);
		// 创建一个工作表
		WritableWorkbook workbook = Workbook.createWorkbook(file);
		// 创建一个工作簿
		WritableSheet sheet = workbook.createSheet("sheet1", 0);
		int row,col;
		// 向工作表中添加数据
		for (row = 0; row < N; row++){
			for (col = 0; col < N; col++){
				sheet.addCell(new Label(col,row,"Data-jxl"+row+col));
			}
		}
		workbook.write();
		workbook.close();
	}

	//读取
	public static void readExcel(String fileName) throws BiffException, IOException{
		File file = new File(fileName);
		// 获得工作表对象
		Workbook workbook = Workbook.getWorkbook(file);
		// 获得所有工作簿
		Sheet[] sheets = workbook.getSheets();
		int rows,cols,row,col;//行数，列数，单个工作簿行，列
		// 遍历工作表
		if (sheets != null){
			for (Sheet sheet : sheets){
				// 获得行数
				rows = sheet.getRows();
				// 获得列数
				cols = sheet.getColumns();
				// 读取数据
				for (row = 0; row < rows; row++){
					for (col = 0; col < cols; col++){
						System.out.printf("%15s", sheet.getCell(col, row).getContents());
					}
					System.out.println();
				}
			}
		}
		workbook.close();
	}
}