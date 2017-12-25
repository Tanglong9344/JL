package java_serializable;

import java.io.Serializable;
import java.util.Arrays;

import java_common.TimeNow;

/**
 * Java 序列化
 *
 * 实现 Serializable 接口
 *
 * @author 唐龙
 */
public class JavaSerializable implements Serializable{
	public static void main(String[] args) {
		SerializeHelper sh = new SerializeHelper();
		JavaSerializable js = new JavaSerializable("序列化:",TimeNow.TIME_NOW);

		//序列化
		byte[] serializableObject=sh.Serialize(js);
		System.out.println("序列化之前：\n"+js.toString());
		System.out.println("序列化之后：\n"+Arrays.toString(serializableObject));
		System.out.println("---------------------------");

		//反序列化
		JavaSerializable deserializableObject = (JavaSerializable)sh.deSerialize(serializableObject);
		System.out.println("反序列化之前："+Arrays.toString(serializableObject));
		System.out.println("反序列化之后："+deserializableObject.toString());
	}

	private static final long serialVersionUID = 1L;
	private String name;//名称
	private String time;//时间

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