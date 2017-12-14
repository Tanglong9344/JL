package java_effective_constructor;

/**
 * ���������
 *
 * �������ĸ����ԣ����е�һ���Ǳ���������ǿ�ѡ��
 * ���ò�εݽ��ķ�ʽ����ʵ����
 *
 * ȱ�㣺�������϶�ʱ���ɶ��Ի��úܲ���ڳ���
 * ����취��JavaBean(ʹ��getter��setter����)
 *
 * @author ����
 */
public class TelescopeStructor {
	private String name;   //required
	private String sex;    //optional
	private String age;    //optional
	private String address;//optional

	/**һ������*/
	public TelescopeStructor(String name){
		this(name,"δ֪");
	}

	/**��������*/
	public TelescopeStructor(String name,String sex){
		this(name,sex,"δ֪");
	}

	/**��������*/
	public TelescopeStructor(String name,String sex,String age){
		this(name,sex,age,"δ֪");
	}

	/**ȫ������*/
	public TelescopeStructor(String name,String sex,String age,String address){
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