package com.xphsc.easysql.easyjdbc.test;





import com.github.xtool.serialize.JSONHelper;
import com.xphsc.easyjdbc.EasyJdbcOperations;
import com.xphsc.easyjdbc.EasyJdbcTemplate;
import com.xphsc.easyjdbc.builder.SQL;
import com.xphsc.easyjdbc.core.entity.Example;
import com.xphsc.easyjdbc.core.entity.Sorts;
import com.xphsc.easysql.easyjdbc.EasyJdbcApplication;
import com.xphsc.easysql.easyjdbc.dao.UserDao;
import com.xphsc.easysql.easyjdbc.model.User;
import com.xphsc.easysql.easyjdbc.model.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * {@link }
 * @author <a href="xiongpeih@163.com">huipei.x</a>
 * @description:
 * @date:
 * @since 0.1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EasyJdbcApplication.class)
@Slf4j
public class UserDaoTest {


    @Autowired
    private UserDao userDao;
    @Autowired
    private EasyJdbcTemplate easyJdbcTemplate;



    @Test
    public void update() {
       User user=new User();
        user.setAge(45);
        userDao.updateAge(user);
    }

    @Test
    public void listUser() {
        User user=new User();
        user.setId(1);
        userDao.listUser();
    }


    @Test
    public void List4() {
        Example example=  userDao.example();
        System.out.println("list" + JSONHelper.toJSON(example.list()));
    }

    @Test
    public void list() {
        Example example=userDao.example();
        example .entityClass(UserDTO.class);
        example.groupByClause("id","userName").mapping("id","userId");
        example.orderByClause(new Sorts(Sorts.Direction.DESC,"id"));
        Example.Criteria criteria= example.createCriteria();
        criteria.andEqualTo(User::getId,3);
       List list= example.list();
        System.out.println("list" + JSONHelper.toJSON(list));
    }





    @Test
    public void get() {
        List<UserDTO> vos = easyJdbcTemplate.selector()
                .SELECT("u.id,u.user_name")//select 语句
                .FROM("t_user u")//from语句
                .WHERE("u.id=?")//where语句
                .mapping("id","userId")
                .parameters("1").entityClass(UserDTO .class)//要组装的类
                .limit(20)//查询条数
                .list();//查询
        log.info("111"+JSONHelper.toJSON(vos));
    }

    @Test
    public void insert() {
        //插入

        // 单条插入
        User user = new User();
// 省略entity属性赋值... ...
        easyJdbcTemplate.insert(user);
        // 批量插入
        LinkedList<User> users = new LinkedList<User>();
// 省略entity属性赋值... ...
        easyJdbcTemplate.batchInsert(users);

    }

    @Test
    public void delete() {
        //删除

// 使用主键删除
        easyJdbcTemplate.deleteByPrimaryKey(User.class, "1");
// 使用SQL删除
        easyJdbcTemplate.delete(SQL.BUILD()
                        .DELETE_FROM("t_user")
                        .WHERE("age=?")
                , "21");
    }

}