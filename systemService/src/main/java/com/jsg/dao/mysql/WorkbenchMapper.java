package com.jsg.dao.mysql;

import com.jsg.entity.QuickEntry;
import org.springframework.stereotype.Repository;

/**
 * @author jeanson 进生
 * @date 2020/1/7 14:48
 */
@Repository
public interface WorkbenchMapper {
    QuickEntry quickEntry();

}
