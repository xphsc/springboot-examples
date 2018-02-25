package com.xphsc.mybatis.base;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by ${huipei.x} on 2017-2-25.
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>,IdsMapper<T> {
}

