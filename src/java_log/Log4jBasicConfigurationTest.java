package java_log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Log4jBasicConfigurationTest {
	static Logger logger = Logger.getLogger(Log4jBasicConfigurationTest.class);
	public static void main(String[] args) throws InterruptedException {
		BasicConfigurator.configure();
		for (int i = 0; i < 5; i++) {
			logger.trace("������Ϣ");
			logger.debug("������Ϣ");
			logger.info("�����Ϣ");
			logger.warn("������Ϣ");
			logger.error("������Ϣ");
			logger.fatal("������Ϣ");
		}
	}
}
