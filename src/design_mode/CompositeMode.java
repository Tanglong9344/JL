package design_mode;

import java.util.ArrayList;
import java.util.List;

/**
 * <strong>组合模式</strong>
 * 将对象组合成属性结构以表示‘部分-整体’的层次结构。
 * 组合模式是的用户对单个对象和组合对象的使用具有一致性。
 *
 * 组合中的对象声明接口，在适当情况下，实现所有类共有接口
 * 的默认行为。声明一个接口用于访问和管理其子部件(节点)。
 *
 * 基本对象可以组合成组合对象
 * 组合对象又可以继续被组合
 * 且用户可以无区别的使用基本对象和组合对象
 *
 * 节点类:叶子节点和分枝节点
 *
 * 本例采用透明模式(即叶子节点和分枝节点具有相同的行为)
 * 另一种是安全模式
 *
 * @author 唐龙
 *
 */
public class CompositeMode {
	//This is a test
	public static void main(String[] args) {
		//根节点
		Composite root=new Composite("Root");
		//添加叶子节点
		root.add(new Leave("LeaveA"));
		root.add(new Leave("LeaveB"));
		//分枝节点
		Composite branch=new Composite("BranchX");
		//分枝添加叶子节点
		branch.add(new Leave("LeaveXA"));
		branch.add(new Leave("LeaveXB"));
		//添加分枝
		root.add(branch);
		//叶子节点
		Leave leave=new Leave("LeaveC");
		//叶子节点添加节点
		leave.add(new Leave("LeaveCA"));
		//显示叶子节点的树形结构
		leave.display(1);
		//添加叶子节点
		root.add(leave);
		//显示整体树形结构
		root.display(1);
	}
}

//抽象组合类
abstract class Components{
	protected String name;
	public Components(String name){
		this.name=name;
	}
	//添加
	public abstract void add(Components c);
	//移除
	public abstract void remove(Components c);
	//显示某一深度的树形结构
	public abstract void display(int depth);
}

//组合中的叶子节点类
class Leave extends Components{
	public Leave(String name){
		super(name);
	}

	@Override
	public void add(Components c) {
		System.out.println("Can't add to a leave.");
	}

	@Override
	public void remove(Components c) {
		System.out.println("Can't remove from a leave.");
	}

	@Override
	public void display(int depth) {
		for(int i=0;i<depth;i++){
			System.out.print("-");
		}
		System.out.println(name);
	}
}

//组合中分枝节点类
class Composite extends Components{
	private List<Components> nodes=new ArrayList<Components>();
	public Composite(String name) {
		super(name);
	}

	@Override
	public void add(Components c) {
		nodes.add(c);
	}

	@Override
	public void remove(Components c) {
		nodes.remove(c);
	}

	@Override
	public void display(int depth) {
		//-的数目表示树的深度
		for(int i=0;i<depth;i++){
			System.out.print("-");
		}
		System.out.println(name);
		//兄弟节点深度相同，子节点深度加1
		nodes.forEach(node->node.display(depth+1));
	}
}