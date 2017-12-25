package java_serializable;

import java.io.Serializable;
import java.util.Arrays;

import java_common.TimeNow;

/**
 * Java ���л�
 *
 * ʵ�� Serializable �ӿ�
 *
 * @author ����
 */
public class JavaSerializable implements Serializable{
	public static void main(String[] args) {
		SerializeHelper sh = new SerializeHelper();
		JavaSerializable js = new JavaSerializable("���л�:",TimeNow.TIME_NOW);

		//���л�
		byte[] serializableObject=sh.Serialize(js);
		System.out.println("���л�֮ǰ��\n"+js.toString());
		System.out.println("���л�֮��\n"+Arrays.toString(serializableObject));
		System.out.println("---------------------------");

		//�����л�
		JavaSerializable deserializableObject = (JavaSerializable)sh.deSerialize(serializableObject);
		System.out.println("�����л�֮ǰ��"+Arrays.toString(serializableObject));
		System.out.println("�����л�֮��"+deserializableObject.toString());
	}

	private static final long serialVersionUID = 1L;
	private String name;//����
	private String time;//ʱ��

	@Override
	public String toString(){
		return "name:"+name+",time:"+time;
	}
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