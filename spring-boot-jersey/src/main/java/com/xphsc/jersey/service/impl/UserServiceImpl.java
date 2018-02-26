package com.xphsc.jersey.service.impl;

import com.github.xphsc.bean.BeanByRefMapper;
import com.github.xphsc.collect.Lists;

import com.xphsc.jersey.model.User;
import com.xphsc.jersey.model.response.UserDTO;
import com.xphsc.jersey.repository.dao.UserRepository;
import com.xphsc.jersey.service.UserService;
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

    @Override
    public List<UserDTO> listUser(){
        List<UserDTO> userDTOList= Lists.newArrayList();
        List<User>  userList=userRepository.findAll();
        userDTOList= BeanByRefMapper.copyByRefListMapper(userList,UserDTO.class);
        return userDTOList;
    }

    @Override
    public UserDTO  findUserByid(Integer id){

        User user= userRepository.findOne(id);
        UserDTO userDTO=BeanByRefMapper.copyByRefMapper(user,UserDTO.class);
        return userDTO;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user=BeanByRefMapper.copyByRefMapper(userDTO,User.class);
        User userOne=userRepository.save(user);
        UserDTO userDTOOne=BeanByRefMapper.copyByRefMapper(userOne,UserDTO.class);
      return userDTOOne;
    }
}
