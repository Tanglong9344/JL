package java_common;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UUIDTest {
	public static void main(String[] args) {
		final int N = 10;
		List<String> uuidList = new ArrayList<String>();
		//数据初始化
		for(int i=0;i<N;i++) {
			uuidList.add(UUID.randomUUID().toString().replace("-",""));
		}
		//输出显示
		uuidList.forEach(uuid->System.out.println("32位UUID:"+uuid));
	}
}