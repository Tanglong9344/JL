package design_mode;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式
 * 迭代器模式提供一种方法顺序遍历访问一个聚合
 * 对象中各个元素，而又不暴露该对象的内部表示。
 *
 * @author 唐龙
 *
 */
public class IteratorMode {
	//This is a test
	public static void main(String[] args) {
		//聚集集合对象
		SpecificAggregate aggregate=new SpecificAggregate();
		for(int i=1;i<=10;i++){
			aggregate.add("元素-"+i);
		}
		//迭代器
		Iterator iterator=new SpecificIterator(aggregate);
		Object o = iterator.first();
		while(!iterator.isEnd()){
			System.out.println("元素："+o);
			o=iterator.next();
		}
	}
}

//抽象迭代器类
abstract class Iterator{
	//起始对象
	public abstract Object first();
	//下一个对象
	public abstract Object next();
	//是否到结尾
	public abstract boolean isEnd();
	//当前对象
	public abstract Object currentItem();
}

//抽象聚集类
abstract class Aggregate{
	public abstract Iterator createIterator();
}

//具体迭代器类
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

//具体聚合类
class SpecificAggregate extends Aggregate{
	private List<Object> items=new ArrayList<>();

	@Override
	public Iterator createIterator() {
		return new SpecificIterator(this);
	}

	//返回总数目
	public int count(){
		return items.size();
	}

	//建立索引器
	public Object index(int index){
		return items.get(index);
	}

	//添加
	public void add(Object o){
		items.add(o);
	}
}