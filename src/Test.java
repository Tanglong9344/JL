import java.util.Random;

public class Test {
	final static int NUM = 4;//设置抽奖号码的字符个数
	public static void main(String[] args) {
		Random rd = new Random();//创建Random对象
		String str = "";
		int i;
		//连续生成4个范围在0和1之间的随机数
		for (i = 0; i < NUM; i++) {
			String s = rd.nextInt(2) + "";
			str = str + randomSelection(s);
		}
		System.out.println("您的抽奖符号为：" + str);
		System.out.println(drawaLottery(str));
	}

	//根据随机数获取相应的符号
	public static String randomSelection(String str) {
		//1：表示实体五角星；0：表示空心五角星
		if (str.equals("1")) {
			return "★";
		} else {
			return "☆";
		}
	}

	//根据生成的符号来兑奖
	public static String drawaLottery(String str) {
		switch(str){
		case "★★★★":
			return "恭喜您抽取了本次活动的一等奖，奖励人民币100万元";
		case "★★★☆":
			return "祝贺您抽取了本次活动的二等奖，奖励人民币10万元";
		case "★★☆☆":
			return "祝贺您抽取了本次活动的三等奖，奖励人民币1万元";
		case "★☆☆☆":
			return "祝贺您抽取了本次活动的鼓励奖，奖励人民币100元";
		default:
			return "谢谢参与！";
		}
	}
}