package java_effective_constructor;

/**
 * ��̬��������ʵ������Ĳ�����
 * @author ����
 */
public class StaticFactoryConstructorTest {
	public static void main(String[] args) {
		//��̬����ʵ��������
		StaticFactoryConstructor sfc = StaticFactoryConstructor.newInstance();
		sfc.bye();
	}
}