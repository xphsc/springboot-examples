package com.xphsc.kotlin.service.impl

import com.github.xphsc.bean.BeanByRefMapper
import com.github.xphsc.collect.Lists
import com.xphsc.kotlin.model.User
import com.xphsc.kotlin.model.response.UserDTO
import com.xphsc.kotlin.repository.dao.UserDao
import com.xphsc.kotlin.service.UserService
import org.springframework.stereotype.Service

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Service
class UserServiceImpl(private val userDao: UserDao) : UserService {

    override fun listUser(): List<UserDTO> {
        var userDTOList: List<UserDTO> = Lists.newArrayList<UserDTO>();
        var userList:List<User> = userDao.findAll();
        userDTOList = BeanByRefMapper.copyByRefListMapper(userList, UserDTO::class.java)
        return userDTOList;
    }

}