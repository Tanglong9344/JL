package java_effective_constructor;

/**
 * Java Bean
 * 使用getter和setter传递数据
 * 解决层叠构造器可读性较差的问题
 *
 * 缺点：调用较多，易产生不一致的问题
 * 解决方案：Builder 方式
 * @author 唐龙
 */
public class JavaBeanConstructor {
	private String name;           //required
	private String sex     = "未知";//optional
	private String age     = "未知";//optional
	private String address = "未知";//optional

	@Override
	public String toString(){
		return "Name:" + name + ",Sex:" + sex + ",Age:" + age + ",Addr:" + address;
	}

	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}