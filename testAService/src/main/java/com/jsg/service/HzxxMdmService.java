package com.jsg.service;

import com.jsg.base.result.ResultBase;

/**
 * 患者信息查询接口
 *
 * @author weidong
 * @date 2019/6/3
 */
public interface HzxxMdmService {
    /**
     * 获取患者信息列表
     *
     * @return
     * @throws Exception
     */
    ResultBase getHzxx() throws Exception;
}
