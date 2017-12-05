package java_core_basic;

/**
 * 静态初始化执行顺序
 * 标号代表执行次序
 * @author 唐龙
 */
public class InitStaticBlock {
	public static void main(String[] args) {
		System.out.println("main()");//10
		Tools.t1.f(1);//11
		System.out.println("第一次执行结束。\n");
		Tools.t1.f(1);
		System.out.println("第二次执行结束。");
	}
}

/**
 * 静态初始化块测试类
 */
class Tools{
	static Tool t1 = new Tool(1);//1
	static{
		System.out.println("进入静态初始化块：");//2
		t1 = new Tool(11);//3
		t3 = new Tool(33);//4
		t2 = new Tool(22);//5
		System.out.println("退出静态初始化块。");//6
	}
	static Tool t2 = new Tool(2);//7
	Tools(){
		System.out.println("Tools()");//9
	}
	static Tool t3 = new Tool(3);//8
}

/**
 * 静态初始化块测试子类
 */
class Tool{
	Tool(int i){
		System.out.println("Tool(" + i +")");
	}
	void f(int i){
		System.out.println("f(" + i +")");
	}
}