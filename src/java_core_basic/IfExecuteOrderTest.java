package java_core_basic;

/**
 * ����if��ִ��˳��
 * @author ����
 */
public class IfExecuteOrderTest {
	public static void main(String[] args) {
		int i=0;
		//Ԥ�ڽ����ABDCBDCB
		for(test('A');test('B')&&i<2;i++,test('C')){
			test('D');
		}
	}

	//���Ժ���
	static boolean test(char ch){
		System.out.print(ch);
		return true;
	}
}