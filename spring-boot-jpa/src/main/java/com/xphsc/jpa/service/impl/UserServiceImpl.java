package com.xphsc.jpa.service.impl;

import com.github.xphsc.bean.BeanByRefMapper;
import com.github.xphsc.collect.Lists;
import com.xphsc.jpa.model.User;
import com.xphsc.jpa.model.response.UserDTO;
import com.xphsc.jpa.repository.dao.UserRepository;
import com.xphsc.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ${huipei.x} on 2017-2-25.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> listUser(){
        List<UserDTO> userDTOList= Lists.newArrayList();
        List<User>  userList=userRepository.findAll();
        userDTOList= BeanByRefMapper.copyByRefListMapper(userList,UserDTO.class);
        return userDTOList;
    }
}
