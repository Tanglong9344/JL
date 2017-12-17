package design_mode;

/**
 * 原型模式
 * 用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象。
 * (从一个对象在创建另外一个可定制的对象，而且不需要知道任何创建的细节)
 *
 * @author 唐龙
 *
 */
public class PrototypeMode {
	// This is a test
	public static void main(String[] args) {
		SpecificPrototype s=new SpecificPrototype("1");
		System.out.println("id="+s.getId());
		SpecificPrototype sClone=(SpecificPrototype)s.clone();
		System.out.println("idClone="+sClone.getId());
		System.out.println("s==sClone:"+String.valueOf(s==sClone));
	}
}

//原型接口
abstract class Prototype{
	private String id;
	public Prototype(String id){
		this.id=id;
	}

	public String getId() {
		return id;
	}

	//抽象克隆方法
	@Override
	public abstract Prototype clone();
}

//具体原型类
class SpecificPrototype extends Prototype{
	public SpecificPrototype(String id) {
		super(id);
	}
	@Override
	public Prototype clone() {
		//新建一个对象并复制当前对象的非静态变量
		return new SpecificPrototype(this.getId());
	}
}