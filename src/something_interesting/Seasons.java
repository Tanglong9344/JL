package something_interesting;

public class Seasons {
	public static void main(String args[]) {
		int m = (int) (Math.random() * 12) + 1;// 这里m变量表示月份
		System.out.println(m);
		String s;// s表示季节
		switch (m) {
		case 12:
		case 1:
		case 2:
			s = "Winter"; // 冬季
			break;
		case 3:
		case 4:
		case 5:
			s = "Spring"; // 春季
			break;
		case 6:
		case 7:
		case 8:
			s = "Summer"; // 夏季
			break;
		case 9:
		case 10:
		case 11:
			s = "Autumn"; // 秋季
			break;
		default:
			s = "Something strange comes."; // 月份超出范围
		}
		System.out.println("It is " + s + ".");
	}
}
