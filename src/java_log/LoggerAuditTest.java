package java_log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ������
 * @author ����
 */
public class LoggerAuditTest {
	//This is a test
	public static void main(String[] args) {
		new LoggerAudit().doAudit("����");
	}
}

/**
 * ���������
 * @author ����
 */
class LoggerAudit{
	private Logger logger = Logger.getLogger(this.getClass().getName());

	//��˷���
	public void doAudit(String name){
		logger.log(Level.INFO, name+"��ʼ������ݡ�����");
		System.out.println(name+"������ݡ�����");
		logger.log(Level.INFO, name+"������ݽ���������");
	}
}