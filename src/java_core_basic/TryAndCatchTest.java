package java_core_basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * try...catch block
 *
 * @author ����
 */
public class TryAndCatchTest {
	public static void main(String[] args) {
		method1();
	}

	private static void method1() {
		try {
			method2();
		} catch (FileNotFoundException e) {
			System.out.println("method1()catch the errors.");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	private static void method2() throws FileNotFoundException {
		File f = new File("text.txt");
		System.out.println("method2() ��ͼ�� text.txt");
		new FileInputStream(f);
		System.out.println("�ɹ���");
		f.exists();
	}
}
