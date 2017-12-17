package something_interesting;

/**
 * ATM ģ��
 *
 * @author ����
 *
 */
public class ATMCashMachines {
	public static void main(String[] args) {
		// ʵ����Bank����
		Bank bank = new Bank();
		System.out.println("1.�桢ȡ�߳�û�в�ȡͬ��ʱ��ִ�д�ȡ����ʱ���乤���������£�");
		// ��Ǯû�в���ͬ������
		Thread putThread = new CashMachines(bank, "saveMoney");
		// ȡǮû��ͬ������
		Thread takeThread = new CashMachines(bank, "withdrawMoney");
		putThread.start(); // ����putThread�߳�
		takeThread.start(); // ����takeThread�߳�
		try {
			putThread.join(); // �ȴ����߳����н���
			takeThread.join();
		} catch (Exception e) {
			System.out.println("���߳����г���" + e.getMessage());
		}
		System.out.println();
		// ʵ����SyncBank����
		SyncBank sbank = new SyncBank();
		System.out.println("2.�桢ȡ�߳�����Ϊͬ��ʱ��ִ�д�ȡ����ʱ���乤���������£�");
		putThread = new CashMachines(sbank, "sync_SaveMoney"); // ����CashMachines���󣬴�Ǯ��ͬ������
		takeThread = new CashMachines(sbank, "sync_WithdrawMoney"); // ȡǮ��ͬ������
		putThread.start(); // �����߳�
		takeThread.start(); // �����߳�
	}
}

/**��ͨ������*/
class Bank {
	private double curveMoney = 174.85; // �������е�Ǯ��

	// ��Ǯû�в���ͬ������
	public void saveMoney(double putThread) {
		System.out.println("��ǰ�˻�����ʣ���Ϊ" + this.curveMoney + "; ������Ϊ: " + putThread);
		System.out.println("���ڲ��������Ժ�......"); // ��Ǯʱ�ȵȴ�300����
		try {
			Thread.sleep(300); // �߳�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�����ɹ��������" + putThread);
		this.curveMoney = this.curveMoney + putThread;
		System.out.println("��ǰ���Ϊ��" + this.curveMoney + "Ԫ");
	}

	// ȡǮû��ͬ������
	public void withdrawMoney(double takeThread) {
		System.out.println("��ѯ�����ʾ����ǰ�������Ϊ��" + this.curveMoney + "; ȡ�����Ϊ: " + takeThread);
		System.out.println("���ڲ��������Ժ�......"); // ȡǮʱ�ȵȴ�500����
		try {
			Thread.sleep(500); // �߳�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�����ɹ���ȡ����" + takeThread);
		this.curveMoney = this.curveMoney - takeThread;
		System.out.println("��ǰ���Ϊ��" + this.curveMoney + "Ԫ");
	}
}

/**ͬ��������*/
class SyncBank {
	private double curveMoney = 174.85; // �������е�Ǯ��

	/**
	 * ��ͬ�����ƴ�Ǯ
	 * @param putThread
	 */
	public synchronized void sync_SaveMoney(double putThread) {
		System.out.println("��ǰ�˻�����ʣ���Ϊ" + this.curveMoney + "; ������Ϊ: "+ putThread);
		System.out.println("���ڲ��������Ժ�......"); // ��Ǯʱ�ȵȴ�300����
		try {
			Thread.sleep(300); // �߳�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�����ɹ��������" + putThread);
		this.curveMoney = this.curveMoney + putThread;
		System.out.println("��ǰ���Ϊ��" + this.curveMoney + "Ԫ");
	}

	/**
	 * ͬ������ȡǮ
	 * @param takeThread
	 */
	public synchronized void sync_WithdrawMoney(double takeThread) {
		System.out.println("��ѯ�����ʾ����ǰ�������Ϊ��" + this.curveMoney + "; ȡ�����Ϊ: " + takeThread);
		System.out.println("���ڲ��������Ժ�......"); // ȡǮʱ�ȵȴ�500����
		try {
			Thread.sleep(500); // �߳�����
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�����ɹ���ȡ����" + takeThread);
		this.curveMoney = this.curveMoney - takeThread;
		System.out.println("��ǰ���Ϊ��" + this.curveMoney + "Ԫ");
	}
}

//�̳�Thread��ʵ���̷߳���
class CashMachines extends Thread {
	private final double SAVE_MONEY_NUM = 800;
	private final double WITHDRAW_MONEY_NUM = 300;
	private Bank bank = null; // �����ʵ��ʺŶ���
	private SyncBank sbank = null; // �����ʵ��ʺŶ���
	private String account = ""; // �����ʺŵķ���
	//��ͨ�������Ӧ�Ĺ��췽��
	public CashMachines(Bank bank, String account) {
		this.account = account;
		this.bank = bank;
	}
	//�첽�������Ӧ�Ĺ��췽��
	public CashMachines(SyncBank sbank, String account) {
		this.account = account;
		this.sbank = sbank;
	}

	@Override
	// ʵ��Thread�ķ���
	public void run() {
		// ���ݲ������ò�ͬ�ķ���
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