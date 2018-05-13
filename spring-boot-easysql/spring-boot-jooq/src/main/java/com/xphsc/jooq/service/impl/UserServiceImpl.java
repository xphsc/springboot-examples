package com.xphsc.jooq.service.impl;



import com.github.xphsc.collect.Lists;
import com.xphsc.jooq.dao.UserDao;
import com.xphsc.jooq.model.User;
import com.xphsc.jooq.model.response.UserDTO;
import com.xphsc.jooq.service.UserService;
import org.jooq.Record;
import org.jooq.Record3;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<UserDTO> listUser(){
        final Map<Record, Result<Record>> recordResultMap =  userDao.getDslContext().select().from(User.t_user)
                .fetch().intoGroups(User.t_user.fields());;
        return getCollect(recordResultMap);
    }

    private List<UserDTO> getCollect(Map<Record, Result<Record>> recordResultMap) {
        List<UserDTO> userlist= Lists.newArrayList();
        userlist=recordResultMap
                .values()
                .stream()
                .map(records -> {
                    final Record3<Integer,String,String> record3 = records.into(User.t_user.getId(), User.t_user.getUname(),User.t_user.getAge()).get(0);
                    final Integer id = record3.value1();
                    final String name = record3.value2();
                    final String age = record3.value3();
                    return new UserDTO(id, name,age);
                }).collect(Collectors.toList());
        return userlist;
    }
}
