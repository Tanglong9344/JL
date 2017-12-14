package java_collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归实现二叉树创建以及遍历
 * @author 唐龙
 */

public class Node {
	// 左子节点
	public Node leftNode;
	// 右子节点
	public Node rightNode;
	// 值
	public Object value;
	// 插入 数据
	public void add(Object v) {
		// 如果当前节点没有值，就把数据放在当前节点上
		if (null == value){
			value = v;
		}else { // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
			// 新增的值，比当前值小或者相同
			if ((Integer) v -((Integer)value) <= 0) {
				if (null == leftNode){
					leftNode = new Node();
				}
				leftNode.add(v);
			}else { // 新增的值，比当前值大
				if (null == rightNode){
					rightNode = new Node();
				}
				rightNode.add(v);
			}
		}
	}
	// 中序遍历所有的节点
	public List<Object> values() {
		List<Object> values = new ArrayList<>();
		// 左节点的遍历结果
		if (null != leftNode){
			values.addAll(leftNode.values());
		}
		// 当前节点
		values.add(value);
		// 右节点的遍历结果
		if (null != rightNode){
			values.addAll(rightNode.values());
		}

		return values;
	}
	public static void main(String[] args) {
		final int NUM = 5000;
		int randoms[] = new int[NUM];
		//数组初始化
		for(int i=0; i< NUM;i++){
			randoms[i] = (int)(Math.random()*100);
		}
		Node roots = new Node();
		//二叉树赋值
		long time = System.currentTimeMillis();
		for (int number : randoms) {
			roots.add(number);
		}
		System.out.printf("插入%d个随机数到二叉树需要时间:",NUM);
		System.out.println((Long.valueOf(System.currentTimeMillis())-time)+"ms");
		//二叉树遍历输出
		System.out.println(roots.values());
	}
}