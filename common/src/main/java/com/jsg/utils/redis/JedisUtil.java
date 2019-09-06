package com.jsg.utils.redis;

import com.jsg.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * Redis工具类
 *
 * @author weidong
 * @date 2018/7/24
 */
public class JedisUtil {
    private static Logger logger = LoggerFactory.getLogger(JedisUtil.class);

    /**
     * Redis连接实例对象线程池
     */
    private static JedisSentinelPool jedisPool = null;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        // 控制一个pool可分配多少个jedis实例；
        // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
        config.setMaxTotal(Constants.REDIS_MAXTOTAL);
        // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(Constants.REDIS_MAXIDLE);
        // #链接最大等待时间 （毫秒）;
        config.setMaxWaitMillis(Constants.REDIS_MAXWAITMILLIS);
        // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        // config.setTestOnBorrow(true);

        Set<String> sentinels = new HashSet<String>();
        for (String host : Constants.REDIS_SENHOSTS) {
            sentinels.add(host);
        }

        jedisPool = new JedisSentinelPool(Constants.REDIS_CLUSTERNAME, sentinels, config, Constants.REDIS_PASSWORD);
    }

    /**
     * 获取Jedis对象
     *
     * @return
     */
    public static synchronized Jedis getJedis() {
        Jedis jedis = null;
        if (jedisPool != null) {
            try {
                if (jedis == null) {
                    jedis = jedisPool.getResource();
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return jedis;
    }

    /**
     * 回收jedis(放到finally中)
     *
     * @param jedis
     */
    public static synchronized void returnResource(Jedis jedis) {
        if (null != jedis && null != jedisPool) {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 销毁连接(放到catch中)
     *
     * @param jedis
     */
    public static synchronized void returnBrokenResource(Jedis jedis) {
        if (null != jedis && null != jedisPool) {
            jedisPool.returnResource(jedis);
        }
    }

    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedis();
        if (jedis == null) {
            throw new NullPointerException("Jedis is Null");
        }
        try {
            // jedis.set("K1", "001");
            // jedis.set("K2", "002");
            // jedis.set("K3", "003");
            System.out.println(jedis.get("K3"));
        } catch (Exception e) {
            JedisUtil.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            JedisUtil.returnResource(jedis);
        }

    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param seconds
     */
    public void expire(String key, int seconds) {
        if (seconds <= 0) {
            return;
        }
        Jedis jedis = getJedis();
        jedis.expire(key, seconds);
        returnResource(jedis);
    }

    /**
     * 设置默认过期时间
     *
     * @param key
     */
    public void expire(String key) {
        expire(key, Constants.REDIS_EXPIRE);
    }
}