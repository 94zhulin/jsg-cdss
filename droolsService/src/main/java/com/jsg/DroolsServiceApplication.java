package com.jsg;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author weidong
 * @date 2019/6/3
 */
@EnableDistributedTransaction
@EnableDiscoveryClient
@EnableFeignClients
@EnableConfigurationProperties
@SpringBootApplication
@MapperScan("com.jsg.dao")
public class DroolsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DroolsServiceApplication.class, args);
    }

}
