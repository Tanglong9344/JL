package java_core_basic;

import java.util.Arrays;

/**
 * Javaö��
 * @author ����
 */
public class Enum {
	public static void main(String[] args) {
		Season[] seasons = Season.values();
		System.out.println("�ļ���" + Arrays.toString(seasons));

		System.out.println("���ڣ�" + Arrays.toString(Weekend.values()));
		//����
		for(Season s:seasons){
			switch(s){
			case ����:
				System.out.println(s.ordinal() + ":" + s.toString() + "��էů���������︴�ա�");
				break;
			case �ļ�:
				System.out.println(s.ordinal() + ":" + s.toString() + "���������ף��������١�");
				break;
			case �＾:
				System.out.println(s.ordinal() + ":" + s.toString() + "�������ˬ��˶�����ۡ�");
				break;
			case ����:
				System.out.println(s.ordinal() + ":" + s.toString() + "����ѩ�׷ɣ�һ֦���㡣");
				break;
			default:
				System.out.println("���������������");
				break;
			}
		}
	}
}

//ö��
enum Season{����,�ļ�,�＾,����}
enum Weekend{������,����һ,���ڶ�,������,������,������,������}