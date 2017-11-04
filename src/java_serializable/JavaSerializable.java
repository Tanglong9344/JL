/**
 * Java ���л�
 * ʵ�� Serializable �ӿ�
 */

package java_serializable;

import java.io.Serializable;
import java.util.Arrays;

import java_common.TimeNow;

public class JavaSerializable implements Serializable{
	//This is a test
	public static void main(String[] args) {
		SerializeHelper sh = new SerializeHelper();
		JavaSerializable js = new JavaSerializable("���л�1",TimeNow.getTimeNow());
		//���л�
		byte[] serializableObject=sh.Serialize(js);
		System.out.println("name��"+js.getName()+",time:"+js.getTime());
		System.out.println("���л������");
		System.out.println(Arrays.toString(serializableObject));

		System.out.println("---------------------------");
		//�����л�
		JavaSerializable deserializableObject = (JavaSerializable) sh.deSerialize(serializableObject);
		System.out.println(Arrays.toString(serializableObject));
		System.out.println("�����л������");
		System.out.println("name��"+deserializableObject.getName()+",time:"+deserializableObject.getTime());
	}

	private static final long serialVersionUID = 1L;
	private String name;//����
	private String time;//ʱ��

	//getter and setter
	public JavaSerializable(String name,String time){
		this.name=name;
		this.time=time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
