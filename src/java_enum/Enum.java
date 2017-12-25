package java_enum;

import java.util.Arrays;

/**
 * JavaÃ¶¾Ù
 *
 * @author ÌÆÁú
 */
public class Enum {
	public static void main(String[] args) {
		Season[] seasons = Season.values();
		System.out.println("ËÄ¼¾£º" + Arrays.toString(seasons));

		//²âÊÔ
		for(Season s:seasons){
			switch(s){
			case ´º¼¾:
				System.out.println(s.ordinal() + ":" + s.toString() + "£¬Õ§Å¯»¹º®£¬ÍòÎï¸´ËÕ¡£");
				break;
			case ÏÄ¼¾:
				System.out.println(s.ordinal() + ":" + s.toString() + "£¬ÁÒÈÕÑ×Ñ×£¬ÂÌÊ÷´ĞÈÙ¡£");
				break;
			case Çï¼¾:
				System.out.println(s.ordinal() + ":" + s.toString() + "£¬Çï¸ßÆøË¬£¬Ë¶¹ûÀÛÀÛ¡£");
				break;
			case ¶¬¼¾:
				System.out.println(s.ordinal() + ":" + s.toString() + "£¬´óÑ©·×·É£¬Ò»Ö¦¶ÀĞã¡£");
				break;
			default:
				break;
			}
		}
	}
}

/**Ã¶¾Ù*/
enum Season{´º¼¾, ÏÄ¼¾, Çï¼¾, ¶¬¼¾;}