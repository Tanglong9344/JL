package something_interesting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ResourceFile {
	static boolean isStop = false;// 标识线程是否停止
	static List<String> taskList = new ArrayList<String>();// 创建集合列表对象
	static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// 创建模拟搜索资源并下载文件类
	private class SearchDownload extends Thread {
		private String[] file = new String[] { "51Upload_Setup.exe","eclipse-SDK-3.2.1-win32.zip", "EditPlus.rar" };
		// 创建模拟下载时所搜索的资源内容
		private String[] resource = new String[] { "开始连接......",
				"开始搜索候选资源......", "没搜索到候选资源，稍后重试搜索",
				"原始资源连接成功，得到的文件长度： 7725816", "开始创建文件......",
				"文件创建成功，开始下载数据......", "用户取消下载" };
		int sum = 0;//下载一个任务时用的总时间
		int time = 0;//搜索一个资源时用的时间
		@Override
		// 实现线程类的方法
		public void run() {
			for (int i = 0; i < file.length; i++) {
				System.out.println("开始下载第" + (i + 1) + "个文件");
				try {
					for (int j = 0; j < resource.length; j++) {
						System.out.println(dateFormat.format(new Date()) + " "+ resource[j]);
						time = new Random().nextInt(100);// 获得随机生成的秒数
						Thread.sleep(time);// 线程休眠等待
						sum = sum + time;
					}
					System.out.println(dateFormat.format(new Date()) + " 下载文件" + file[i] + "用时" + sum + " 毫秒. ");
					Thread.sleep(time);// 线程休眠等待
				} catch (Exception e) {// 捕获异常
					System.out.println("下载文件出错：" + e.getMessage());
				}
				synchronized (taskList) {// 实现同步
					System.out.println(dateFormat.format(new Date()) + " " + file[i] + "文件已下载完毕！");
					taskList.add(file[i]);// 将文件添加到集合列表中
					taskList.notify();// 通报所有等待的fileList的线程
				}
				sum = 0;
			}
			isStop = true;// 重新设置标识
			System.out.println(dateFormat.format(new Date()) + " 下载线程　退出");
			//使用函数式输出下载的文件
			taskList.forEach(file->System.err.println("下载的文件："+file));
		}
	}
	public static void main(String[] args) {
		ResourceFile test = new ResourceFile();
		// 实例化内部类并启动线程
		test.new SearchDownload().start();
	}
}