package java_generic;

import java.util.ArrayList;
import java.util.List;

/**
 * ���Ͷ���
 * �Ͻ�����ͨ�����?extends���� �½�����ͨ�����?super��
 * @author ����
 */
public class GenericExtendsSuper{
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//�Ͻ�����ͨ�����?extends��
		//eList�洢Parent�����������
		//��new ArrayList<T>,Tֻ����Parent��������
		List<? extends Parent> eList = new ArrayList<Child>();//��ȷ
		List<? extends Parent> eList2 = new ArrayList<Child2>();//��ȷ
		//List<? extends Parent> eList3 = new ArrayList<String>();//����
		//��Ϊ�޷�ȷ��eList�ڴ洢�ľ������ͣ����޷����
		//eList.add(new Parent());//����
		//eList.add(new Child());//����
		//eList.add(new Child2());//����
		Parent eParent = eList.get(0);//��ȷ
		//Child eChild = eList.get(0);//����
		//Child2 eChild2 = eList.get(0);//����

		//�½�����ͨ�����?super��
		//sList�洢Child���丸�����
		List<? super Child> sList = new ArrayList<Parent>();//��ȷ
		List<? super Child> sList2 = new ArrayList<Child>();//��ȷ
		//List<? super Child> sList3 = new ArrayList<Child2>();//����
		//ֻ�����Child�����������
		sList.add(new Child());//��ȷ
		//sList.add(new Child2());//����
		//sList.add(new Parent());//����
		//��ȡ��ȫ����Object����
		//Parent sParent = sList.get(0);//����
		//Child sChild = sList.get(0);//����
		//Child2 sChild2 = sList.get(0);//����
	}
}