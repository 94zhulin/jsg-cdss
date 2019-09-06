package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.dto.BankDTO;

public interface BankService {
    ResultBase add(BankDTO dto) throws Exception;

    ResultBase getAll() throws Exception;
}
