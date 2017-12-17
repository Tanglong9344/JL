package design_mode;

/**
 * 模板方法模式
 * 定义一个操作中算法的骨架，而将一些实现步骤延迟到子类。
 * 模板方法使得子类可以不改变一个算法的结构即可重新定义该算法的某些特定步骤。
 *
 * 模板方法模式通过将一些不变行为迁移到超类
 * 去除掉子类中的重复代码。
 *
 * @author 唐龙
 *
 */
public class TemplateMethodMode {
	//This is a test
	public static void main(String[] args) {
		Template template=null;
		template=new SpecificTemplateA();
		template.templateMethod();

		template=new SpecificTemplateB();
		template.templateMethod();
	}
}

//抽象模板类
abstract class Template{
	//抽象方法A
	public abstract void primOperationA();
	//抽象方法B
	public abstract void primOperationB();
	//模板方法
	public void templateMethod(){
		primOperationA();
		primOperationB();
	}
}

//具体模板类A
class SpecificTemplateA extends Template{
	@Override
	public void primOperationA() {
		System.out.println("具体模板类A实现抽象方法A");
	}
	@Override
	public void primOperationB() {
		System.out.println("具体模板类A实现抽象方法B");
	}
}

//具体模板类B
class SpecificTemplateB extends Template{
	@Override
	public void primOperationA() {
		System.out.println("具体模板类B实现抽象方法A");
	}
	@Override
	public void primOperationB() {
		System.out.println("具体模板类B实现抽象方法B");
	}
}