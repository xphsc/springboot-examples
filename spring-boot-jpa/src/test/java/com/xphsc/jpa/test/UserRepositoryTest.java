package com.xphsc.jpa.test;

import com.github.xphsc.bean.BeanByRefMapper;
import com.github.xphsc.collect.Lists;
import com.github.xphsc.json.JSONHelper;
import com.xphsc.jpa.JpaApplication;
import com.xphsc.jpa.common.Criteria;
import com.xphsc.jpa.common.QueryCondition;
import com.xphsc.jpa.model.User;
import com.xphsc.jpa.model.response.UserDTO;
import com.xphsc.jpa.repository.dao.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

/**
 * Created by ${huipei.x} on 2018-4-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaApplication.class)
@Slf4j
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Test
    public void list(){
            Criteria<User> criteria = new Criteria<>();
            criteria.add(QueryCondition.eq("uname", "2"));
            List<User> userList = userRepository.findAll(criteria);
            List<UserDTO> userDTOList= Lists.newArrayList();
            userDTOList= BeanByRefMapper.copyByRefListMapper(userList, UserDTO.class);
          log.info("list"+ JSONHelper.toJSON(userDTOList));
    }
}
