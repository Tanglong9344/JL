/**
 * ���󹤳�ģʽ
 * �ṩһ������һϵ����ػ�����������Ľӿڣ�������ָ�����Ǿ������
 *
 * �ŵ㣺
 * 1�����ڽ�����Ʒϵ�У����ھ��幤������һ��Ӧ����ֻ��Ҫ�ڳ�ʼ����ʱ�����һ�����
 * ʹ�øı�һ��Ӧ�õľ��幤����÷ǳ����ף�ֻ��Ҫ�ı���幤������ʹ�ò�ͬ�Ĳ�Ʒ����
 *
 * 2���þ����ʵ������������ͻ��˷��룬�ͻ���ͨ�����ǵĳ���ӿڲ���ʵ����
 * ��Ʒ�ľ�������Ҳ�����幤����ʵ�ַ���
 *
 * ʹ�ó��󹤳�ģʽʵ�ּ򵥵������л�
 */

package design_mode;

public class AbstarctFactoryMode {
	//This is a test
	public static void main(String[] args) {
		User user;
		//Mysql
		AccessFactory AccessFactory1=new MysqlAccessFactory();
		user=AccessFactory1.createUser();
		user.insert(user);
		user.getUser(110);

		//Orcal
		AccessFactory AccessFactory2=new OrcalAccessFactory();
		user=AccessFactory2.createUser();
		user.insert(user);
		user.getUser(110);

	}
}

//�û��ӿ�
interface User{
	//����
	void insert(User user);
	//����id��ȡ�û�
	User getUser(int id);
}

//����Mysql���ݿ�User��
class MysqlUser implements User{
	@Override
	public void insert(User user) {
		System.out.println("Mysql ��������");
	}

	@Override
	public User getUser(int id) {
		System.out.println("Mysql��ȡidΪ"+id+"������");
		return null;
	}
}

//����Orcal���ݿ�User��
class OrcalUser implements User{
	@Override
	public void insert(User user) {
		System.out.println("Orcal ��������");
	}

	@Override
	public User getUser(int id) {
		System.out.println("Orcal��ȡ����idΪ"+id+"������");
		return null;
	}
}

//�����ӿ�
interface AccessFactory{
	User createUser();
}

//Mysql����ʵ����
class MysqlAccessFactory implements AccessFactory{
	@Override
	public User createUser() {
		return new MysqlUser();
	}
}

//Orcal����ʵ����
class OrcalAccessFactory implements AccessFactory{
	@Override
	public User createUser() {
		return new OrcalUser();
	}
}