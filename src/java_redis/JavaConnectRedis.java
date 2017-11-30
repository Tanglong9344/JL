package java_redis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * Java 连接 Redis
 * 需要jedis-2.9.0.jar
 *
 * Redis 支持的数据类型:
 * 1.String
 * 2.List
 *
 * @author 唐龙
 */
public class JavaConnectRedis {
	public static void main(String[] args) {
		/**Connecting to Redis server on localhost*/
		Jedis jedis = new Jedis("localhost");
		System.out.println("Connection to server sucessfully\n");

		/**check whether server is running or not*/
		System.out.println("Server is running: "+jedis.ping());

		/**设置 redis 字符串数据*/
		jedis.set("rj", "Hello Redis in Java");
		// 获取存储的数据并输出
		System.out.println("String in redis: "+ jedis.get("rj"));

		/**存储数据到列表中*/
		jedis.lpush("list", "V1");
		jedis.lpush("list", "V2");
		jedis.lpush("list", "V3");
		// 获取存储的数据并输出
		List<String> list = jedis.lrange("list", 0 ,2);
		System.out.println("List in Redis: " + list);

		/**获取Redis 所有的key*/
		Set<String> keys = jedis.keys("*");
		System.out.println("All keys in Redis: " + keys);

		/** close redis */
		jedis.close();
	}
}