package java_log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 测试类
 * @author 唐龙
 */
public class LoggerAuditProxyTest {
	//This is a test
	public static void main(String[] args) {
		//通过代理类实现日志和具体业务分离
		new AuditProxy(new AuditInterfaceImplA()).doAudit("唐龙");
		new AuditProxy(new AuditInterfaceImplB()).doAudit("唐龙");

	}
}

/**
 * 审核代理类实现业务处理和日志输出
 */
class AuditProxy{
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private AuditInterface ai;

	public AuditProxy(AuditInterface ai){
		this.ai=ai;
	}

	//业务处理，日志输出
	public void doAudit(String name) {
		logger.log(Level.INFO, name+" 开始处理业务。。。");
		ai.doAudit(name);
		logger.log(Level.INFO, name+" 处理业务结束。。。");
	}
}