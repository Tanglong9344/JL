package java_native;

public class NativeDemo {
	public static void main(String[] args){
		System.loadLibrary("NativeAddDemo");//加载由C编译器生成的DLL文件。
		NativeAdd na = new NativeAdd();
		System.out.println("3 + 4 = " + na.add(3, 4));
	}
}