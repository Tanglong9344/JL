package something_interesting;

public class Test {
	static Test1 test = new Test1();

	public static void main(String[] args) {
		System.out.println(test.talk());
	}
}

class Test1 {
	public String talk() {
		return "this is a boy";
	}
}