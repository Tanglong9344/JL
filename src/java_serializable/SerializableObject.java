package java_serializable;

import java.io.Serializable;

/**
 * Java 序列化对象
 *
 * 实现 Serializable 接口
 *
 * @author 唐龙
 */
public class SerializableObject implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;//名称
	private String time;//时间

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