package java_input_output;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream and FileInputStream
 *
 * @author 唐龙
 */
public class FileOutputStreamFileInputStream {
	public static void main(String[] args) {
		write();
		read();
	}

	// write data
	private static void write() {
		File f = new File(CommonFileName.fileName);
		try (
				FileOutputStream fos = new FileOutputStream(f);
				DataOutputStream dos = new DataOutputStream(fos);
				){
			dos.writeBoolean(true);
			dos.writeInt(300);
			dos.writeUTF("Hello FileOutPutStream,I am Tanglong.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// read data
	private static void read() {
		File f = new File(CommonFileName.fileName);
		try (
				FileInputStream fis  = new FileInputStream(f);
				DataInputStream dis =new DataInputStream(fis);
				){
			boolean b= dis.readBoolean();
			int i = dis.readInt();
			String str = dis.readUTF();
			System.out.println("读取到布尔值:"+b);
			System.out.println("读取到整数:"+i);
			System.out.println("读取到字符串:"+str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}