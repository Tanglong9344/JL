/**
 * 获取当前运行环境并执行cmd命令
 */

package java_core_basic;

public class JavaRunTime {
	public static void main(String[] args) {
		Process p=null;//创建进程
		try{
			//打开系统计算器
			p=Runtime.getRuntime().exec("calc");
			//执行javac命令，编译Test.java源文件
			//p=Runtime.getRuntime().exec("javac F:\\Test.java");
			//使用记事本打开Test.java源文件
			//p=Runtime.getRuntime().exec("notepad F:\\Test.java");
			Thread.sleep(5000);//暂停5s
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			p.destroy();//销毁进程
		}
	}
}