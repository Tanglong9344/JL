package java_collection;

public class TwoDimensionalArrayTest {
	public static void main(String[] args) {
		String[][] content = new String[][] {
			  { "ÕÅºâ", "ÄÐ", "¾Å³ß ", "Î´Öª" }
			, { "²Ü²Ù", "ÄÐ", "Æß³ß ", "70kg" }
			, { "Ð¡ºì", "Å®", "168cm", "45kg" }
			, { "´óÂÌ", "Å®", "172cm", "55kg" }
			, { "Àî°×", "ÄÐ", "188cm", "70kg" }
			, { "Áõ·ÉÑï", "ÄÐ", "178cm", "65kg" }
			, { "õõ²õ", "Å®", "171cm", "53kg" }
			};
			for(int i=0;i<content.length;i++){
				for(int j=0;j<content[i].length;j++){
					System.out.printf("[%d,%d]:%s",i,j,content[i][j]+", ");
				}
				System.out.println();
			}
	}
}
