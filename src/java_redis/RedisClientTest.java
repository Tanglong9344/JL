package java_redis;

/**
 * Test for RedisClient
 *
 * @author ÌÆÁú
 *
 */
public class RedisClientTest {
	public static void main(String[] args) {
		RedisClient redisClient = new RedisClient();
		redisClient.connect();
		redisClient.stringTest();
		redisClient.listTest();
		redisClient.mapTest();
		redisClient.setTest();
		redisClient.keysTest();
		redisClient.sortTest();
		redisClient.close();
	}
}