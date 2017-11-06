package java_thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * 操作线程让步的类
 * @author 唐龙
 */
public class ThreadYield {
	//This is a test
	public static void main(String []args){
		Vector<String> vector=new Vector<>();
		new Yield(vector).start();
		new SendFile(vector).start();
	}
}

/**
 * 线程让步类
 * @author 唐龙
 */
class Yield extends Thread {
	private Vector<String> vector;
	private DateFormat dateFormat = new SimpleDateFormat("HH-mm-ss:SSSS");//日期格式
	private boolean isFlag = false;
	public Yield(Vector<String> vector) {
		super("接收文件");//设置线程名称
		this.setDaemon(true);//如果SendFile线程结束，则该线程自动结束
		this.vector=vector;
	}
	@Override
	public void run() {
		while (!isFlag) {
			try {
				Thread.sleep(100);//休眠0.1s
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			//判断向量集合大小
			if (vector.size()<=0) {
				System.out.println(dateFormat.format(new Date())+ "\t集合中没有文件，执行yield操作。");
				Thread.yield();//调用线程让步
			} else {
				String ss = vector.remove(0);
				System.out.println(dateFormat.format(new Date())+"\t取到文件：" + ss);
			}
		}
	}
}

/**
 * 发送文件
 * @author 唐龙
 */
class SendFile extends Thread {
	private String[] files = new String[] {"新闻文件", "国内旅游向导", "山水名画欣赏", "发家致富说明"};
	private Vector<String> vector;
	public SendFile(Vector<String> vector) {
		super("发送文件");
		this.vector=vector;
	}
	@Override
	public void run() {
		try {
			for (int i=0;i < files.length;i++){
				Thread.sleep(200);//线程休眠0.2s
				vector.add(files[i]);//添加文件
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}