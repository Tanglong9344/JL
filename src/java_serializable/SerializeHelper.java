package java_serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化和反序列化方法
 *
 * @author 唐龙
 */
public class SerializeHelper {
	//序列化方法
	public byte[] Serialize(Object object) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			//将对象写入到字节数组中进行序列化
			oos.writeObject(object);
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	//反序列化方法
	public Object deSerialize(byte[] bytes) {
		//将二进制数组导入字节数据流中
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		try {
			//将字节数组流转化为对象
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}