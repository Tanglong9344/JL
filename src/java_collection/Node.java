package java_collection;

import java.util.ArrayList;
import java.util.List;

/**
 * �ݹ�ʵ�ֶ����������Լ�����
 * @author ����
 */

public class Node {
	// ���ӽڵ�
	public Node leftNode;
	// ���ӽڵ�
	public Node rightNode;
	// ֵ
	public Object value;
	// ���� ����
	public void add(Object v) {
		// �����ǰ�ڵ�û��ֵ���Ͱ����ݷ��ڵ�ǰ�ڵ���
		if (null == value){
			value = v;
		}else { // �����ǰ�ڵ���ֵ���ͽ����жϣ�������ֵ�뵱ǰֵ�Ĵ�С��ϵ
			// ������ֵ���ȵ�ǰֵС������ͬ
			if ((Integer) v -((Integer)value) <= 0) {
				if (null == leftNode){
					leftNode = new Node();
				}
				leftNode.add(v);
			}else { // ������ֵ���ȵ�ǰֵ��
				if (null == rightNode){
					rightNode = new Node();
				}
				rightNode.add(v);
			}
		}
	}
	// ����������еĽڵ�
	public List<Object> values() {
		List<Object> values = new ArrayList<>();
		// ��ڵ�ı������
		if (null != leftNode){
			values.addAll(leftNode.values());
		}
		// ��ǰ�ڵ�
		values.add(value);
		// �ҽڵ�ı������
		if (null != rightNode){
			values.addAll(rightNode.values());
		}

		return values;
	}
	public static void main(String[] args) {
		final int NUM = 5000;
		int randoms[] = new int[NUM];
		//�����ʼ��
		for(int i=0; i< NUM;i++){
			randoms[i] = (int)(Math.random()*100);
		}
		Node roots = new Node();
		//��������ֵ
		long time = System.currentTimeMillis();
		for (int number : randoms) {
			roots.add(number);
		}
		System.out.printf("����%d�����������������Ҫʱ��:",NUM);
		System.out.println((Long.valueOf(System.currentTimeMillis())-time)+"ms");
		//�������������
		System.out.println(roots.values());
	}
}