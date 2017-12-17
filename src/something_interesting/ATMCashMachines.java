package something_interesting;

/**
 * ATM 模拟
 *
 * @author 唐龙
 *
 */
public class ATMCashMachines {
	public static void main(String[] args) {
		// 实例化Bank对象
		Bank bank = new Bank();
		System.out.println("1.存、取线程没有采取同步时，执行存取操作时，其工作流程如下：");
		// 存钱没有采用同步机制
		Thread putThread = new CashMachines(bank, "saveMoney");
		// 取钱没有同步机制
		Thread takeThread = new CashMachines(bank, "withdrawMoney");
		putThread.start(); // 启动putThread线程
		takeThread.start(); // 启动takeThread线程
		try {
			putThread.join(); // 等待两线程运行结束
			takeThread.join();
		} catch (Exception e) {
			System.out.println("两线程运行出错：" + e.getMessage());
		}
		System.out.println();
		// 实例化SyncBank对象
		SyncBank sbank = new SyncBank();
		System.out.println("2.存、取线程设置为同步时，执行存取操作时，其工作流程如下：");
		putThread = new CashMachines(sbank, "sync_SaveMoney"); // 创建CashMachines对象，存钱有同步机制
		takeThread = new CashMachines(sbank, "sync_WithdrawMoney"); // 取钱有同步机制
		putThread.start(); // 启动线程
		takeThread.start(); // 启动线程
	}
}

/**普通银行类*/
class Bank {
	private double curveMoney = 174.85; // 存入银行的钱数

	// 存钱没有采用同步机制
	public void saveMoney(double putThread) {
		System.out.println("当前账户中所剩余额为" + this.curveMoney + "; 存入金额为: " + putThread);
		System.out.println("正在操作，请稍候......"); // 存钱时先等待300毫秒
		try {
			Thread.sleep(300); // 线程休眠
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("操作成功，存入金额：" + putThread);
		this.curveMoney = this.curveMoney + putThread;
		System.out.println("当前余额为：" + this.curveMoney + "元");
	}

	// 取钱没有同步机制
	public void withdrawMoney(double takeThread) {
		System.out.println("查询余额显示，当前可用余额为：" + this.curveMoney + "; 取出金额为: " + takeThread);
		System.out.println("正在操作，请稍候......"); // 取钱时先等待500毫秒
		try {
			Thread.sleep(500); // 线程休眠
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("操作成功，取出金额：" + takeThread);
		this.curveMoney = this.curveMoney - takeThread;
		System.out.println("当前余额为：" + this.curveMoney + "元");
	}
}

/**同步银行类*/
class SyncBank {
	private double curveMoney = 174.85; // 存入银行的钱数

	/**
	 * 存同步机制存钱
	 * @param putThread
	 */
	public synchronized void sync_SaveMoney(double putThread) {
		System.out.println("当前账户中所剩余额为" + this.curveMoney + "; 存入金额为: "+ putThread);
		System.out.println("正在操作，请稍候......"); // 存钱时先等待300毫秒
		try {
			Thread.sleep(300); // 线程休眠
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("操作成功，存入金额：" + putThread);
		this.curveMoney = this.curveMoney + putThread;
		System.out.println("当前余额为：" + this.curveMoney + "元");
	}

	/**
	 * 同步机制取钱
	 * @param takeThread
	 */
	public synchronized void sync_WithdrawMoney(double takeThread) {
		System.out.println("查询余额显示，当前可用余额为：" + this.curveMoney + "; 取出金额为: " + takeThread);
		System.out.println("正在操作，请稍候......"); // 取钱时先等待500毫秒
		try {
			Thread.sleep(500); // 线程休眠
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("操作成功，取出金额：" + takeThread);
		this.curveMoney = this.curveMoney - takeThread;
		System.out.println("当前余额为：" + this.curveMoney + "元");
	}
}

//继承Thread类实现线程方法
class CashMachines extends Thread {
	private final double SAVE_MONEY_NUM = 800;
	private final double WITHDRAW_MONEY_NUM = 300;
	private Bank bank = null; // 待访问的帐号对象
	private SyncBank sbank = null; // 待访问的帐号对象
	private String account = ""; // 访问帐号的方法
	//普通银行类对应的构造方法
	public CashMachines(Bank bank, String account) {
		this.account = account;
		this.bank = bank;
	}
	//异步银行类对应的构造方法
	public CashMachines(SyncBank sbank, String account) {
		this.account = account;
		this.sbank = sbank;
	}

	@Override
	// 实现Thread的方法
	public void run() {
		// 根据参数调用不同的方法
		if (account.equals("saveMoney")) {
			bank.saveMoney(SAVE_MONEY_NUM);
		} else if (account.equals("withdrawMoney")) {
			bank.withdrawMoney(WITHDRAW_MONEY_NUM);
		} else if (account.equals("sync_SaveMoney")) {
			sbank.sync_SaveMoney(SAVE_MONEY_NUM);
		} else if (account.equals("sync_WithdrawMoney")) {
			sbank.sync_WithdrawMoney(WITHDRAW_MONEY_NUM);
		}
	}
}