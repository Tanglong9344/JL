package java_core_basic;

import java.io.File;
import java.sql.Date;

public class FilePathTest {
	public static void main(String[] args) {
		File f1 = new File("f:/hello.txt");
		System.out.println("�ļ��ľ���·����"+f1.getAbsolutePath());

		File f2 = new File("hello.txt");
		System.out.println("�ļ��ľ���·����"+f2.getAbsolutePath());

		File f3 = new File(f1,"hello.txt");
		System.out.println("�ļ��ľ���·����"+f3.getAbsolutePath());

		//�ļ�
		System.out.println("�ļ���"+f1);
		//�ļ��Ƿ����
		System.out.println("�ļ��Ƿ���ڣ�"+f1.exists());
		//�Ƿ����ļ�
		System.out.println("�Ƿ����ļ���"+f1.isFile());
		//�ļ���
		System.out.println("�ļ����ȣ�"+f1.length());
		//�Ƿ����ļ���
		System.out.println("�Ƿ����ļ��У�"+f1.isDirectory());
		//����޸�ʱ��
		System.out.println("����޸�ʱ�䣻"+new Date(f1.lastModified()));
		//�ļ�������
		//System.out.println("�ļ���������"+f1.renameTo(new File("NotHello.txt")));

		//���ַ����������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ������ļ��У�
		System.out.println(f1.list());
	}
}
