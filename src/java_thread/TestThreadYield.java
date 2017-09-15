package java_thread;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * 操作线程让步的类
 * @author 唐龙
 */
public class TestThreadYield {
	private Vector<String> vector = new Vector<String>();// 创建向量集合
	// 创建日期格式
	private DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss:SSSS");
	private boolean isFlag = false;
	private class Yield extends Thread {
		public Yield() {
			this.setName("接收文件");//设置线程名称
			this.setDaemon(true);// 如果SendFile线程结束，则该线程自动结束
		}
		@Override
		public void run() {
			// 标识为真退出循环
			while (!isFlag) {
				try {
					Thread.sleep(100);// 休眠
				}catch(InterruptedException e){
					System.out.println("唤醒异常:"+e.getMessage());
				}
				//判断向量集合大小
				if (0 == vector.size()) {
					System.out.println(dateFormat.format(new Date())+ "\t向量集合中没有文件，执行yield操作");
					Thread.yield();//调用线程让步
				} else {//移队文件获得对象
					String ss = vector.remove(0);
					System.out.println(dateFormat.format(new Date())+"\t取到文件，名为" + ss);
				}
			}
		}
	}

	/**
	 * 发送文件类线程
	 * @author 唐龙
	 *
	 */
	private class SendFile extends Thread {
		private String[] files = new String[] { "新闻文件", "国内旅游向导", "山水名画欣赏", "发家致富说明" };
		public SendFile() {
			this.setName("发送文件");
		}
		@Override
		public void run() {
			try {
				//循环使线程休眠
				for (int i=0;i < files.length;i++){
					Thread.sleep(200);//线程休眠
					vector.add(files[i]);//添加文件
				}
				Thread.sleep(100);//线程休眠
			} catch (InterruptedException e) {
				System.out.println("唤醒异常:"+e.getMessage());
			}
		}
	}
	public static void main(String []args){
		TestThreadYield test=new TestThreadYield();
		test.new Yield().start();//实例对象启动线程
		test.new SendFile().start();
	}
}