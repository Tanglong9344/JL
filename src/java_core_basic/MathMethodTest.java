package java_core_basic;

public class MathMethodTest {
	public static void main(String[] args) {
		float f1 = 5.4f;
		float f2 = 5.5f;
		// 5.4�������뼴5
		System.out.println("5.4�������뼴5:" + Math.round(f1));
		// 5.5�������뼴6
		System.out.println("5.5�������뼴6:" + Math.round(f2));
		// �õ�һ��0-1֮��������������ȡ����1��
		System.out.println("�õ�һ��0-1֮��������������ȡ����1��:" + Math.random());
		// �õ�һ��0-10֮���������� ��ȡ����10��
		System.out.println("�õ�һ��0-10֮���������� ��ȡ����10��:" + (int) (Math.random() * 10));
		// ����
		System.out.println("9��ƽ����:" + Math.sqrt(9));
		// �η�2��4�η�
		System.out.println("2��4�η�:" + Math.pow(2, 4));
		// ��
		System.out.println("PI����:" + Math.PI);
		// ��Ȼ����
		System.out.println("E������" + Math.E);
	}
}
