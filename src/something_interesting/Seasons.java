package something_interesting;

public class Seasons {
	public static void main(String args[]) {
		int m = (int) (Math.random() * 12) + 1;// ����m������ʾ�·�
		System.out.println(m);
		String s;// s��ʾ����
		switch (m) {
		case 12:
		case 1:
		case 2:
			s = "Winter"; // ����
			break;
		case 3:
		case 4:
		case 5:
			s = "Spring"; // ����
			break;
		case 6:
		case 7:
		case 8:
			s = "Summer"; // �ļ�
			break;
		case 9:
		case 10:
		case 11:
			s = "Autumn"; // �＾
			break;
		default:
			s = "Something strange comes."; // �·ݳ�����Χ
		}
		System.out.println("It is " + s + ".");
	}
}
