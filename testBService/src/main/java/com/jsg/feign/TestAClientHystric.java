package com.jsg.feign;

import com.jsg.base.result.ResultBase;
import com.jsg.dto.BankDTO;
import org.springframework.stereotype.Component;

@Component
public class TestAClientHystric implements TestAClient {
    @Override
    public ResultBase bankList() {
        System.out.println("进入断路器-list。。。");
        throw new RuntimeException("list 保存失败.");
    }

    @Override
    public ResultBase addBank(BankDTO dto) {
        System.out.println("进入断路器-save。。。");
        throw new RuntimeException("save 保存失败.");
    }
}

