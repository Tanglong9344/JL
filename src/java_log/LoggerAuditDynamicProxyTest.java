package java_log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 测试类
 * @author 唐龙
 */
public class LoggerAuditDynamicProxyTest {
	//This is a test
	public static void main(String[] args) {
		//通过代理类实现日志和具体业务分离
		LogDynamicProxy lsp = new LogDynamicProxy();
		AuditInterface aiia = (AuditInterface) lsp.bind(new AuditInterfaceImplA());
		aiia.doAudit("唐龙");

		AuditInterface aiib = (AuditInterface) lsp.bind(new AuditInterfaceImplB());
		aiib.doAudit("唐龙");
	}
}


/**
 * 审核代理类实现事务处理和日志输出
 * 实现接口InvocationHandler
 * 利用反向代理实现所有类的业务处理和日志输出分离
 */
class LogDynamicProxy implements InvocationHandler{
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private Object object;

	//绑定代理对象
	public Object bind(Object object){
		this.object=object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
	}

	//针对接口编程
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		try{
			logger.log(Level.INFO, args[0]+" 开始处理业务。。。");
			result = method.invoke(object, args);
			logger.log(Level.INFO, args[0]+" 处理业务结束。。。");
		}catch(Exception e){
			logger.log(Level.SEVERE,e.toString());
		}
		return result;
	}
}