package com.xphsc.hibernate.base;




import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;


import java.io.Serializable;
import java.util.List;

/**
 *  Created by ${huipei.x} on 2017-2-25
 */
public class BaseDaoImpl<T, K extends Serializable> implements BaseDao<T, K> {

     @Autowired
     private SessionFactory sessionFactory;
    @Autowired
    private   HibernateTemplate hibernateTemplate;
    @Override
    public Integer add(T obj)  {
        return (Integer) this.getSession().save(obj);//用了hibernate保存添加的方法save来进行添加
    }

    @Override
    public void update(T obj)  {
        this.getSession().update(obj);//修改
    }

    @Override
    public void delete(T obj) {
        this.getSession().delete(obj);//删除
    }

    @Override
    public T get(Class<T> clasz, K k) {
        return (T)this.getSession().get(clasz,k);//查询
    }
    @Override
    public  List<T> findAll(Class<T> clasz) {
        Criteria criteria = this.getSession().createCriteria(clasz);
        return criteria.list();
    }



    @Override
    public List<T> query(String hql, Object[] obj)  {
        Session session = this.getSession();
        Query query = session.createQuery(hql);
        if (obj != null) {
            for (int i = 0; i < obj.length; i++) {
                query.setParameter(i, obj[i]);
            }
        }
        return query.list();
    }




    /**
     * 获得数据库连接对象的方法
     *
     * @return
     * @throws Exception
     */
    public synchronized Session getSession()  {
        return sessionFactory.getCurrentSession();
    }
}
