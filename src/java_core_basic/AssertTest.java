package java_core_basic;

/**
 * eclipse Ĭ�Ϲرն��ԣ�ʹ��ǰ��Ҫ�ȿ�������
 * @http://jingyan.baidu.com/article/6f2f55a156b2d0b5b93e6cc2.html
 */
public class AssertTest {
	public static void main(String[] args) {
		final int N = 10;
		int num;
		for(int i = 0;i < N;i++){
			num = (int)(Math.random()*100);
			// assert boolean,Ϊ��true����ִ�У�Ϊfalse ����java.lang.AssertionError
			assert 0 == num % 2 ? true : false;
			System.out.println("�������" + num);
		}
	}
}