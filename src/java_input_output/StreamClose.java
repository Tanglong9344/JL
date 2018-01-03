package java_input_output;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Stream Close
 *
 * @author ����
 */
public class StreamClose {
	public static void main(String[] args) {
		File f = new File(CommonFileName.fileName);
		streamCloseFinally(f);
		streamCloseTryAuto(f);
	}

	//ʹ��try�Զ��ر���
	private static void streamCloseFinally(File f){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			byte[] all = new byte[(int) f.length()];
			fis.read(all);
			for (byte b : all) {
				System.out.print(b+" ");
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// ��finally ��ر���
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//ʹ��try�Զ��ر���
	private static void streamCloseTryAuto(File f){
		try(FileInputStream fis = new FileInputStream(f)){
			byte[] all = new byte[(int) f.length()];
			fis.read(all);
			for (byte b : all) {
				System.out.print(b+" ");
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}