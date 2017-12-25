package java_serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ���л��ͷ����л�����
 *
 * @author ����
 */
public class SerializeHelper {
	//���л�����
	public byte[] Serialize(Object object) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			//������д�뵽�ֽ������н������л�
			oos.writeObject(object);
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	//�����л�����
	public Object deSerialize(byte[] bytes) {
		//�����������鵼���ֽ���������
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		try {
			//���ֽ�������ת��Ϊ����
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