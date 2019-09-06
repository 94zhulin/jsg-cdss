package com.jsg.service;

import com.jsg.base.result.ResultBase;
import com.jsg.dto.FamilyDTO;

public interface FamilyService {
    ResultBase add(FamilyDTO dto) throws Exception;

    ResultBase getAll() throws Exception;
}
