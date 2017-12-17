package design_mode;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式(生成器模式)
 * 将一个复杂对象的构建与它的表示分离
 * 使得同样的构建过程可以创建不同的表示。
 *
 * 用户只需要指定需要建造的类型而不需要知道具体的建造过程和细节。
 *
 * @author 唐龙
 *
 */
public class BuilderMode {
	//This is a test
	public static void main(String[] args) {
		//指挥者
		Director director=new Director();
		//建造器A
		SpecificBuilderA builderA = new SpecificBuilderA();
		//建造
		director.construct(builderA);
		//获取产品
		Product productA=builderA.getProduct();
		//显示产品信息
		productA.show();

		//建造器B
		SpecificBuilderB builderB = new SpecificBuilderB();
		//建造
		director.construct(builderB);
		//获取产品
		Product productB=builderB.getProduct();
		//显示产品信息
		productB.show();
	}
}

//产品类
class Product{
	//产品配件
	List<String> parts = new ArrayList<String>();

	//添加配件
	public void Add(String part){
		parts.add(part);
	}
	//显示所有配件信息
	public void show(){
		parts.forEach(p->System.out.println(p));
	}
}

//建造接口
interface Builder{
	public void buildPartA();
	public void buildPartB();
	public Product getProduct();
}

//具体建造类A
class SpecificBuilderA implements Builder{
	private Product product = new Product();
	@Override
	public void buildPartA() {
		product.Add("部件A");
	}

	@Override
	public void buildPartB() {
		product.Add("部件AA");
	}

	@Override
	public Product getProduct() {
		System.out.println("产品A：");
		return product;
	}
}

//具体建造类B
class SpecificBuilderB implements Builder{
	private Product product = new Product();
	@Override
	public void buildPartA() {
		product.Add("部件B");
	}

	@Override
	public void buildPartB() {
		product.Add("部件BB");
	}

	@Override
	public Product getProduct() {
		System.out.println("产品B：");
		return product;
	}
}

/**
 * 指挥者类
 * 用于指挥建造过程
 */
class Director{
	public void construct(Builder builder){
		builder.buildPartA();
		builder.buildPartB();
	}
}