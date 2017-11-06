package java_thread;

import java.util.Random;

public class ThreadSynchronizedMethod {
	public static void main(String[] args) {
		//支付宝对象
		Alipay alipay = new Alipay(5);
		//卖家对象
		new Seller("卖家-AAA", alipay).start();
		new Seller("卖家-BBB", alipay).start();
		//买家对象
		new Buyer("买家-XXX", alipay).start();
		new Buyer("买家-YYY", alipay).start();
	}
}

/**
 * 支付宝 用于网上买卖交易
 * @author 唐龙
 */
class Alipay {
	private final String[] goods;//标识卖家商品，数组的长度是多少则表示商品的数量是多少
	private int nIn;//标识存入支付宝的交易数量
	private int nOut;//标识支出支付宝的交易数量
	private int count;//缓存内的交易数量
	public Alipay(int count) {
		this.goods = new String[count];
		this.nIn = 0;
		this.nOut = 0;
		this.count = 0;
	}

	/**往支付宝里存款*/
	public synchronized void storage(String alipay) {
		System.out.println("淘宝用户ID：" + Thread.currentThread().getName() + "\t支付宝存入，" + alipay);
		try {
			while (count >= goods.length) {
				wait();//线程等待
			}
			//循环顺序存储支付宝账号
			goods[nIn] = alipay;
			nIn = (nIn + 1) % goods.length;
			count++;
			notifyAll();//唤醒等待的进程
		} catch (Exception e) {
			System.out.println("支付宝存入功能出现错误：" + e.getMessage());
		}
	}

	/**从支付宝中支出*/
	public synchronized String outpay() {
		String alipay = null;
		try {
			while (count <= 0) {
				wait();//线程等待
			}
			//循环顺序取出指定的支付宝账号
			alipay = goods[nOut];
			nOut = (nOut + 1) % goods.length;
			count--;
			notifyAll();
		} catch (Exception e) {
			System.out.println("支付宝支付功能出现错误：" + e.getMessage());
		}
		System.out.println("淘宝用户ID：" + Thread.currentThread().getName()
				+ "\t支付宝支出，" + alipay);
		return alipay;
	}
}

/**
 * 买家线程类
 * @author 唐龙
 */
class Buyer extends Thread {
	private final Random random=new Random(10);
	private final Alipay alipay;
	private static int id = 0;//交易的流水号
	public Buyer(String name, Alipay alipay) {
		super(name);
		this.alipay = alipay;
	}
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(random.nextInt(1000));// 随机休眠
				String flowID = "交易号码：" + nextId();
				alipay.storage(flowID);//存入支付宝中
			}
		} catch (Exception e) {
		}
	}

	/**生成交易号码*/
	private static synchronized int nextId() {
		return id++;
	}
}

/**
 * 卖家线程类
 * @author 唐龙
 */
class Seller extends Thread {
	private final Random random=new Random(10);
	private final Alipay alipay;
	// 构造方法进行初始化
	public Seller(String name, Alipay alipay) {
		super(name);//线程名
		this.alipay = alipay;//支付宝
	}

	@Override
	public void run() {
		try {
			while (true) {
				this.alipay.outpay();
				Thread.sleep(random.nextInt(1000));
			}
		} catch (Exception e) {
			System.out.println("买家支付预付款出错：" + e.getMessage());
		}
	}
}