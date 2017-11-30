package java_redis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * Java ���� Redis
 * ��Ҫjedis-2.9.0.jar
 *
 * Redis ֧�ֵ���������:
 * 1.String
 * 2.List
 *
 * @author ����
 */
public class JavaConnectRedis {
	public static void main(String[] args) {
		/**Connecting to Redis server on localhost*/
		Jedis jedis = new Jedis("localhost");
		System.out.println("Connection to server sucessfully\n");

		/**check whether server is running or not*/
		System.out.println("Server is running: "+jedis.ping());

		/**���� redis �ַ�������*/
		jedis.set("rj", "Hello Redis in Java");
		// ��ȡ�洢�����ݲ����
		System.out.println("String in redis: "+ jedis.get("rj"));

		/**�洢���ݵ��б���*/
		jedis.lpush("list", "V1");
		jedis.lpush("list", "V2");
		jedis.lpush("list", "V3");
		// ��ȡ�洢�����ݲ����
		List<String> list = jedis.lrange("list", 0 ,2);
		System.out.println("List in Redis: " + list);

		/**��ȡRedis ���е�key*/
		Set<String> keys = jedis.keys("*");
		System.out.println("All keys in Redis: " + keys);

		/** close redis */
		jedis.close();
	}
}