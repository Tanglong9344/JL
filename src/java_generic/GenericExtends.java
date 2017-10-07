/**
 * 泛型是将程序中的类型参数化
 */

package java_generic;

import java.util.Date;

public class GenericExtends<T extends Date> {
	T t;
	@SuppressWarnings("unchecked")
	public GenericExtends(){
		this.t=(T) new Date();
	}
	//测试
	public static void main(String[] args) {
		GenericExtends<?> date = new GenericExtends<Date>();
		System.out.println("date:"+date.t);
	}
}