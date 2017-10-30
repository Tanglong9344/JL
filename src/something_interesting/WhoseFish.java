/**
 * ��������
 * ��һ����䷿�ӣ�ÿһ�䷿�ӵ���ɫ����ͬ������Щ������ס�������ͬ�������ˡ�
 * ÿ����ι���˲�ͬ�Ķ��ϲ����ͬ�����ϣ��鲻ͬ��ѩ�ѡ�
 * ���У�
 * 1.Ӣ����ס�ں�ɫ�����
 * 2.�����������
 * 3.�����˺Ȳ衣
 * 4.��ɫ�ķ����ڰ�ɫ���ӵ���ߡ�
 * 5.��ɫ���ӵ�����ϲ���ȿ��ȡ�
 * 6.�顰��ħ����ѩ�ѵ�������
 * 7.��ɫ���ӵ����˳顰��ɽ����ѩ�ѡ�
 * 8.ס���м䷿�ӵ��˺�ţ�̡�
 * 9.Ų����ס�ڵ�һ�䷿�ӡ�
 * 10.�顰����˹����ѩ�ѵ���ס����è�����Աߡ�
 * 11.�������ס�ڳ顰��ɽ����ѩ�ѵ����Աߡ�
 * 12.�顰���족��ѩ�ѵ��˺�ơ�ơ�
 * 13.�¹��˳顰���ӡ���ѩ�ѡ�
 * 14.Ų����ס����ɫ�����Աߡ�
 * 15.�顰����˹����ѩ�ѵ�����һ����ˮ���ھӡ�
 * ���⣺
 * ˭�����㣿
 */

package something_interesting;

import java.util.ArrayList;

public class WhoseFish {
	// ����5�ֲ�ͬ��ɫ�ķ���
	private static String[] FIVEHOUSES = { "�췿��", "�׷���", "�̷���", "������", "�Ʒ���" };
	// ����5�ֲ�ͬ�Ĺ�������
	private static String[] FIVEPERSONS = { "Ӣ����", "�����", "������", "Ų����", "�¹���" };
	// ����5�ֲ�ͬ������
	private static String[] FIVEDRINKS = { "��", "����", "ţ��", "ơ��", "ˮ" };
	// ����5�ֲ�ͬ���ӵ�����
	private static String[] FIVESMOKES = { "PalMal", "Dunhill", "BlMt","Prince", "Blends" };
	// ����5�ֲ�ͬ�ĳ���
	private static String[] FIVEPETS = { "��", "��", "è", "��", "��" };

	private int[][] co_Array; // ��ɫ����
	private int[][] pe_Array; // ��Ա����
	private int[][] dr_Array; // ��������
	private int[][] cg_Array; // ������
	private int[][] pet_Array; // ��������

	private static int total = 0;
	final int N = 5;//������Ԫ����Ŀ

	public static void main(String args[]) {
		WhoseFish test = new WhoseFish();
		test.lookUp(); // ���÷������м���ͳ��
		System.out.println("\n\t\t\t�������" + total + "���������Ĵ𰸡�");
	}

	// ���ҷ�������Ĵ�
	public void lookUp() {
		// ���÷���ʵʼ������
		init();
		for (int num1 = 0; num1 < co_Array.length; num1++) {
			if (!case4(num1)) {
				continue;
			}
			if (!case14(num1)) {
				continue;
			}
			for (int num2 = 0; num2 < pe_Array.length; num2++) {
				if (!case1(num2, num1)) {
					continue;
				}
				if (!case8(num2)) {
					continue;
				}
				for (int num3 = 0; num3 < dr_Array.length; num3++) {
					if (!case3(num2, num3)) {
						continue;
					}
					if (!case5(num1, num3)) {
						continue;
					}
					if (!case9(num3)) {
						continue;
					}
					for (int num4 = 0; num4 < cg_Array.length; num4++) {
						if (!case7(num1, num4)) {
							continue;
						}
						if (!case12(num4, num3)) {
							continue;
						}
						if (!case13(num2, num4)) {
							continue;
						}
						if (!case15(num4, num3)) {
							continue;
						}
						for (int num5 = 0; num5 < pet_Array.length; num5++) {
							if (!case2(num2, num5)) {
								continue;
							}
							if (!case6(num4, num5)) {
								continue;
							}
							if (!case10(num4, num5)) {
								continue;
							}
							if (!case11(num5, num4)) {
								continue;
							}
							total++;
							answer(num1, num2, num3, num4, num5);
						}
					}
				}
			}
		}
	}

	// ����һ�����ݵ���Ϸ�ʽ
	public void init() {
		ArrayList<int[]> array = new ArrayList<int[]>();
		int num1,num2,num3,num4,num5;
		for (num1 = 0; num1 < N; num1++) {
			for (num2 = 0; num2 < N; num2++) {
				if (num2 == num1) {
					continue;
				}
				for (num3 = 0; num3 < N; num3++) {
					if (num3 == num2 || num3 == num1) {
						continue;
					}
					for (num4 = 0; num4 < N; num4++) {
						if (num4 == num3 || num4 == num2 || num4 == num1) {
							continue;
						}
						for (num5 = 0; num5 < N; num5++) {
							if (num5 == num4 || num5 == num3 || num5 == num2 || num5 == num1) {
								continue;
							}
							int oneArray[] = { num1, num2, num3, num4, num5 };
							array.add(oneArray);
						}
					}
				}
			}
		}
		co_Array = new int[array.size()][N]; // ������ɫ�Ķ�ά����
		for (int count = 0; count < array.size(); count++) { // ѭ������ʵʼ������ɫ����
			co_Array[count] = array.get(count);
		}
		pe_Array = co_Array;
		dr_Array = co_Array;
		cg_Array = co_Array;
		pet_Array = co_Array;
	}

	// Ӣ����ס��ɫ����
	public boolean case1(int cy, int cl) {
		for (int i = 0; i < N; i++) {
			if (pe_Array[cl][i] == 0) {
				if (co_Array[cy][i] == 0) {
					return true;
				} else {
					break;
				}
			}
		}
		return false;
	}

	// ���������
	public boolean case2(int cy, int p) {
		for (int i = 0; i < N; i++) {
			if (pe_Array[cy][i] == 1) {
				if (pet_Array[p][i] == 0) {
					return true;
				} else {
					break;
				}
			}
		}
		return false;
	}

	// �����˺Ȳ�
	public boolean case3(int cy, int d) {
		for (int i = 0; i < N; i++) {
			if (pe_Array[cy][i] == 2) {
				if (dr_Array[d][i] == 0) {
					return true;
				} else {
					break;
				}
			}
		}
		return false;
	}

	// ��ɫ�����ڰ�ɫ��������
	public boolean case4(int cl) {
		int white = 0; // �׷���
		int green = 0; // �̷���
		for (int i = 0; i < N; i++) {
			if (co_Array[cl][i] == 1) {
				white = i;
			}
			if (co_Array[cl][i] == 2) {
				green = i;
			}
		}
		if (green < white) {
			return true;
		} else {
			return false;
		}
	}

	// ��ɫ�������˺ȿ���
	public boolean case5(int cl, int d) {
		for (int i = 0; i < N; i++) {
			if (co_Array[cl][i] == 2) {
				if (dr_Array[d][i] == 1) {
					return true;
				} else {
					break;
				}
			}
		}
		return false;
	}

	// ��PallMall���̵�������
	public boolean case6(int s, int p) {
		for (int i = 0; i < N; i++) {
			if (cg_Array[s][i] == 0) {
				if (pet_Array[p][i] == 1) {
					return true;
				} else {
					break;
				}
			}
		}
		return false;
	}

	// ��ɫ�������˳�Dunhill����
	public boolean case7(int cl, int s) {
		for (int i = 0; i < N; i++) {
			if (4 == co_Array[cl][i]) {
				if (1 == cg_Array[s][i]) {
					return true;
				} else {
					break;
				}
			}
		}
		return false;
	}

	// ס���м䷿�ӵ��˺�ţ��
	public boolean case8(int cy) {
		if (3 == pe_Array[cy][0]) {
			return true;
		} else {
			return false;
		}
	}

	// Ų����ס��һ�䷿
	public boolean case9(int d) {
		if (dr_Array[d][2] == 2) {
			return true;
		} else {
			return false;
		}
	}

	// ��Blends���̵���ס����è���˸���
	public boolean case10(int s, int p) {
		for (int i = 0; i < N; i++) {
			if (4 == cg_Array[s][i]) {
				if (i < 4 && 2 == pet_Array[p][i + 1]) {
					return true;
				}
				if (i > 0 && 2 == pet_Array[p][i - 1]) {
					return true;
				}
				break;
			}
		}
		return false;
	}

	// �������ס��Dunhill���̵��˸���
	public boolean case11(int p, int s) {
		for (int i = 0; i < N; i++) {
			if (3 == pet_Array[p][i]) {
				if (i < 4 && 1 == cg_Array[s][i + 1]) {
					return true;
				}
				if (i > 0 && 1 == cg_Array[s][i - 1]) {
					return true;
				}
				break;
			}
		}
		return false;
	}

	// ��BlueMaster���˺�ơ��
	public boolean case12(int s, int d) {
		for (int i = 0; i < N; i++) {
			if (2 == cg_Array[s][i]) {
				if (3 == dr_Array[d][i]) {
					return true;
				} else {
					break;
				}
			}
		}
		return false;
	}

	// �¹��˳�Prince����
	public boolean case13(int cy, int s) {
		for (int i = 0; i < N; i++) {
			if (4 == pe_Array[cy][i]) {
				if (3 == cg_Array[s][i]) {
					return true;
				} else {
					break;
				}
			}
		}
		return false;
	}

	// Ų����ס��ɫ���Ӹ���
	public boolean case14(int c) {
		if (3 == co_Array[c][1]) {
			return true;
		} else {
			return false;
		}
	}

	// ��Blends���̵�����һ����ˮ���ھ�
	public boolean case15(int s, int d) {
		for (int i = 0; i < N; i++) {
			if (4 == cg_Array[s][i]) {
				if (i < 4 && 4 == dr_Array[d][i + 1]) {
					return true;
				}
				if (i > 0 && 4 == dr_Array[d][i - 1]) {
					return true;
				}
				break;
			}
		}
		return false;
	}

	// ��ʾ����֮���ÿ�������ҳ���Ӧ��
	public void answer(int n1, int n2, int n3, int n4, int n5) {
		System.out.println("��" + total + "���->:");
		System.out.println("1\t\t2\t\t3\t\t4\t\t5\t\t");
		for (int i = 0; i < N; i++) {
			// ѭ����ʾ������������
			System.out.print(FIVEHOUSES[co_Array[n1][i]] + "\t\t");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			// ѭ����ʾ��Ա��������
			System.out.print(FIVEPERSONS[pe_Array[n2][i]] + "\t\t");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			// ѭ����ʾ������������
			System.out.print(FIVEDRINKS[dr_Array[n3][i]] + "\t\t");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			// ѭ����ʾ����������
			System.out.print(FIVESMOKES[cg_Array[n4][i]] + "\t\t");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			// ѭ����ʾ������������
			System.out.print(FIVEPETS[pet_Array[n5][i]] + "\t\t");
		}
		System.out.println();
	}
}