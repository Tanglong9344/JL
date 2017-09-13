package java_generic;

import java.util.Date;

public class GenericExtends<T extends Date> {
	T t;
	@SuppressWarnings("unchecked")
	public GenericExtends(){
		this.t=(T) new Date();
	}
	public static void main(String[] args) {
		GenericExtends<?> date = new GenericExtends<Date>();
		System.out.println(""+date.t);
	}
}