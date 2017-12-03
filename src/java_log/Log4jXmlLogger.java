package java_log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jXmlLogger {
	static Logger logger = Logger.getLogger(Log4jXmlLogger.class);
	public static void main(String[] args) throws InterruptedException {
		PropertyConfigurator.configure("src/java_log/log4j.xml");
		for (int i = 0; i < 5; i++) {
			logger.trace("跟踪信息");
			logger.debug("调试信息");
			logger.info("输出信息");
			logger.warn("警告信息");
			logger.error("错误信息");
			logger.fatal("致命信息");
		}
	}
}