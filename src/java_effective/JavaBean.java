package java_effective;

/**
 * Java Bean
 * ʹ��getter��setter��������
 * �������������ɶ��Խϲ������
 * @author ����
 */
public class JavaBean {
	private String name = "δ֪";   //required
	private String sex = "δ֪";    //optional
	private String age = "δ֪";    //optional
	private String address = "δ֪";//optional

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