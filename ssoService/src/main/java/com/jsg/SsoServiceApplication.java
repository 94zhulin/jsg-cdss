package com.jsg;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 單點登錄入口
 *
 * @author jeanson
 * @date 2019/10/08
 */
@EnableDistributedTransaction
@EnableDiscoveryClient
@EnableFeignClients
@EnableConfigurationProperties
@SpringBootApplication
@MapperScan("com.gg.dao")
public class SsoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoServiceApplication.class, args);
    }

}
