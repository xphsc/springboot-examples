package com.xphsc.jdbc.base;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
public interface BaseDao {
    public JdbcTemplate getJdbcTempleate();
    public List queryForList(String sql, Object[] args);
    public Map queryForMap(String sql, Object[] args);
}
