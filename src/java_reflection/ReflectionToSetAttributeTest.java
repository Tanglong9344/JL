/**
 * ͨ�����������������
 * 
 * getField��getDeclaredField������
 * �����������������ڻ�ȡ�ֶ�
 * getField ֻ�ܻ�ȡpublic�ģ������Ӹ���̳������ֶΡ�
 * getDeclaredField ���Ի�ȡ�������е��ֶΣ�����private�ģ����ǲ��ܻ�ȡ�̳������ֶΡ� 
 * (ע�� ����ֻ�ܻ�ȡ��private���ֶΣ��������ܷ��ʸ�private�ֶε�ֵ,���Ǽ���setAccessible(true))
 */

package java_reflection;

import java.lang.reflect.Field;

public class ReflectionToSetAttributeTest {
	public static void main(String[] args) {
		Hero h =new Hero();
		//ʹ�ô�ͳ��ʽ�޸�name��ֵΪgareen
		h.name = "���׵�";
		//��ʼֵ
		System.out.println("name1:"+h.name);
		try {
			//ʹ��getDeclaredField��ȡ��Hero�����ֽ���name���ֶ�
			Field f1= h.getClass().getDeclaredField("name");
			System.out.println("���е�'name'�ֶΣ�"+f1);
			//�޸�����ֶε�ֵ
			f1.set(h, "�ܲ�");
			//��ӡ���޸ĺ��ֵ
			System.out.println("name2:"+h.name);

			//ʹ��getField��ȡ��Hero�����ֽ���name���ֶ�
			Field f2= h.getClass().getField("name");
			System.out.println("���е�'name'�ֶΣ�"+f2);
			//�޸�����ֶε�ֵ
			f2.set(h, "��ا");
			//��ӡ���޸ĺ��ֵ
			System.out.println("name3:"+h.name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}