package com.jsg.service.impl;

import com.jsg.base.result.ResultBase;
import com.jsg.base.result.ResultUtil;
import com.jsg.dto.SolrQueryDTO;
import com.jsg.service.SolrService;
//import com.jsg.utils.solr.SolrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("SolrService")
@Transactional
public class SolrServiceImpl implements SolrService {
    private static Logger logger = LoggerFactory.getLogger(SolrServiceImpl.class);
//    @Autowired
    //private SolrUtils solrUtils;

//    public ResultBase search(SolrQueryDTO dto) throws Exception {
//        return ResultUtil.success(ResultUtil.SUCCESS, "查询成功！", solrUtils.queryList(dto.getKeyName() + ":" + dto.getKeyVal(), 0, 10));
//    }

}
