package java_log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ������
 * @author ����
 */
public class LoggerAuditDynamicProxyTest {
	//This is a test
	public static void main(String[] args) {
		//ͨ��������ʵ����־�;���ҵ�����
		LogDynamicProxy lsp = new LogDynamicProxy();
		AuditInterface aiia = (AuditInterface) lsp.bind(new AuditInterfaceImplA());
		aiia.doAudit("����");

		AuditInterface aiib = (AuditInterface) lsp.bind(new AuditInterfaceImplB());
		aiib.doAudit("����");
	}
}


/**
 * ��˴�����ʵ�����������־���
 * ʵ�ֽӿ�InvocationHandler
 * ���÷������ʵ���������ҵ�������־�������
 */
class LogDynamicProxy implements InvocationHandler{
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private Object object;

	//�󶨴������
	public Object bind(Object object){
		this.object=object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
	}

	//��Խӿڱ��
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		try{
			logger.log(Level.INFO, args[0]+" ��ʼ����ҵ�񡣡���");
			result = method.invoke(object, args);
			logger.log(Level.INFO, args[0]+" ����ҵ�����������");
		}catch(Exception e){
			logger.log(Level.SEVERE,e.toString());
		}
		return result;
	}
}