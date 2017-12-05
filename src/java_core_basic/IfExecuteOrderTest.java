package java_core_basic;

/**
 * 检验if的执行顺序
 * @author 唐龙
 */
public class IfExecuteOrderTest {
	public static void main(String[] args) {
		int i=0;
		//预期结果：ABDCBDCB
		for(test('A');test('B')&&i<2;i++,test('C')){
			test('D');
		}
	}

	//测试函数
	static boolean test(char ch){
		System.out.print(ch);
		return true;
	}
}