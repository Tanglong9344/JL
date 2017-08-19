package java_core_basic;

public class EscapeRequences {
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "EscapeRequences [hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	public static void main(String[] args) {
		System.out.println("escape requences \":"+"\"Hello\"");
		System.out.println("Unicode pi:" +"\u03C0");
		System.out.println("Get name of this class:"+EscapeRequences.class);
	}
}
