package club.ppxia.core.config;

import club.ppxia.core.util.Jedis4DB0;
import club.ppxia.core.util.abstracted.AbstractJedis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaoxuwang on 2019/6/3.
 */
@Slf4j
public class JedisConfig {

    @Value("${spring.redis.password}")
    private String redisPassword;

    @Value("${spring.redis.timeout}")
    private int redisTimeout;

    @Value("${spring.redis.pool.max-active}")
    private int redisPoolMaxActive;

    @Value("${spring.redis.pool.max-idle}")
    private int redisPoolMaxIdle;

    @Value("${spring.redis.pool.min-idle}")
    private int redisPoolMinIdle;

    @Value("${spring.redis.pool.max-wait}")
    private long redisPoolMaxWait;

    @Value("${spring.redis.sentinel.master}")
    private String masterName;

    @Value("${spring.redis.sentinel.nodes}")
    private String nodes;

    private JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisPoolMaxIdle);
        poolConfig.setMinIdle(redisPoolMinIdle);
        poolConfig.setMaxWaitMillis(redisPoolMaxWait);
        poolConfig.setMaxTotal(redisPoolMaxActive);
        log.info(this.toString());
        return poolConfig;
    }

    private JedisSentinelPool getJedisSentinelPool0() {
        Set<String> nodeSet = new HashSet<>();
        String[] nodeArray = nodes.split(",");
        for (String node : nodeArray) {
            log.info("Read node : {}。", node);
            nodeSet.add(node);
        }
        return new JedisSentinelPool(masterName, nodeSet, getJedisPoolConfig(), redisTimeout, redisPassword, 0);
    }

    @Bean(name = "jedis0")
    public AbstractJedis getJedisUtil() {
        return new Jedis4DB0(getJedisSentinelPool0());
    }

}
