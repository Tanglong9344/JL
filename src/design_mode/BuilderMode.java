package design_mode;

import java.util.ArrayList;
import java.util.List;

/**
 * ������ģʽ(������ģʽ)
 * ��һ�����Ӷ���Ĺ��������ı�ʾ����
 * ʹ��ͬ���Ĺ������̿��Դ�����ͬ�ı�ʾ��
 *
 * �û�ֻ��Ҫָ����Ҫ��������Ͷ�����Ҫ֪������Ľ�����̺�ϸ�ڡ�
 *
 * @author ����
 *
 */
public class BuilderMode {
	//This is a test
	public static void main(String[] args) {
		//ָ����
		Director director=new Director();
		//������A
		SpecificBuilderA builderA = new SpecificBuilderA();
		//����
		director.construct(builderA);
		//��ȡ��Ʒ
		Product productA=builderA.getProduct();
		//��ʾ��Ʒ��Ϣ
		productA.show();

		//������B
		SpecificBuilderB builderB = new SpecificBuilderB();
		//����
		director.construct(builderB);
		//��ȡ��Ʒ
		Product productB=builderB.getProduct();
		//��ʾ��Ʒ��Ϣ
		productB.show();
	}
}

//��Ʒ��
class Product{
	//��Ʒ���
	List<String> parts = new ArrayList<String>();

	//������
	public void Add(String part){
		parts.add(part);
	}
	//��ʾ���������Ϣ
	public void show(){
		parts.forEach(p->System.out.println(p));
	}
}

//����ӿ�
interface Builder{
	public void buildPartA();
	public void buildPartB();
	public Product getProduct();
}

//���彨����A
class SpecificBuilderA implements Builder{
	private Product product = new Product();
	@Override
	public void buildPartA() {
		product.Add("����A");
	}

	@Override
	public void buildPartB() {
		product.Add("����AA");
	}

	@Override
	public Product getProduct() {
		System.out.println("��ƷA��");
		return product;
	}
}

//���彨����B
class SpecificBuilderB implements Builder{
	private Product product = new Product();
	@Override
	public void buildPartA() {
		product.Add("����B");
	}

	@Override
	public void buildPartB() {
		product.Add("����BB");
	}

	@Override
	public Product getProduct() {
		System.out.println("��ƷB��");
		return product;
	}
}

/**
 * ָ������
 * ����ָ�ӽ������
 */
class Director{
	public void construct(Builder builder){
		builder.buildPartA();
		builder.buildPartB();
	}
}