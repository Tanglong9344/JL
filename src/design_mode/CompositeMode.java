package design_mode;

import java.util.ArrayList;
import java.util.List;

/**
 * <strong>���ģʽ</strong>
 * ��������ϳ����Խṹ�Ա�ʾ������-���塯�Ĳ�νṹ��
 * ���ģʽ�ǵ��û��Ե����������϶����ʹ�þ���һ���ԡ�
 *
 * ����еĶ��������ӿڣ����ʵ�����£�ʵ�������๲�нӿ�
 * ��Ĭ����Ϊ������һ���ӿ����ڷ��ʺ͹������Ӳ���(�ڵ�)��
 *
 * �������������ϳ���϶���
 * ��϶����ֿ��Լ��������
 * ���û������������ʹ�û����������϶���
 *
 * �ڵ���:Ҷ�ӽڵ�ͷ�֦�ڵ�
 *
 * ��������͸��ģʽ(��Ҷ�ӽڵ�ͷ�֦�ڵ������ͬ����Ϊ)
 * ��һ���ǰ�ȫģʽ
 *
 * @author ����
 *
 */
public class CompositeMode {
	//This is a test
	public static void main(String[] args) {
		//���ڵ�
		Composite root=new Composite("Root");
		//���Ҷ�ӽڵ�
		root.add(new Leave("LeaveA"));
		root.add(new Leave("LeaveB"));
		//��֦�ڵ�
		Composite branch=new Composite("BranchX");
		//��֦���Ҷ�ӽڵ�
		branch.add(new Leave("LeaveXA"));
		branch.add(new Leave("LeaveXB"));
		//��ӷ�֦
		root.add(branch);
		//Ҷ�ӽڵ�
		Leave leave=new Leave("LeaveC");
		//Ҷ�ӽڵ���ӽڵ�
		leave.add(new Leave("LeaveCA"));
		//��ʾҶ�ӽڵ�����νṹ
		leave.display(1);
		//���Ҷ�ӽڵ�
		root.add(leave);
		//��ʾ�������νṹ
		root.display(1);
	}
}

//���������
abstract class Components{
	protected String name;
	public Components(String name){
		this.name=name;
	}
	//���
	public abstract void add(Components c);
	//�Ƴ�
	public abstract void remove(Components c);
	//��ʾĳһ��ȵ����νṹ
	public abstract void display(int depth);
}

//����е�Ҷ�ӽڵ���
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

//����з�֦�ڵ���
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
		//-����Ŀ��ʾ�������
		for(int i=0;i<depth;i++){
			System.out.print("-");
		}
		System.out.println(name);
		//�ֵܽڵ������ͬ���ӽڵ���ȼ�1
		nodes.forEach(node->node.display(depth+1));
	}
}