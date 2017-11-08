package java_log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ������
 * @author ����
 */
public class LoggerAuditProxyTest {
	//This is a test
	public static void main(String[] args) {
		//ͨ��������ʵ����־�;���ҵ�����
		new AuditProxy(new AuditInterfaceImplA()).doAudit("����");
		new AuditProxy(new AuditInterfaceImplB()).doAudit("����");

	}
}

/**
 * ��˴�����ʵ��ҵ�������־���
 */
class AuditProxy{
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private AuditInterface ai;

	public AuditProxy(AuditInterface ai){
		this.ai=ai;
	}

	//ҵ������־���
	public void doAudit(String name) {
		logger.log(Level.INFO, name+" ��ʼ����ҵ�񡣡���");
		ai.doAudit(name);
		logger.log(Level.INFO, name+" ����ҵ�����������");
	}
}