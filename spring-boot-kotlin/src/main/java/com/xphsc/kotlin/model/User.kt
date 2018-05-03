package com.xphsc.kotlin.model

import lombok.Data
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Entity
@Table(name = "T_USER")
@Data
 class User(@Id
           @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
           private val id: Int? = null,
           private val uname: String? = null,
                   private val age: String? = null,
                           private val password: String? = null) {
}