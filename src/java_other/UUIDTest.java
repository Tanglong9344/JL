package java_other;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Java UUID
 *
 * @author ����
 */
public class UUIDTest {
	public static void main(String[] args) {
		final int N = 10;
		List<String> uuidList = new ArrayList<String>();
		//���ݳ�ʼ��
		for(int i=0;i<N;i++) {
			uuidList.add(UUID.randomUUID().toString().replace("-",""));
		}
		//�����ʾ
		uuidList.forEach(uuid->System.out.println("32λUUID:"+uuid));
	}
}