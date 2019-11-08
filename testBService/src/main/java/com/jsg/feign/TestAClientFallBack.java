package com.jsg.feign;

import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dto.BankDTO;
import org.springframework.stereotype.Component;

@Component
public class TestAClientFallBack implements TestAClient {
    @Override
    public ResultBase bankList() {
        return ResultUtil.exception("获取银行信息列表失败，服务异常！");
    }

    @Override
    public ResultBase addBank(BankDTO dto) {
        return ResultUtil.exception("保存银行账户信息失败，服务异常！");
    }
}

