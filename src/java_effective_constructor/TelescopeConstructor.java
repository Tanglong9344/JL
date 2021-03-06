package java_effective_constructor;

/**
 * 重叠构造器
 *
 * 此类有四个属性，其中第一个是必须的其它是可选的
 * 采用层次递进的方式进行实例化
 *
 * 缺点：当参数较多时，可读性会变得很差，易于出错
 * 解决办法，JavaBean(使用getter和setter方法)
 *
 * @author 唐龙
 */
public class TelescopeConstructor {
	private String name;   //required
	private String sex;    //optional
	private String age;    //optional
	private String address;//optional

	/**一个参数*/
	public TelescopeConstructor(String name){
		this(name,"未知");
	}

	/**两个参数*/
	public TelescopeConstructor(String name,String sex){
		this(name,sex,"未知");
	}

	/**三个参数*/
	public TelescopeConstructor(String name,String sex,String age){
		this(name,sex,age,"未知");
	}

	/**全部参数*/
	public TelescopeConstructor(String name,String sex,String age,String address){
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString(){
		return "Name:" + name + ",Sex:" + sex + ",Age:" + age + ",Addr:" + address;
	}
}