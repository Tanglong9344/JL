package java_core_basic;

/**
 * Java ��ǩ
 *
 * @author ����
 */
public class LoopWithTag {
	public static void main(String[] args) throws InterruptedException {
		int i=0;
		outer:
			for(;;){
				System.err.println("���ѭ��...");
				Thread.sleep(10);//since err has no cache,so sleep 10ms
				while(true){
					System.out.println("�ڲ�ѭ��...");
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