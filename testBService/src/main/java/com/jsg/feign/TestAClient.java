package com.jsg.feign;

import com.jsg.base.result.ResultBase;
import com.jsg.dto.BankDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//1.name为被调用的服务应用名称.
//2.UserFallBack，当请求testA失败时调用其中的方法.
@FeignClient(name = "testA", fallback = TestAClientHystric.class)
public interface TestAClient {
    //被请求微服务的地址
    @RequestMapping("/bank/list")
    ResultBase bankList();

    @PostMapping(value = "/bank/new")
    ResultBase addBank(BankDTO dto);
}
