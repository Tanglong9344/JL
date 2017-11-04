/**
 * ���л��ͷ����л�����
 */

package java_serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeHelper {
	//���л�
	public byte[] Serialize(Object object) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			//������д�뵽�ֽ������н������л�
			objectOutputStream.writeObject(object);
			return byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	//�����л�
	public Object deSerialize(byte[] bytes) {
		//�����������鵼���ֽ���������
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		try {
			//���ֽ�������ת��Ϊ����
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