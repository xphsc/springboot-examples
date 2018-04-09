package com.xphsc.hibernate.base;

import java.util.List;

/**
 *  Created by ${huipei.x} on 2017-2-25
 */
public interface BaseDao<T, K> {

    public Integer add(T obj);

    public void update(T obj);

    public void delete(T obj);

    public T get(Class<T> clasz, K k);
    public  List<T> findAll(Class<T> clasz);
    public List<T> query(String hql, Object[] obj);

}
