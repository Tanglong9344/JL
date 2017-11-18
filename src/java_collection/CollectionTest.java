package java_collection;

public class CollectionTest {
	public static void main(String[] args) {
		//数组的局限性
		Hero heros[] = new Hero[10];
		//声明长度是10的数组
		//不用的数组就浪费了
		//超过10的个数，又放不下
		heros[0] = new Hero("盖伦");
		//放不下要报错
		//heros[20] = new Hero("提莫");
	}
}
