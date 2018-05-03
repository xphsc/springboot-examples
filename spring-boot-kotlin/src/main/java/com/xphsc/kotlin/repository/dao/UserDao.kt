package com.xphsc.kotlin.repository.dao

import com.xphsc.kotlin.model.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by ${huipei.x} on 2017-2-25
 */
interface UserDao : JpaRepository<User, Integer> {
}