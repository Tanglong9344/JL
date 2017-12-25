package java_effective_code;

/**
 * Class OverLoad : static selection
 *
 * @author ÌÆÁú
 *
 */
public class ClassOverLoad {
	public static void main(String[] args) {
		Tree[] trees = new Tree[] {new Tree(), new Forest(), new RainForest()};
		for(Tree tree : trees) {
			show(tree);
		}
	}

	/**parameter Tree*/
	public static void show(Tree tree) {
		System.out.println("Tree...");
	}

	/**parameter Forest*/
	public static void show(Forest forest) {
		System.out.println("Forest...");
	}

	/**parameter RainForest*/
	public static void show(RainForest rainForest) {
		System.out.println("RainForest...");
	}
}