package java_effective_code;

/**
 * Class Override : dynamic selection
 *
 * @author ÌÆÁú
 *
 */
public class ClassOverride {
	public static void main(String[] args) {
		Tree[] trees = new Tree[] {new Tree(), new Forest(), new RainForest()};
		for(Tree tree : trees) {
			tree.show();
		}
	}
}

/**Tree*/
class Tree{
	public void show() {
		System.out.println("Tree...");
	}
}

/**Forest extends Tree*/
class Forest extends Tree{
	@Override
	public void show() {
		System.out.println("Forest...");
	}
}

/**RainForest extends Forest*/
class RainForest extends Forest{
	@Override
	public void show() {
		System.out.println("RainForest...");
	}
}