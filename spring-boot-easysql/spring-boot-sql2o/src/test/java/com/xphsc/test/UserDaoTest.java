package com.xphsc.test;

import com.github.xphsc.json.JSONHelper;
import com.xphsc.sql2o.Sql2oApplication;
import com.xphsc.sql2o.dao.UserDao;
import com.xphsc.sql2o.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Sql2oApplication.class)
@Slf4j
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void list(){
        List<User> userList =userDao.listUser();
        log.info("list{}"+ JSONHelper.toJSON(userList));
    }
}
