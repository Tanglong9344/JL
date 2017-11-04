/**
 * 序列化和反序列化方法
 */

package java_serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeHelper {
	//序列化
	public byte[] Serialize(Object object) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			//将对象写入到字节数组中进行序列化
			objectOutputStream.writeObject(object);
			return byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	//反序列化
	public Object deSerialize(byte[] bytes) {
		//将二进制数组导入字节数据流中
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		try {
			//将字节数组流转化为对象
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			return objectInputStream.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}