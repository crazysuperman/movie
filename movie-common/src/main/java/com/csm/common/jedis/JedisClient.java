package com.csm.common.jedis;

import java.util.List;

/**
 * 封装redis各种基本类型的命令行
 * User: DHC
 * Date: 2018/11/2
 * Time: 9:48
 * Version:V1.0
 */
public interface JedisClient {
    /**
     * String,Hash,List,Set,ZSet
     */
    String set(String key, String value);

    String get(String key);

    Boolean exists(String key);

    Long expire(String key, int seconds);

    Long ttl(String key);

    Long incr(String key);

    Long del(String key);

    //封装Hash类型
    Long hset(String key, String field, String value);

    String hget(String key, String field);

    Long hdel(String key, String... field);

    Boolean hexists(String key, String field);

    List<String> hvals(String key);

    //封装List类型
    Long lpush(String key, String... strings);

    List<String> lrange(String key, long start, long end);

}
