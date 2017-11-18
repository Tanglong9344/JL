package java_generic;

/**
 * ������
 * @author ����
 * @param <T>
 * @param <V>
 */
public class GenericClass<T,V> {
	T t;
	V v;
	//�������Ͳ���
	GenericClass(T t1, V v1) {
		t = t1;
		v = v1;
	}
	// ��ʾT��V������
	void printTypes() {
		System.out.println("����T�Ķ�������Ϊ:" + t.getClass().getName());
		System.out.println("����V�Ķ�������Ϊ:" + v.getClass().getName());
	}

	T getT() {
		return t;
	}

	V getV() {
		return v;
	}

	//����
	public static void main(String args[]) {
		// ָ�����Ͳ�����ʵ������
		GenericClass<Integer,Double> tv= new GenericClass<Integer,Double>(100,12.56);
		tv.printTypes();
		System.out.println("T�����е�ֵΪ:" + tv.getT());
		System.out.println("V�����е�ֵΪ:" + tv.getV());
	}
}