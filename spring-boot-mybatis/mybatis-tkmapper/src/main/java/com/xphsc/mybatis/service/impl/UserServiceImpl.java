package com.xphsc.mybatis.service.impl;

import com.github.xphsc.bean.BeanByRefMapper;
import com.github.xphsc.collect.Lists;
import com.xphsc.mybatis.mapper.UserMapper;
import com.xphsc.mybatis.model.User;
import com.xphsc.mybatis.model.response.UserDTO;
import com.xphsc.mybatis.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ${huipei.x} on 2017-2-25.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    SqlSession sqlSession ;
    @Override
    @Transactional
    public List<UserDTO> listUser(){
      //  userMapper=sqlSession.getMapper(UserMapper.class);
        List<UserDTO> userDTOList= Lists.newArrayList();
        List<User>  userList=userMapper.selectALL();/*userMapper.selectAll();*//*sqlSession.selectList("selectALL");*/
        userDTOList= BeanByRefMapper.copyByRefListMapper(userList,UserDTO.class);
        return userDTOList;
    }
}
