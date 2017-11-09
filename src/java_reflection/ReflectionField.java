package java_reflection;

import java.lang.reflect.Field;

/**
 * ͨ�����������������
 *
 * getField��getDeclaredField������
 * �����������������ڻ�ȡ�ֶ�
 * getField ֻ�ܻ�ȡpublic�ģ������Ӹ���̳������ֶΡ�
 * getDeclaredField ���Ի�ȡ�������е��ֶΣ�����private�ģ����ǲ��ܻ�ȡ�̳������ֶΡ�
 * (ע�� ����ֻ�ܻ�ȡ��private���ֶΣ��������ܷ��ʸ�private�ֶε�ֵ,���Ǽ���setAccessible(true))
 */
public class ReflectionField {
	public static void main(String[] args) {
		Hero h =new Hero();
		h.setName("����");
		h.age=100;
		//��ʼֵ
		System.out.println("name:"+h.getName()+" age:"+h.age);
		try {
			//ʹ��getDeclaredField��ȡHero�������ֽ���name���ֶ�
			Field fName= h.getClass().getDeclaredField("name");
			//����Ϊ�ɷ���
			fName.setAccessible(true);
			System.out.println("Hero���е�'name'�ֶΣ�"+fName);

			//�޸�����ֶε�ֵ
			fName.set(h,"���Ƴ�");
			//��ӡ���޸ĺ��ֵ
			System.out.println("name:"+h.getName());

			//ʹ��getField��ȡ��Hero�����ֽ���age���ֶ�
			Field fAge= h.getClass().getField("age");
			System.out.println("���е�'age'�ֶΣ�"+fAge);
			//�޸�����ֶε�ֵ
			fAge.set(h,108);
			//��ӡ���޸ĺ��ֵ
			System.out.println("age:"+h.age);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}