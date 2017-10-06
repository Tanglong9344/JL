package java_core_basic;

public class ObjectClone {
	public static void main(String[] args) throws CloneNotSupportedException{
		A a1 = new A(1);

		//自比
		a1.compare(a1);
		//clone()
		a1.compare(a1.clone());
		//新建对象
		a1.compare(new A(2));
	}
}

//测试类
//必须实现接口Cloneable
class A implements Cloneable{
	private int num;

	public A(int num){
		this.num = num;
	}

	/**
	 * override clone
	 * @throws CloneNotSupportedException
	 */
	@Override
	public Object clone() throws CloneNotSupportedException{
		Object obj = super.clone();
		return obj;
	}

	/**
	 * override equals
	 */
	@Override
	public boolean equals(Object o){
		if(o instanceof A){
			return (((A)o).num == num);
		}

		return false;
	}

	/**
	 * 对象比较
	 * @param a2
	 */
	public void compare(Object o){
		//对象比较
		if(this == o){
			System.out.println(this.toString().split("@")[1]+ "和" + o.toString().split("@")[1] + "引用同一对象。");
		}else{
			System.out.println(this.toString().split("@")[1] + "和" + o.toString().split("@")[1] + "引用不同对象。");
		}
		//内容比较
		if(this.equals(o)){
			System.out.println(this.toString().split("@")[1] + "和" + o.toString().split("@")[1] + "中内容相同。");
		}else{
			System.out.println(this.toString().split("@")[1] + "和" + o.toString().split("@")[1] + "中内容不同。");
		}
		System.out.println("------------------------------");
	}
}

/* 测试结果
	15db9742和15db9742引用同一对象。
	15db9742和15db9742中内容相同。
	------------------------------
	15db9742和6d06d69c引用不同对象。
	15db9742和6d06d69c中内容相同。
	------------------------------
	15db9742和7852e922引用不同对象。
	15db9742和7852e922中内容不同。
	------------------------------
 */