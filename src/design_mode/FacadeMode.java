/**
 * ���ģʽ
 * Ϊ��ϵͳ�е�һ��ӿ��ṩһ��һ�µĽ��档
 * ��ģʽ������һ���߲�ӿڣ�ʹ����ϵͳ��������ʹ�á�
 */

package design_mode;

public class FacadeMode {
	//This is a test
	public static void main(String[] args) {
		Facade facade = new Facade();
		facade.methodA();
		facade.methodB();
	}
}

//��ϵͳ��A
class SubSystemA{
	public void methodA(){
		System.out.println("��ϵͳA�ķ���A��");
	}
}

//��ϵͳ��B
class SubSystemB{
	public void methodB(){
		System.out.println("��ϵͳB�ķ���B��");
	}
}

//��ϵͳ��C
class SubSystemC{
	public void methodC(){
		System.out.println("��ϵͳC�ķ���C��");
	}
}

//�����
class Facade{
	SubSystemA subSystemA=null;
	SubSystemB subSystemB=null;
	SubSystemC subSystemC=null;

	//���췽����ʼ������
	public Facade(){
		subSystemA=new SubSystemA();
		subSystemB=new SubSystemB();
		subSystemC=new SubSystemC();
	}

	public void methodA(){
		System.out.println("\n������methodA()��\n----------------");
		subSystemA.methodA();
		subSystemB.methodB();
		System.out.println("---------------");
	}

	public void methodB(){
		System.out.println("\n������methodB()��\n----------------");
		subSystemA.methodA();
		subSystemC.methodC();
		System.out.println("---------------");
	}
}