package java_log;

/**
 * ������˽ӿ�ʵ����B
 */
class AuditInterfaceImplB implements AuditInterface{
	@Override
	public void doAudit(String name) {
		System.out.println(name+" �����������BBB������");
	}
}