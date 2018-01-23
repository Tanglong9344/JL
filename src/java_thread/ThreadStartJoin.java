package java_thread;

/**
 * Thread join
 *
 * @author 唐龙
 *
 */
public class ThreadStartJoin {
	public static void main(String[] args) throws InterruptedException {
		final int MARRY_NUMBER = 100;//匹配对数
		for(int i=1;i<=MARRY_NUMBER;i++){
			MatchMarry group = new MatchMarry("Boy-"+i, "Girl-"+i);
			group.start();//启动线程
			group.join();//等待该线程运行结束
		}
		System.out.println("速配结束...");
	}
}

/** 测试匹配结婚的类 */
class MatchMarry extends Thread {
	private String name;//人员名称
	private String otherName;//结婚对象
	private boolean isMarry = false;//是否结婚
	public MatchMarry(String name, String otherName) {
		this.name = name;
		this.otherName = otherName;
	}
	@Override
	public void run() {
		try {
			int person = (int) Math.floor((Math.random() * 10 + 1));// 获得随机数
			if (person % 2 == 0) {
				isMarry = true;//设置标识
			} else {
				isMarry = false;
			}
			if (!isMarry) {
				System.out.println(name + " 可以与 " + otherName + " 结婚，祝福你们");
			} else {
				System.out.println(otherName + " 已婚。");
			}
			Thread.sleep(10);//线程休眠10ms
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}