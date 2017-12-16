package hibernate_annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target ��ʾ���ע���ܷ���ʲôλ���ϣ���ֻ�ܷ������ϣ����Ǽ����Է��ڷ����ϣ��ֿ��Է��������ϡ��Զ���ע��@JDBCConfig ���ע���ϵ�@Target�ǣ�@Target({METHOD,TYPE})����ʾ���������ڷ����������ϣ���ͽӿڣ������ǲ��ܷ������Ե�����λ�á� ����ѡ���λ���б����£�
 * ElementType.TYPE���������ࡢ�ӿڻ�ö������
 * ElementType.FIELD�������γ�Ա����
 * ElementType.METHOD�������η���
 * ElementType.PARAMETER�������β���
 * ElementType.CONSTRUCTOR�������ι�����
 * ElementType.LOCAL_VARIABLE�������ξֲ�����
 * ElementType.ANNOTATION_TYPE��������ע��
 * ElementType.PACKAGE�������ΰ�
 */

/**��ʾ���ע�������������/�ӿ��ϣ����������ڷ�����*/
@Target({ElementType.TYPE,ElementType.METHOD})

/**
 * RetentionPolicy.SOURCE�� ע��ֻ��Դ�����д��ڣ������class֮�󣬾�û�ˡ�@Override ��������ע�⡣
 * RetentionPolicy.CLASS�� ע����java�ļ���̳�.class�ļ�����Ȼ���ڣ����������������û�ˡ�@Retention��Ĭ��ֵ������û����ʾָ��@Retention��ʱ�򣬾ͻ����������͡�
 * RetentionPolicy.RUNTIME�� ע������������֮����Ȼ���ڣ��������ͨ�������ȡ��Щ��Ϣ���Զ���ע��@JDBCConfig ����������
 */

/**
 * ��ʾ����һ������ʱע��
 * ������������֮�󣬲Ż�ȡע���е������Ϣ
 * �����������ע����@Override ���ֲ�������
 * ���ڱ���ʱeclipse�Ϳ��Խ�����ع����ı���ʱע�⡣
 * */
@Retention(RetentionPolicy.RUNTIME)
/**@Inherited ��ʾ���ע����Ա�����̳�*/
@Inherited
/**��ʾ��ִ��javadoc��ʱ�򣬱�ע�����������ĵ�*/
@Documented
/**
 * ��û��@Repeatable���ε�ʱ��ע����ͬһ��λ�ã�ֻ�ܳ���һ�Σ�������ʾ��
 * @JDBCConfig(database = "test",loginName = "root", password = "12345678")
 * @JDBCConfig(database = "test",loginName = "root", password = "12345678")
 * �ظ������ξͻᱨ���ˡ�
 * ʹ��@Repeatable֮�������һЩ�����������Ϳ�����ͬһ���ط�ʹ�ö���ˡ�
 */
public @interface JDBCConfig {
	String ip() default "127.0.0.1";
	int port() default 3306;
	String database();
	String encoding() default "UTF-8";
	String loginName();
	String password();
}
