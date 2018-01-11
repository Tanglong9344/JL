package java_serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import java_common.TimeNow;

/**
 * 序列化和反序列化方法
 *
 * @author 唐龙
 */
public class SerializeToArray {
	public static void main(String[] args) {
		SerializeToArray sh = new SerializeToArray();
		SerializableObject js = new SerializableObject("序列化:",TimeNow.TIME_NOW);

		//序列化
		byte[] serializableObject=sh.Serialize(js);
		System.out.println("序列化之前：\n"+js.toString());
		System.out.println("序列化之后：\n"+Arrays.toString(serializableObject));
		System.out.println("---------------------------");

		//反序列化
		SerializableObject deserializableObject = (SerializableObject)sh.deSerialize(serializableObject);
		System.out.println("反序列化之前："+Arrays.toString(serializableObject));
		System.out.println("反序列化之后："+deserializableObject.toString());
	}

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