package java_thread;

public class Hero5 {
	public String name;
	public float hp;
	public int damage;

	//��Ѫ����
	public synchronized void recover() {
		hp = hp + 1;
		System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
		// ֪ͨ��Щ�ȴ���this�����ϵ��̣߳������ѹ����ˣ����20�У��ȴ��ŵļ�Ѫ�̣߳����ѹ���
		this.notify();
	}

	//��Ѫ����
	public synchronized void hurt() {
		if (1 == hp) {
			try {
				// ��ռ��this�ļ�Ѫ�̣߳���ʱ�ͷŶ�this��ռ�У����ȴ�
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		hp = hp - 1;
		System.out.printf("%s ��Ѫ1��,����Ѫ��%s��Ѫ����%.0f%n", name, name, hp);
	}
	//��������
	public void attackHero(Hero5 h) {
		h.hp -= damage;
		System.out.format("%s ���ڹ��� %s, %s��Ѫ����� %.0f%n", name, h.name, h.name, h.hp);
		if (h.isDead()) {
			System.out.println(h.name + "���ˣ�");
		}
	}
	//�ж�Ѫ���Ƿ�С��0
	public boolean isDead() {
		return hp<=0? true : false;
	}
}
