package java_core_basic;

/**
 * <b>System.getProperty ����</b><br/>
 * @author ����
 */
public class SystemGetPropertyTest {
	public static void main(String args[]) {
		// Java ����ʱ�����汾
		System.out.println("java_version:" + System.getProperty("java.version"));
		// Java ����ʱ������Ӧ��
		System.out.println("java_vendor:" + System.getProperty("java.vendor"));
		// Java ��Ӧ�̵� URL
		System.out.println("java_vendor_url:" + System.getProperty("java.vendor.url"));
		// Java ��װĿ¼
		System.out.println("java_home:" + System.getProperty("java.home"));
		// Java ���ʽ�汾��
		System.out.println("java_class_version:" + System.getProperty("java.class.version"));
		// Java ��·��
		System.out.println("java_class_path:" + System.getProperty("java.class.path"));
		// ����ϵͳ������
		System.out.println("os_name:" + System.getProperty("os.name"));
		// ����ϵͳ�ļܹ�
		System.out.println("os_arch:" + System.getProperty("os.arch"));
		// ����ϵͳ�İ汾
		System.out.println("os_version:" + System.getProperty("os.version"));
		// �û����˻�����
		System.out.println("user_name:" + System.getProperty("user.name"));
		// �û�����Ŀ¼
		System.out.println("user_home:" + System.getProperty("user.home"));
		// �û��ĵ�ǰ����Ŀ¼
		System.out.println("user_dir:" + System.getProperty("user.dir"));
		// Java ������淶�汾
		System.out.println("java_vm_specification_version:" + System.getProperty("java.vm.specification.version"));
		// Java ������淶��Ӧ��
		System.out.println("java_vm_specification_vendor:" + System.getProperty("java.vm.specification.vendor"));
		// Java ������淶����
		System.out.println("java_vm_specification_name:" + System.getProperty("java.vm.specification.name"));
		// Java �����ʵ�ְ汾
		System.out.println("java_vm_version:" + System.getProperty("java.vm.version"));
		// Java �����ʵ�ֹ�Ӧ��
		System.out.println("java_vm_vendor:" + System.getProperty("java.vm.vendor"));
		// Java �����ʵ������
		System.out.println("java_vm_name:" + System.getProperty("java.vm.name"));
		// һ��������չĿ¼��·��
		System.out.println("java_ext_dirs:" + System.getProperty("java.ext.dirs"));
		// �ļ��ָ���
		System.out.println("file_separator:" + System.getProperty("file.separator"));
		// ·���ָ���
		System.out.println("path_separator:" + System.getProperty("path.separator"));
		// �зָ���
		System.out.println("line_separator:" + System.getProperty("line.separator"));
		// Java ����ʱ�����淶�汾
		System.out.println("java.specification.version:" + System.getProperty("java.specification.version"));
		// Java ����ʱ�����淶��Ӧ��
		System.out.println("java.specification.vendor:" + System.getProperty("java.specification.vendor"));
		// Java ����ʱ�����淶����
		System.out.println("java.specification.name:" + System.getProperty("java.specification.name"));
		// ���ؿ�ʱ������·���б�
		System.out.println("java.library.path:" + System.getProperty("java.library.path"));
		// Ĭ�ϵ���ʱ�ļ�·��
		System.out.println("java.io.tmpdir:" + System.getProperty("java.io.tmpdir"));
		// Ҫʹ�õ� JIT ������������
		System.out.println("java.compiler:" + System.getProperty("java.compiler"));
	}
}