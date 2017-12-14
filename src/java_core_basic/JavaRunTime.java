package java_core_basic;

import java.lang.reflect.InvocationTargetException;

/**
 * 获取当前运行环境并执行cmd命令
 * @author 唐龙
 */
public class JavaRunTime {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException {
		Process p1 = null,p2 = null,p3 = null;//创建进程
		Runtime runTime = Runtime.getRuntime();
		try{
			//打开系统计算器
			p1 = runTime.exec("calc");
			//执行javac命令，编译Test.java源文件
			p2 = runTime.exec("javac F:\\Test.java");
			//使用记事本打开Test.java源文件
			p3 = runTime.exec("notepad F:\\Test.java");
			Thread.sleep(3000);//暂停3s
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			p2.destroy();//销毁进程
			p3.destroy();//销毁进程
			p1.destroy();//销毁进程
		}
	}
}