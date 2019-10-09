package com.jsg;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 测试服务A启动入口
 *
 * @author weidong
 * @date 2019/6/3
 */
@EnableDistributedTransaction
@EnableDiscoveryClient
@EnableFeignClients
@EnableConfigurationProperties
@SpringBootApplication
@MapperScan("com.jsg.dao")
public class TestAServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestAServiceApplication.class, args);
    }

}
