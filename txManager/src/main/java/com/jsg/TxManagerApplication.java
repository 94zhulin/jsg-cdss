package com.jsg;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动入口
 *
 * @author weidong
 * @date 2019/6/3
 */

@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagerServer
//@EnableAutoConfiguration(exclude = {DruidDataSourceAutoConfigure.class})
public class TxManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TxManagerApplication.class, args);
    }

}
