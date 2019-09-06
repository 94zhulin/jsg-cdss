package com.jsg.utils;

/**
 * 常量定义
 *
 * @author weidong
 * @date 2018/7/24
 */
public interface Constants {
    // redis
    int REDIS_EXPIRE = 60000;// 缓存生存时间
    int REDIS_MAXTOTAL = 500;
    int REDIS_MAXIDLE = 20;
    long REDIS_MAXWAITMILLIS = 100 * 100;
    String[] REDIS_SENHOSTS = {"192.168.1.20:26379", "192.168.1.20:27379", "192.168.1.20:28379"};// 哨兵IP列表
    String REDIS_CLUSTERNAME = "mymaster";
    String REDIS_PASSWORD = "123456";

    // rocketMQ
    String ROCKETMQ_PRODUCER_NAMESRVADDR = "192.168.1.20:9876;192.168.1.21:9876";
    String ROCKETMQ_PRODUCER_GROUPNAME = "hisProducerGroup";
    String ROCKETMQ_PRODUCER_TOPIC = "test";
    String ROCKETMQ_PRODUCER_TAG = "test";

    String ROCKETMQ_CONSUMER_NAMESRVADDR = "192.168.1.20:9876;192.168.1.21:9876;192.168.1.22:9876;192.168.1.23:9876";
    String ROCKETMQ_CONSUMER_GROUPNAME = "hisProducerGroup";
    String ROCKETMQ_CONSUMER_TOPIC = "test";
    String ROCKETMQ_CONSUMER_TAG = "test";
}