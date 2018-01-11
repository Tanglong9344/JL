package java_serializable;

import java.io.Serializable;

/**
 * Java ���л�����
 *
 * ʵ�� Serializable �ӿ�
 *
 * @author ����
 */
public class SerializableObject implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;//����
	private String time;//ʱ��

	@Override
	public String toString(){
		return "Name: " + name + "\nTime: " + time;
	}

	public SerializableObject(){}

	public SerializableObject(String name,String time){
		this.name=name;
		this.time=time;
	}

	//getter and setter
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