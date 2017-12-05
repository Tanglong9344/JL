package java_core_basic;

/**
 * Java标签
 * @author 唐龙
 */
public class LoopWithTag {
	public static void main(String[] args) throws InterruptedException {
		int i=0;
		outer:
			for(;;){
				System.out.println("外层循环。");
				while(true){
					System.out.println("内层循环。");
					Thread.sleep(1000);
					i++;
					if(0 == i%5){
						continue outer;
					}
				}
			}
	}
}