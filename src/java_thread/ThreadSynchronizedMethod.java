package java_thread;

import java.util.Random;

public class ThreadSynchronizedMethod {
	public static void main(String[] args) {
		//֧��������
		Alipay alipay = new Alipay(5);
		//���Ҷ���
		new Seller("����-AAA", alipay).start();
		new Seller("����-BBB", alipay).start();
		//��Ҷ���
		new Buyer("���-XXX", alipay).start();
		new Buyer("���-YYY", alipay).start();
	}
}

/**
 * ֧���� ����������������
 * @author ����
 */
class Alipay {
	private final String[] goods;//��ʶ������Ʒ������ĳ����Ƕ������ʾ��Ʒ�������Ƕ���
	private int nIn;//��ʶ����֧�����Ľ�������
	private int nOut;//��ʶ֧��֧�����Ľ�������
	private int count;//�����ڵĽ�������
	public Alipay(int count) {
		this.goods = new String[count];
		this.nIn = 0;
		this.nOut = 0;
		this.count = 0;
	}

	/**��֧��������*/
	public synchronized void storage(String alipay) {
		System.out.println("�Ա��û�ID��" + Thread.currentThread().getName() + "\t֧�������룬" + alipay);
		try {
			while (count >= goods.length) {
				wait();//�̵߳ȴ�
			}
			//ѭ��˳��洢֧�����˺�
			goods[nIn] = alipay;
			nIn = (nIn + 1) % goods.length;
			count++;
			notifyAll();//���ѵȴ��Ľ���
		} catch (Exception e) {
			System.out.println("֧�������빦�ܳ��ִ���" + e.getMessage());
		}
	}

	/**��֧������֧��*/
	public synchronized String outpay() {
		String alipay = null;
		try {
			while (count <= 0) {
				wait();//�̵߳ȴ�
			}
			//ѭ��˳��ȡ��ָ����֧�����˺�
			alipay = goods[nOut];
			nOut = (nOut + 1) % goods.length;
			count--;
			notifyAll();
		} catch (Exception e) {
			System.out.println("֧����֧�����ܳ��ִ���" + e.getMessage());
		}
		System.out.println("�Ա��û�ID��" + Thread.currentThread().getName()
				+ "\t֧����֧����" + alipay);
		return alipay;
	}
}

/**
 * ����߳���
 * @author ����
 */
class Buyer extends Thread {
	private final Random random=new Random(10);
	private final Alipay alipay;
	private static int id = 0;//���׵���ˮ��
	public Buyer(String name, Alipay alipay) {
		super(name);
		this.alipay = alipay;
	}
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(random.nextInt(1000));// �������
				String flowID = "���׺��룺" + nextId();
				alipay.storage(flowID);//����֧������
			}
		} catch (Exception e) {
		}
	}

	/**���ɽ��׺���*/
	private static synchronized int nextId() {
		return id++;
	}
}

/**
 * �����߳���
 * @author ����
 */
class Seller extends Thread {
	private final Random random=new Random(10);
	private final Alipay alipay;
	// ���췽�����г�ʼ��
	public Seller(String name, Alipay alipay) {
		super(name);//�߳���
		this.alipay = alipay;//֧����
	}

	@Override
	public void run() {
		try {
			while (true) {
				this.alipay.outpay();
				Thread.sleep(random.nextInt(1000));
			}
		} catch (Exception e) {
			System.out.println("���֧��Ԥ�������" + e.getMessage());
		}
	}
}