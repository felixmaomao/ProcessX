package redis.test;/**
 * Created by shenwei on 2017/2/16.
 */

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * @author shenwei
 * @create 2017-02-16
 */
public class PipelineTest {
    public static void main(String[] args) {
        Jedis client = new Jedis("10.33.97.251", 6379);
        Pipeline pipe = client.pipelined();
        for (Integer i = 0; i < 10; i++) {
            //批量set
            pipe.set("testkey"+i,"testvalue"+i);
        }
        pipe.sync();
        client.disconnect();
    }
}
