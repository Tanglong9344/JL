package hibernate_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//��ʾ���ע�������������/�ӿ���
@Target(ElementType.TYPE)
/* ��ʾ����һ������ʱע�⣬����������֮�󣬲Ż�ȡע���е������Ϣ��
 * ���������ע����@Override ���ֲ������У��ڱ���ʱeclipse
 * �Ϳ��Խ�����ع����ı���ʱע�⡣*/
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTable {
	String name();
}
