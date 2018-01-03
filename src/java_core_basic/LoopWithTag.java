package java_core_basic;

/**
 * Java 标签
 *
 * @author 唐龙
 */
public class LoopWithTag {
	public static void main(String[] args) throws InterruptedException {
		int i=0;
		outer:
			for(;;){
				System.err.println("外层循环...");
				Thread.sleep(10);//since err has no cache,so sleep 10ms
				while(true){
					System.out.println("内层循环...");
					Thread.sleep(100);// sleep 100ms
					i++;
					if(i>9) {
						System.exit(0);
					}
					if(0 == i%3){
						continue outer;
					}
				}
			}
	}
}