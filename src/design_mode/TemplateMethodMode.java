package design_mode;

/**
 * ģ�巽��ģʽ
 * ����һ���������㷨�ĹǼܣ�����һЩʵ�ֲ����ӳٵ����ࡣ
 * ģ�巽��ʹ��������Բ��ı�һ���㷨�Ľṹ�������¶�����㷨��ĳЩ�ض����衣
 *
 * ģ�巽��ģʽͨ����һЩ������ΪǨ�Ƶ�����
 * ȥ���������е��ظ����롣
 *
 * @author ����
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

//����ģ����
abstract class Template{
	//���󷽷�A
	public abstract void primOperationA();
	//���󷽷�B
	public abstract void primOperationB();
	//ģ�巽��
	public void templateMethod(){
		primOperationA();
		primOperationB();
	}
}

//����ģ����A
class SpecificTemplateA extends Template{
	@Override
	public void primOperationA() {
		System.out.println("����ģ����Aʵ�ֳ��󷽷�A");
	}
	@Override
	public void primOperationB() {
		System.out.println("����ģ����Aʵ�ֳ��󷽷�B");
	}
}

//����ģ����B
class SpecificTemplateB extends Template{
	@Override
	public void primOperationA() {
		System.out.println("����ģ����Bʵ�ֳ��󷽷�A");
	}
	@Override
	public void primOperationB() {
		System.out.println("����ģ����Bʵ�ֳ��󷽷�B");
	}
}