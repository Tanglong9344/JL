import java.util.Random;

public class Test {
	final static int NUM = 4;//���ó齱������ַ�����
	public static void main(String[] args) {
		Random rd = new Random();//����Random����
		String str = "";
		int i;
		//��������4����Χ��0��1֮��������
		for (i = 0; i < NUM; i++) {
			String s = rd.nextInt(2) + "";
			str = str + randomSelection(s);
		}
		System.out.println("���ĳ齱����Ϊ��" + str);
		System.out.println(drawaLottery(str));
	}

	//�����������ȡ��Ӧ�ķ���
	public static String randomSelection(String str) {
		//1����ʾʵ������ǣ�0����ʾ���������
		if (str.equals("1")) {
			return "��";
		} else {
			return "��";
		}
	}

	//�������ɵķ������ҽ�
	public static String drawaLottery(String str) {
		switch(str){
		case "�����":
			return "��ϲ����ȡ�˱��λ��һ�Ƚ������������100��Ԫ";
		case "�����":
			return "ף������ȡ�˱��λ�Ķ��Ƚ������������10��Ԫ";
		case "�����":
			return "ף������ȡ�˱��λ�����Ƚ������������1��Ԫ";
		case "�����":
			return "ף������ȡ�˱��λ�Ĺ����������������100Ԫ";
		default:
			return "лл���룡";
		}
	}
}