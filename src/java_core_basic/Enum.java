package java_core_basic;

import java.util.Arrays;

/**
 * Java枚举
 * @author 唐龙
 */
public class Enum {
	public static void main(String[] args) {
		Season[] seasons = Season.values();
		System.out.println("四季：" + Arrays.toString(seasons));

		System.out.println("星期：" + Arrays.toString(Weekend.values()));
		//测试
		for(Season s:seasons){
			switch(s){
			case 春季:
				System.out.println(s.ordinal() + ":" + s.toString() + "，乍暖还寒，万物复苏。");
				break;
			case 夏季:
				System.out.println(s.ordinal() + ":" + s.toString() + "，烈日炎炎，绿树葱荣。");
				break;
			case 秋季:
				System.out.println(s.ordinal() + ":" + s.toString() + "，秋高气爽，硕果累累。");
				break;
			case 冬季:
				System.out.println(s.ordinal() + ":" + s.toString() + "，大雪纷飞，一枝独秀。");
				break;
			default:
				System.out.println("有意外情况发生。");
				break;
			}
		}
	}
}

//枚举
enum Season{春季,夏季,秋季,冬季}
enum Weekend{星期日,星期一,星期二,星期三,星期四,星期五,星期六}