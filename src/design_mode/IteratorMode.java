package design_mode;

import java.util.ArrayList;
import java.util.List;

/**
 * ������ģʽ
 * ������ģʽ�ṩһ�ַ���˳���������һ���ۺ�
 * �����и���Ԫ�أ����ֲ���¶�ö�����ڲ���ʾ��
 *
 * @author ����
 *
 */
public class IteratorMode {
	//This is a test
	public static void main(String[] args) {
		//�ۼ����϶���
		SpecificAggregate aggregate=new SpecificAggregate();
		for(int i=1;i<=10;i++){
			aggregate.add("Ԫ��-"+i);
		}
		//������
		Iterator iterator=new SpecificIterator(aggregate);
		Object o = iterator.first();
		while(!iterator.isEnd()){
			System.out.println("Ԫ�أ�"+o);
			o=iterator.next();
		}
	}
}

//�����������
abstract class Iterator{
	//��ʼ����
	public abstract Object first();
	//��һ������
	public abstract Object next();
	//�Ƿ񵽽�β
	public abstract boolean isEnd();
	//��ǰ����
	public abstract Object currentItem();
}

//����ۼ���
abstract class Aggregate{
	public abstract Iterator createIterator();
}

//�����������
class SpecificIterator extends Iterator{
	private SpecificAggregate aggregate=new SpecificAggregate();
	private int current=0;

	public SpecificIterator(SpecificAggregate aggregate){
		this.aggregate=aggregate;
	}
	@Override
	public Object first() {
		return aggregate.index(0);
	}

	@Override
	public Object next() {
		current++;
		if(current<aggregate.count()){
			return aggregate.index(current);
		}else{
			return null;
		}
	}

	@Override
	public boolean isEnd() {
		return current>=aggregate.count()?true:false;
	}

	@Override
	public Object currentItem() {
		return aggregate.index(current);
	}
}

//����ۺ���
class SpecificAggregate extends Aggregate{
	private List<Object> items=new ArrayList<>();

	@Override
	public Iterator createIterator() {
		return new SpecificIterator(this);
	}

	//��������Ŀ
	public int count(){
		return items.size();
	}

	//����������
	public Object index(int index){
		return items.get(index);
	}

	//���
	public void add(Object o){
		items.add(o);
	}
}