package java_log;

/**
 * 数据审核接口实现类B
 */
class AuditInterfaceImplB implements AuditInterface{
	@Override
	public void doAudit(String name) {
		System.out.println(name+" 正在审核数据BBB。。。");
	}
}