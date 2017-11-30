package java_redis;

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