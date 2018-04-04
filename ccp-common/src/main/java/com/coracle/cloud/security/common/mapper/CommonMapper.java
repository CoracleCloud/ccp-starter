package com.coracle.cloud.security.common.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;

/**
 * @author coracle
 * @create 2018/2/7.
 */
public interface CommonMapper<T> extends SelectByIdsMapper<T>,Mapper<T> {
}
