package java_native;

/**
 * native demo
 *
 * @author ����
 *
 */
public class NativeDemo {
	public static void main(String[] args){
		System.loadLibrary("NativeAddDemo");//������C���������ɵ�DLL�ļ���
		NativeAdd na = new NativeAdd();
		System.out.println("3 + 4 = " + na.add(3, 4));
	}
}