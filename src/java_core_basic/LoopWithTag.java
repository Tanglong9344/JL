package java_core_basic;

/**
 * Java��ǩ
 * @author ����
 */
public class LoopWithTag {
	public static void main(String[] args) throws InterruptedException {
		int i=0;
		outer:
			for(;;){
				System.out.println("���ѭ����");
				while(true){
					System.out.println("�ڲ�ѭ����");
					Thread.sleep(1000);
					i++;
					if(0 == i%5){
						continue outer;
					}
				}
			}
	}
}