package java_optimization;

/**
 * �Ƚ��Ż�
 * ���s1Ϊnull�򷵻�true����Ƚ�s1��s2
 * @author ����
 */
public class Comparison {
	public static void main(String[] args) {
		String s1 = "Java";
		String s2 = "Java";
		System.out.println("cmp1: " + cmp1(s1,s2));
		System.out.println("cmp2: " + cmp2(s1,s2));
		System.out.println("cmp3: " + cmp3(s1,s2));
	}

	// �ȽϷ�ʽ1
	static boolean cmp1(String s1,String s2){
		if(s1 == null){
			return true;
		}else{
			return s1.equals(s2);
		}
	}

	// �ȽϷ�ʽ2
	static boolean cmp2(String s1,String s2){
		return s1 == null? s1 == null : s1.equals(s2);
	}

	// �ȽϷ�ʽ3
	static boolean cmp3(String s1,String s2){
		return (s1 == null || s1 != null && s1.equals(s2));
	}
}