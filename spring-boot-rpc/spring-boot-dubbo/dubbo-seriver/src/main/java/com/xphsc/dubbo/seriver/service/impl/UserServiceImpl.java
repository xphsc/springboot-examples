package com.xphsc.dubbo.seriver.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.xphsc.bean.BeanByRefMapper;
import com.github.xphsc.collect.Lists;
import com.xphsc.dubbo.api.model.User;
import com.xphsc.dubbo.api.model.response.UserDTO;
import com.xphsc.dubbo.api.service.UserService;
import com.xphsc.dubbo.seriver.repository.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ${huipei.x} on 2017-2-25.
 */
@Service(loadbalance="random")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserDTO> listUser(){
        List<UserDTO> userDTOList= Lists.newArrayList();
        List<User>  userList=userDao.findAll();
        userDTOList= BeanByRefMapper.copyByRefListMapper(userList,UserDTO.class);
        return userDTOList;
    }
}
