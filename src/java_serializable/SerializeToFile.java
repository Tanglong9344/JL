package java_serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java_common.TimeNow;

/**
 * 序列化对象并存储到文件
 *
 * @author 唐龙
 *
 */
public class SerializeToFile {
	public static void main(String[] args) throws IOException {
		String file = "src/java_serializable/SerializeObject.txt";
		SerializableObject so = new SerializableObject("Tanglong", TimeNow.TIME_NOW);
		System.out.println("对象：\n" + so);

		// 序列化
		serializeFile(file, so);

		// 反序列化
		so = deserializeFile(file);
		System.out.println("反序列化：\n" + so.toString());
	}

	/**serialize to a file
	 * @throws IOException */
	private static <O> void serializeFile(String file, O o) throws IOException {
		FileOutputStream fos = null;
		ObjectOutputStream oo = null;
		try {
			fos = new FileOutputStream(file);
			oo  = new ObjectOutputStream(fos);
			oo.writeObject(o);
			oo.flush();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(fos != null) {
				fos.close();
			}
			if(oo != null) {
				oo.close();
			}
		}
	}

	/** deserialize from a file
	 * @throws IOException */
	@SuppressWarnings("unchecked")
	private static <O> O deserializeFile(String file) throws IOException {
		FileInputStream fis = null;
		ObjectInputStream oi = null;
		O o = null;
		try {
			fis = new FileInputStream(file);
			oi  = new ObjectInputStream(fis);
			o   = (O) oi.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				fis.close();
			}
			if(oi != null) {
				oi.close();
			}
		}
		return o;
	}
}