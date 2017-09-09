package java_input_output;

import java.io.File;
import java.io.FilenameFilter;

public class FileNameFilterTest {
	//�½��ļ���������
	static class MyFilenameFilter implements FilenameFilter {
		private String sf = ""; // �����ļ��ĺ�׺��
		public MyFilenameFilter(String surfix) {
			this.sf = surfix;
		}
		// ��дFilenameFilter�ӿ��е�accept�������ж�ָ�����ļ��Ƿ���ָ����Ŀ¼��
		@Override
		public boolean accept(File dir, String name) {
			// �����ǰ��File������һ���ļ����򷵻����Ƿ���ָ���ĺ�׺����
			if (new File(dir, name).isFile()) {
				return name.endsWith(sf);
			} else {
				// ������ļ��У���ֱ�ӷ���true
				return true;
			}
		}
	}
	// �г�ָ��Ŀ¼�������ļ�����Ŀ¼��·��
	public static void getAllFiles(String dirName) {
		// ���dir�����ļ��ָ�����β���Զ�����ļ��ָ�����
		if (!dirName.endsWith(File.separator)) {
			dirName = dirName + File.separator;
		}
		File dirFile = new File(dirName);
		// ���dir��Ӧ���ļ������ڣ����߲���һ���ļ��У����˳�
		if (!dirFile.exists() || (!dirFile.isDirectory())) {
			System.out.println("ʧ�ܣ��Ҳ���ָ����Ŀ¼��" + dirName);
			return;
		}
		// �г�Դ�ļ����������ļ���������Ŀ¼��
		File[] fileArray = dirFile.listFiles();
		for (int i = 0; i < fileArray.length; i++) {
			if (fileArray[i].isFile()) {
				System.out.println(fileArray[i].getAbsolutePath());
			} else if (fileArray[i].isDirectory()) {
				System.out.println(fileArray[i].getAbsolutePath());
				FileNameFilterTest.getAllFiles(fileArray[i].getAbsolutePath());
			}
		}
	}
	// ��ȡ��ָ��Ŀ¼�·���ָ����׺�ļ����������ļ�
	public static void getFilesByFilter(FilenameFilter filter,String dirPath) {
		// ���Ŀ¼·���������ļ��ָ�����β���Զ�����ļ��ָ�����
		if (!dirPath.endsWith(File.separator)) {
			dirPath = dirPath + File.separator;
		}
		File dir_File = new File(dirPath);
		// ���ָ����Ŀ¼�����ڻ���һ��Ŀ¼�򷵻�
		if (!dir_File.exists() || (!dir_File.isDirectory())) {
			System.out.println("ʧ�ܣ��Ҳ���ָ��Ŀ¼��" + dirPath);
			return;
		}
		// �г�ָ��Ŀ¼�µ����з��Ϲ������������ļ���������Ŀ¼��
		File[] fileArray = dir_File.listFiles(filter);
		for (int i = 0; i < fileArray.length; i++) {
			if (fileArray[i].isFile()) {
				System.out.println(fileArray[i].getAbsolutePath() + " ���ļ�!");
			} else if (fileArray[i].isDirectory()) {
				System.out.println(fileArray[i].getAbsolutePath() + " ��Ŀ¼!");
				FileNameFilterTest.getFilesByFilter(filter, fileArray[i].getAbsolutePath());
			}
		}
	}
	public static void main(String[] args) {
		String dir = "F:\\temp";
		System.out.println((dir + "Ŀ¼�µ�����: "));
		FileNameFilterTest.getAllFiles(dir);
		System.out.println("*****************************");

		System.out.println("���Ϲ������������ļ����£�");
		// �½�һ���ļ���������������Ϊ".java"
		String sf = "java";
		FilenameFilter myFilenameFilter = new FileNameFilterTest.MyFilenameFilter(sf);
		FileNameFilterTest.getFilesByFilter(myFilenameFilter, dir);
	}
}