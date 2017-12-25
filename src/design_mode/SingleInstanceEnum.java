package design_mode;

/**
 * ����ģʽ��ʹ��ö��ʵ��,����������Ϊ�����࣬��ֹʵ����
 * �ŵ㣺
 * 1.�̰߳�ȫ
 * 2.��ֹ����ǿ�е��ù�����
 * 3.�ṩ���Զ����л����ƣ���ֹ�����л���ʱ�򴴽��µ�ʵ��
 * @author ����
 */
public abstract class SingleInstanceEnum {
	private SingleInstanceEnum(){
		System.out.println("����ģʽ(enum)");
	}

	public static SingleInstanceEnum getInstance(){
		return Singleton.INSTANCE.getInstance();
	}

	/**��̬��������*/
	protected static class Sub extends SingleInstanceEnum{}

	/** ��̬�ڲ� enum */
	private static enum Singleton{
		INSTANCE;
		private final SingleInstanceEnum singleton;

		/** ���췽����JVM�ᱣ֤�˷�������ֻ����һ��*/
		private Singleton(){
			singleton = new SingleInstanceEnum.Sub();
		}

		/**����ʵ��*/
		public SingleInstanceEnum getInstance(){
			return singleton;
		}
	}
}