package java_process;

import java.io.IOException;

/**
 * RunTime exec()
 * 
 * @author ����
 *
 */
public class RunTimeExec {
	public static void main(String[] args) throws IOException {
		//�򿪼�����
		Runtime.getRuntime().exec("calc");
		//�򿪼��±�
		Runtime.getRuntime().exec("notepad test.java");
	}
}