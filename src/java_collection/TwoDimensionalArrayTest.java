package java_collection;

/**
 * 二维数组
 * @author 唐龙
 */
public class TwoDimensionalArrayTest {
	public static void main(String[] args) {
		String[][] content = new String[][] {
			{"张衡", "男", "九尺       ", "未知"}
			, {"曹操", "男", "七尺       ", "70kg"}
			, {"小红", "女", "168cm", "45kg"}
			, {"大绿", "女", "172cm", "55kg"}
			, {"李白", "男", "188cm", "70kg"}
			, {"刘扬", "男", "178cm", "65kg"}
			, {"貂蝉", "女", "171cm", "53kg"}
		};
		//遍历
		int i,j;
		for(i=0;i<content.length;i++){
			for(j=0;j<content[i].length;j++){
				System.out.printf("[%d,%d]:%s",i,j,content[i][j]+", ");
			}
			System.out.println();
		}
	}
}