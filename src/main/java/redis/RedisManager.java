package redis;/**
 * Created by shenwei on 2017/2/16.
 */

import redis.clients.jedis.Jedis;

/**
 * @author shenwei
 * @create 2017-02-16
 */
public class RedisManager {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("dev-3rdcc.kzpcbh.ng.0001.apse1.cache.amazonaws.com:6379");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }
}
