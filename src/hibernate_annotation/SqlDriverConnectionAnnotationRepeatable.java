package hibernate_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Repeatable;

public class SqlDriverConnectionAnnotationRepeatable {
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME )
	public @interface FileTypes {
		FileType[] value();
	}
	@Repeatable(FileTypes.class)
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME )
	public @interface FileType {
		String value();
	};
	@FileType( ".java" )
	@FileType( ".html" )
	@FileType( ".css" )
	@FileType( ".js" )
	public void work(){
		try {
			FileType[] fileTypes= this.getClass().getMethod("work").getAnnotationsByType(FileType.class);
			System.out.println("�������º�׺�����ļ��в����ļ�����");
			for (FileType fileType : fileTypes) {
			System.out.println(fileType.value());
		}
		System.out.println("���ҹ����ԡ�����");
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new SqlDriverConnectionAnnotationRepeatable().work();
	}
}