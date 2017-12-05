package java_core_basic;

/**
 * ��̬��ʼ��ִ��˳��
 * ��Ŵ���ִ�д���
 * @author ����
 */
public class InitStaticBlock {
	public static void main(String[] args) {
		System.out.println("main()");//10
		Tools.t1.f(1);//11
		System.out.println("��һ��ִ�н�����\n");
		Tools.t1.f(1);
		System.out.println("�ڶ���ִ�н�����");
	}
}

/**
 * ��̬��ʼ���������
 */
class Tools{
	static Tool t1 = new Tool(1);//1
	static{
		System.out.println("���뾲̬��ʼ���飺");//2
		t1 = new Tool(11);//3
		t3 = new Tool(33);//4
		t2 = new Tool(22);//5
		System.out.println("�˳���̬��ʼ���顣");//6
	}
	static Tool t2 = new Tool(2);//7
	Tools(){
		System.out.println("Tools()");//9
	}
	static Tool t3 = new Tool(3);//8
}

/**
 * ��̬��ʼ�����������
 */
class Tool{
	Tool(int i){
		System.out.println("Tool(" + i +")");
	}
	void f(int i){
		System.out.println("f(" + i +")");
	}
}