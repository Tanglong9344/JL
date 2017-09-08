package java_core_basic;

public class StringTest {
	public static void main(String[] args) {
		String str1 = "the light";
		String str2 = new String(str1);

		// '=='�����ж��Ƿ���ͬһ���ַ�������
		System.out.print("str1 == str2:");
		System.out.println(str1 == str2);
		String str11 = "the light";
		String str22 = "the light";
		System.out.print("str11 == str22:");
		System.out.println(str11 == str22);
		String str111 = "The Light";
		String str222 = "the light";
		//equals �����ж��ַ�����ֵ
		System.out.println("str111.equals(str222):" + str111.equals(str222));
		System.out.println("str111.equalsIgnoreCase(str222):" + str111.equalsIgnoreCase(str222));// ���Դ�Сд���бȽ�
		System.out.println("str111.startsWith(\"the\"):" + str111.startsWith("the"));
		System.out.println("str111.endsWith(\"ght\"):" + str111.endsWith("ght"));

		String week="һ������������";
		int i;
		//charAt()
		for(i=0;i<week.length();i++){
			System.out.println(week.charAt(i));
		}

		//subString()
		for(i=0;i<week.length();i++){
			System.out.println(week.substring(i,i+1));
		}

		//split()����
		String splitStr="Wo.shi.zh.o.ng.r.en.";
		System.out.println(splitStr);
		String [] splitStrArr = splitStr.split("\\.");//.��ת���ַ����������\\
		System.out.println("���鳤�ȣ�"+splitStrArr.length);
		for(i=0;i<splitStrArr.length;i++){
			System.out.println(splitStrArr[i]);
		}
		//matches()����
		System.out.println(splitStr.matches("^Wo\\.shi[a-z(\\.)]*$"));
	}
}
