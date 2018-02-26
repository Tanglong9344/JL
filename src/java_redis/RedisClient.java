package java_redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * Java ���� Redis
 * ��Ҫjedis-2.9.0.jar
 *
 * Redis ֧�ֵ���������:
 * 1.String
 * 2.List
 * 3.Map
 * 4.Set
 *
 * @author ����
 */
public class RedisClient{
	private Jedis jedis;
	private static final String IP = "127.0.0.1";
	private static final int PORT = 6379;
	private static final String PWD = "123456";

	public void connect(){
		/**Connecting to Redis server 1270.0.1:6379*/
		jedis = new Jedis(IP,PORT);

		/**Authorization*/
		jedis.auth(PWD);

		System.out.println("Connection to server sucessfully");

		/**check whether server is running or not*/
		System.out.println("Server is running: "+jedis.ping());
	}

	public void close(){
		/**close redis*/
		jedis.close();
	}

	public void stringTest(){
		System.out.println("-------------String in Redis-------------");
		/**���� redis �ַ�������*/
		jedis.set("st", "Hello Redis");
		// ��ȡ�洢�����ݲ����
		System.out.println("String in redis: "+ jedis.get("st"));

		/**���ö��ֵ��*/
		jedis.mset("name","Tanglong","age","666");
		System.out.printf("name: %s,age: %s%n",jedis.get("name"),jedis.get("age"));

		/**+1����*/
		jedis.incr("age");
		System.out.printf("name: %s,age: %s%n",jedis.get("name"),jedis.get("age"));

		/**ƴ��*/
		jedis.append("st", ",I am Tanglong.");
		// ��ȡ�洢�����ݲ����
		System.out.println("String in redis: "+ jedis.get("st"));

		/**ɾ��*/
		jedis.set("del", "Hello Redis,Del");
		System.out.println("String in redis: "+ jedis.get("del"));
		jedis.del("del");
	}

	public void listTest(){
		System.out.println("-------------List in Redis-------------");
		/**del*/
		jedis.del("list");
		/**�洢���ݵ��б���*/
		/**add to the left of the list*/
		jedis.lpush("list", "V1");
		jedis.lpush("list", "V2");
		jedis.lpush("list", "V3");
		/**add to the right of the list*/
		jedis.rpush("list", "V4");
		jedis.rpush("list", "V5");
		jedis.rpush("list", "V6");
		// ��ȡ�洢�����ݲ����
		List<String> list = jedis.lrange("list", 0 ,jedis.llen("list"));
		System.out.println("length of list: "+jedis.llen("list"));
		System.out.println("List in Redis: " + list);
	}

	public void mapTest(){
		System.out.println("-------------Map in Redis-------------");
		Map<String,String> map = new HashMap<String,String>();
		for(int i=1;i<5;i++){
			map.put("k"+i, "v"+i);
		}
		/**set*/
		jedis.hmset("map",map);
		List<String> list = jedis.hmget("map","k1","k2","k3","k4","k5");
		System.out.println("map in Redis"+list);

		/**del*/
		jedis.hdel("map", "k1");
		System.out.println("k1 in map: "+jedis.hmget("map","k1"));
		System.out.println("length of map: "+jedis.hlen("map"));
		System.out.println("map is exists or not: "+jedis.exists("map"));
		System.out.println("all keys in map: "+jedis.hkeys("map"));
		System.out.println("all values in map: "+jedis.hvals("map"));
	}

	public void setTest(){
		System.out.println("-------------Set in Redis-------------");
		/**add*/
		jedis.sadd("sets","s1");
		jedis.sadd("sets","s2");
		jedis.sadd("sets","s3");
		jedis.sadd("sets","s4");

		System.out.println("all members in sets: "+jedis.smembers("sets"));
		jedis.srem("sets","s1");// remove member s1 in sets
		System.out.println("s1 is member of sets or not: "+jedis.sismember("sets","s1"));
		System.out.println("The number in the sets: "+jedis.scard("sets"));
		System.out.println("randomly get a member of sets: "+jedis.srandmember("sets"));
	}

	public void keysTest(){
		System.out.println("-------------Key in Redis-------------");

		/**��ȡRedis ���е�key*/
		Set<String> keys = jedis.keys("*");
		System.out.println("All keys in Redis: " + keys);
	}

	public void sortTest(){
		System.out.println("-------------Sort in Redis-------------");

		final int N = 5;//���ݸ���
		final int RANGE = 100;//��ֵ��Χ
		Random random = new Random();
		jedis.del("lsort");
		//all the values have to be able to be converted to numbers
		for(int i=0;i<N;i++) {
			jedis.lpush("lsort",""+random.nextInt(RANGE));
		}
		System.out.println("Before sort: "+jedis.lrange("lsort",0,jedis.llen("lsort")));
		/**sort*/
		System.out.println("After sort : "+jedis.sort("lsort"));
	}
}