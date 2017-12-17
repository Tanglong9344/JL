package design_mode;

/**
 * ԭ��ģʽ
 * ��ԭ��ʵ��ָ��������������࣬��ͨ��������Щԭ�ʹ����µĶ���
 * (��һ�������ڴ�������һ���ɶ��ƵĶ��󣬶��Ҳ���Ҫ֪���κδ�����ϸ��)
 *
 * @author ����
 *
 */
public class PrototypeMode {
	// This is a test
	public static void main(String[] args) {
		SpecificPrototype s=new SpecificPrototype("1");
		System.out.println("id="+s.getId());
		SpecificPrototype sClone=(SpecificPrototype)s.clone();
		System.out.println("idClone="+sClone.getId());
		System.out.println("s==sClone:"+String.valueOf(s==sClone));
	}
}

//ԭ�ͽӿ�
abstract class Prototype{
	private String id;
	public Prototype(String id){
		this.id=id;
	}

	public String getId() {
		return id;
	}

	//�����¡����
	@Override
	public abstract Prototype clone();
}

//����ԭ����
class SpecificPrototype extends Prototype{
	public SpecificPrototype(String id) {
		super(id);
	}
	@Override
	public Prototype clone() {
		//�½�һ�����󲢸��Ƶ�ǰ����ķǾ�̬����
		return new SpecificPrototype(this.getId());
	}
}