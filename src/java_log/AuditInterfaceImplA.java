package java_log;

/**
 * ������˽ӿ�ʵ����A
 */
class AuditInterfaceImplA implements AuditInterface{
	@Override
	public void doAudit(String name) {
		System.out.println(name+" �����������AAA������");
	}
}