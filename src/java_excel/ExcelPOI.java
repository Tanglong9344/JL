package java_excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * 使用 poi 进行Excel文件读写
 * @author 唐龙
 */
public class ExcelPOI {
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
		FileOutputStream xlsStream = new FileOutputStream(file);
		// 创建工作表
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建工作簿
		HSSFSheet sheet = workbook.createSheet("sheet1");
		int row,col;
		HSSFRow rows;
		for (row = 0; row < N; row++){
			rows = sheet.createRow(row);//
			// 向工作表中添加数据
			for (col = 0; col < N; col++){
				rows.createCell(col).setCellValue("Data-poi" + row + col);
			}
		}
		//写入文件
		workbook.write(xlsStream);
	}

	//读取
	public static void readExcel(String fileName) throws BiffException, IOException{
		File file = new File(fileName);
		// 获取工作表
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
		int num = wb.getNumberOfSheets();//工作簿数目
		HSSFSheet sheet;
		for(int i=0;i<num;i++){
			// 获取工作簿
			sheet = wb.getSheetAt(i);
			//按内容类型读取
			for (Row row : sheet) {
				for (Cell cell : row) {
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						//字符串
						System.out.printf("%15s",cell.getRichStringCellValue().getString());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						if(DateUtil.isCellDateFormatted(cell)) {
							//日期
							System.out.printf("%15s",String.valueOf(cell.getDateCellValue()));
						} else{
							//数字
							System.out.printf("%15s",cell.getNumericCellValue());
						}
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						//布尔值
						System.out.printf("%15s",cell.getBooleanCellValue());
						break;
					default:;
					}
				}
				System.out.println();
			}
		}
	}
}