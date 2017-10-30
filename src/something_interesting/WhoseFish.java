/**
 * 问题描述
 * 有一排五间房子，每一间房子的颜色都不同。在这些房子里住着五个不同国籍的人。
 * 每个人喂养了不同的动物，喜欢不同的饮料，抽不同的雪茄。
 * 其中：
 * 1.英国人住在红色房子里。
 * 2.瑞典人养狗。
 * 3.丹麦人喝茶。
 * 4.绿色的房子在白色房子的左边。
 * 5.绿色房子的主人喜欢喝咖啡。
 * 6.抽“坡魔”牌雪茄的人养鸟。
 * 7.黄色房子的主人抽“顿山”牌雪茄。
 * 8.住在中间房子的人喝牛奶。
 * 9.挪威人住在第一间房子。
 * 10.抽“波兰斯”牌雪茄的人住在养猫的人旁边。
 * 11.养马的人住在抽“顿山”牌雪茄的人旁边。
 * 12.抽“蓝领”牌雪茄的人喝啤酒。
 * 13.德国人抽“王子”牌雪茄。
 * 14.挪威人住在蓝色房子旁边。
 * 15.抽“波兰斯”牌雪茄的人有一个喝水的邻居。
 * 问题：
 * 谁家养鱼？
 */

package something_interesting;

import java.util.ArrayList;

public class WhoseFish {
	// 定义5种不同颜色的房子
	private static String[] FIVEHOUSES = { "红房子", "白房子", "绿房子", "蓝房子", "黄房子" };
	// 定义5种不同的国籍的人
	private static String[] FIVEPERSONS = { "英国人", "瑞典人", "丹麦人", "挪威人", "德国人" };
	// 定义5种不同的饮料
	private static String[] FIVEDRINKS = { "茶", "咖啡", "牛奶", "啤酒", "水" };
	// 定义5种不同牌子的香烟
	private static String[] FIVESMOKES = { "PalMal", "Dunhill", "BlMt","Prince", "Blends" };
	// 定义5种不同的宠物
	private static String[] FIVEPETS = { "狗", "鸟", "猫", "马", "鱼" };

	private int[][] co_Array; // 颜色数组
	private int[][] pe_Array; // 人员数组
	private int[][] dr_Array; // 饮料数组
	private int[][] cg_Array; // 烟数组
	private int[][] pet_Array; // 宠物数组

	private static int total = 0;
	final int N = 5;//操作的元素数目

	public static void main(String args[]) {
		WhoseFish test = new WhoseFish();
		test.lookUp(); // 调用方法进行计算统计
		System.out.println("\n\t\t\t共计算出" + total + "组符合题意的答案。");
	}

	// 查找符合题意的答案
	public void lookUp() {
		// 调用方法实始化数据
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

	// 计算一组数据的组合方式
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
		co_Array = new int[array.size()][N]; // 创建颜色的二维数组
		for (int count = 0; count < array.size(); count++) { // 循环数组实始化房颜色数据
			co_Array[count] = array.get(count);
		}
		pe_Array = co_Array;
		dr_Array = co_Array;
		cg_Array = co_Array;
		pet_Array = co_Array;
	}

	// 英国人住红色房子
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

	// 瑞典人养狗
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

	// 丹麦人喝茶
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

	// 绿色房子在白色房子左面
	public boolean case4(int cl) {
		int white = 0; // 白房子
		int green = 0; // 绿房子
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

	// 绿色房子主人喝咖啡
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

	// 抽PallMall香烟的人养鸟
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

	// 黄色房子主人抽Dunhill香烟
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

	// 住在中间房子的人喝牛奶
	public boolean case8(int cy) {
		if (3 == pe_Array[cy][0]) {
			return true;
		} else {
			return false;
		}
	}

	// 挪威人住第一间房
	public boolean case9(int d) {
		if (dr_Array[d][2] == 2) {
			return true;
		} else {
			return false;
		}
	}

	// 抽Blends香烟的人住在养猫的人隔壁
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

	// 养马的人住抽Dunhill香烟的人隔壁
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

	// 抽BlueMaster的人喝啤酒
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

	// 德国人抽Prince香烟
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

	// 挪威人住蓝色房子隔壁
	public boolean case14(int c) {
		if (3 == co_Array[c][1]) {
			return true;
		} else {
			return false;
		}
	}

	// 抽Blends香烟的人有一个喝水的邻居
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

	// 显示计算之后的每个数组找出对应答案
	public void answer(int n1, int n2, int n3, int n4, int n5) {
		System.out.println("第" + total + "组答案->:");
		System.out.println("1\t\t2\t\t3\t\t4\t\t5\t\t");
		for (int i = 0; i < N; i++) {
			// 循环显示房子数组数据
			System.out.print(FIVEHOUSES[co_Array[n1][i]] + "\t\t");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			// 循环显示人员数组数据
			System.out.print(FIVEPERSONS[pe_Array[n2][i]] + "\t\t");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			// 循环显示饮料数组数据
			System.out.print(FIVEDRINKS[dr_Array[n3][i]] + "\t\t");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			// 循环显示烟数组数据
			System.out.print(FIVESMOKES[cg_Array[n4][i]] + "\t\t");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			// 循环显示宠物数组数据
			System.out.print(FIVEPETS[pet_Array[n5][i]] + "\t\t");
		}
		System.out.println();
	}
}