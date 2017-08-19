package java_core_basic;

import java.io.File;
import java.sql.Date;

public class FilePathTest {
	public static void main(String[] args) {
		File f1 = new File("f:/hello.txt");
		System.out.println("文件的绝对路径；"+f1.getAbsolutePath());

		File f2 = new File("hello.txt");
		System.out.println("文件的绝对路径；"+f2.getAbsolutePath());

		File f3 = new File(f1,"hello.txt");
		System.out.println("文件的绝对路径；"+f3.getAbsolutePath());

		//文件
		System.out.println("文件；"+f1);
		//文件是否存在
		System.out.println("文件是否存在；"+f1.exists());
		//是否是文件
		System.out.println("是否是文件；"+f1.isFile());
		//文件长
		System.out.println("文件长度；"+f1.length());
		//是否是文件夹
		System.out.println("是否是文件夹；"+f1.isDirectory());
		//最后修改时间
		System.out.println("最后修改时间；"+new Date(f1.lastModified()));
		//文件重命名
		//System.out.println("文件重命名；"+f1.renameTo(new File("NotHello.txt")));

		//以字符串数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
		System.out.println(f1.list());
	}
}
