package club.ppxia.core.util;

import club.ppxia.core.util.abstracted.AbstractJedisUtil;
import lombok.Setter;
import redis.clients.jedis.JedisSentinelPool;

/**
 * Created by xiaoxuwang on 2019/6/3.
 */
@Setter
public class Jedis4DB0 extends AbstractJedisUtil{

    public Jedis4DB0(JedisSentinelPool jedisSentinelPool) {
        super(jedisSentinelPool);
    }

}
