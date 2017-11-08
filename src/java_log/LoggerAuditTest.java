package java_log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 测试类
 * @author 唐龙
 */
public class LoggerAuditTest {
	//This is a test
	public static void main(String[] args) {
		new LoggerAudit().doAudit("唐龙");
	}
}

/**
 * 数据审核类
 * @author 唐龙
 */
class LoggerAudit{
	private Logger logger = Logger.getLogger(this.getClass().getName());

	//审核方法
	public void doAudit(String name){
		logger.log(Level.INFO, name+"开始审核数据。。。");
		System.out.println(name+"审核数据。。。");
		logger.log(Level.INFO, name+"审核数据结束。。。");
	}
}