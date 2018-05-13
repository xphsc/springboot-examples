package com.xphsc.test;


import com.xphsc.beetlsql.BeetlSqlApplication;
import com.xphsc.beetlsql.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ${huipei.x} on 2017-2-25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BeetlSqlApplication.class)
@Slf4j
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void getUserByname(){
        log.info("getUserByname"+userService.getUserByname("1"));
    }

    @Test
    public void listUser(){
        log.info("listUser"+userService.listUser());
    }
}
