package java_collection;

/**
 * ��ά����
 * @author ����
 */
public class TwoDimensionalArrayTest {
	public static void main(String[] args) {
		String[][] content = new String[][] {
			{"�ź�", "��", "�ų�       ", "δ֪"}
			, {"�ܲ�", "��", "�߳�       ", "70kg"}
			, {"С��", "Ů", "168cm", "45kg"}
			, {"����", "Ů", "172cm", "55kg"}
			, {"���", "��", "188cm", "70kg"}
			, {"����", "��", "178cm", "65kg"}
			, {"����", "Ů", "171cm", "53kg"}
		};
		//����
		int i,j;
		for(i=0;i<content.length;i++){
			for(j=0;j<content[i].length;j++){
				System.out.printf("[%d,%d]:%s",i,j,content[i][j]+", ");
			}
			System.out.println();
		}
	}
}