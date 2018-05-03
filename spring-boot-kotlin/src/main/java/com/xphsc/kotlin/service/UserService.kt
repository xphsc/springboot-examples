package com.xphsc.kotlin.service

import com.xphsc.kotlin.model.User
import com.xphsc.kotlin.model.response.UserDTO

/**
 * Created by ${huipei.x} on 2017-2-25
 */
interface UserService {
    fun listUser(): List<UserDTO>;
}