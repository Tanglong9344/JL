package java_input_output;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Stream Close
 *
 * @author 唐龙
 */
public class StreamClose {
	public static void main(String[] args) {
		File f = new File(CommonFileName.fileName);
		streamCloseFinally(f);
		streamCloseTryAuto(f);
	}

	//使用try自动关闭流
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
			// 在finally 里关闭流
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//使用try自动关闭流
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