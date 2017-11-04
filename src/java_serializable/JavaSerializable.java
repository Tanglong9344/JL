/**
 * Java 序列化
 * 实现 Serializable 接口
 */

package java_serializable;

import java.io.Serializable;
import java.util.Arrays;

import java_common.TimeNow;

public class JavaSerializable implements Serializable{
	//This is a test
	public static void main(String[] args) {
		SerializeHelper sh = new SerializeHelper();
		JavaSerializable js = new JavaSerializable("序列化1",TimeNow.getTimeNow());
		//序列化
		byte[] serializableObject=sh.Serialize(js);
		System.out.println("name："+js.getName()+",time:"+js.getTime());
		System.out.println("序列化结果：");
		System.out.println(Arrays.toString(serializableObject));

		System.out.println("---------------------------");
		//反序列化
		JavaSerializable deserializableObject = (JavaSerializable) sh.deSerialize(serializableObject);
		System.out.println(Arrays.toString(serializableObject));
		System.out.println("反序列化结果：");
		System.out.println("name："+deserializableObject.getName()+",time:"+deserializableObject.getTime());
	}

	private static final long serialVersionUID = 1L;
	private String name;//名称
	private String time;//时间

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
