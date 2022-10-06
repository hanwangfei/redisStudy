import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JedisStudy {
    public static void main(String[] args) {
        //创建jedis对象，指明连接Ip和端口号，端口号如果是默认的6379可以省略
        Jedis jedis = new Jedis("localhost",6379);
        jedis.auth("root");
        jedis.select(1);

        //字符串
        jedis.set("sn","7791-3902");
        String sn = jedis.get("sn");
        System.out.println(sn);

        jedis.mset("title","奶粉","num","20");

        List<String>goods = jedis.mget("sn","title","num");
        System.out.println(goods.toString());
        Long num = jedis.incr("num");
        System.out.println(num);


        //Hash
        jedis.hset("student:3312","name","小明");
        String name = jedis.hget("student:3312","name");
        System.out.println(name);

        Map<String,String> stuMap = new HashMap();
        stuMap.put("name","李兰");
        stuMap.put("age","18");
        stuMap.put("id","3313");
        jedis.hmset("student:3313",stuMap);
        System.out.println(jedis.hgetAll("student:3313"));


        //list
        jedis.del("letter");
        jedis.rpush("letter","d","e","f");
        jedis.lpush("letter","c","b","a");
        System.out.println(jedis.lrange("letter",0,-1));
        jedis.lpop("letter");
        jedis.rpop("letter");
        System.out.println(jedis.lrange("letter",0,-1));

        jedis.close();
    }
}
