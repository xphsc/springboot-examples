package com.xphsc.jdbc.base.impl;

import com.xphsc.jdbc.base.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Repository
public class BaseDaoImpl implements BaseDao {
    @Autowired
    private JdbcTemplate jdbcTempleate;

    @Override
    public JdbcTemplate getJdbcTempleate() {
        return jdbcTempleate;
    }



    public List queryForList(String sql, Object[] args) {
        return jdbcTempleate.query(sql, args, new RowMapper() {
            @Override
            public Map mapRow(ResultSet rs, int index)  {
                Map remap = new HashMap();
                int cnum = 0;
                try {
                    cnum = rs.getMetaData().getColumnCount();
                    for (int i = 1; i <= cnum; i++) {
                        String colname = rs.getMetaData().getColumnName(i);
                        remap.put(colname.toLowerCase(), rs.getObject(i));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return remap;
            }
        });
    }

    public Map queryForMap(String sql, Object[] args) {
        List relist = this.queryForList(sql, args);
        return (Map) relist.get(0);
    }


}
