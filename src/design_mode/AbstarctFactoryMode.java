/**
 * 抽象工厂模式
 * 提供一个创建一系列相关或互相依赖对象的接口，而无需指定它们具体的类
 *
 * 优点：
 * 1，易于交换产品系列，由于具体工厂类在一个应用中只需要在初始化的时候出现一次这就
 * 使得改变一个应用的具体工厂变得非常容易，只需要改变具体工厂即可使用不同的产品配置
 *
 * 2，让具体的实例创建过程与客户端分离，客户端通过他们的抽象接口操纵实例，
 * 产品的具体类名也被具体工厂的实现分离
 *
 * 使用抽象工厂模式实现简单的数据切换
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

//用户接口
interface User{
	//插入
	void insert(User user);
	//根据id获取用户
	User getUser(int id);
}

//访问Mysql数据库User表
class MysqlUser implements User{
	@Override
	public void insert(User user) {
		System.out.println("Mysql 插入数据");
	}

	@Override
	public User getUser(int id) {
		System.out.println("Mysql获取id为"+id+"的数据");
		return null;
	}
}

//访问Orcal数据库User表
class OrcalUser implements User{
	@Override
	public void insert(User user) {
		System.out.println("Orcal 插入数据");
	}

	@Override
	public User getUser(int id) {
		System.out.println("Orcal获取数据id为"+id+"的数据");
		return null;
	}
}

//工厂接口
interface AccessFactory{
	User createUser();
}

//Mysql工厂实现类
class MysqlAccessFactory implements AccessFactory{
	@Override
	public User createUser() {
		return new MysqlUser();
	}
}

//Orcal工厂实现类
class OrcalAccessFactory implements AccessFactory{
	@Override
	public User createUser() {
		return new OrcalUser();
	}
}