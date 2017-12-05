package java_core_basic;

/**
 * Java Clone
 * @author ����
 */
public class ObjectClone {
	public static void main(String[] args) throws CloneNotSupportedException{
		A a1 = new A(1);
		//�Ա�
		a1.compare(a1);
		//clone()
		a1.compare(a1.clone());
		//�½�����
		a1.compare(new A(2));
	}
}

//������
//����ʵ�ֽӿ�Cloneable
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
	 * ����Ƚ�
	 * @param a2
	 */
	public void compare(Object o){
		//����Ƚ�
		if(this == o){
			System.out.println(this.toString().split("@")[1]+ "��" + o.toString().split("@")[1] + "����ͬһ����");
		}else{
			System.out.println(this.toString().split("@")[1] + "��" + o.toString().split("@")[1] + "���ò�ͬ����");
		}
		//���ݱȽ�
		if(this.equals(o)){
			System.out.println(this.toString().split("@")[1] + "��" + o.toString().split("@")[1] + "��������ͬ��");
		}else{
			System.out.println(this.toString().split("@")[1] + "��" + o.toString().split("@")[1] + "�����ݲ�ͬ��");
		}
		System.out.println("------------------------------");
	}
}