package com.xphsc.kotlin


import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@SpringBootApplication(scanBasePackages = arrayOf("com.xphsc"))
open class KotlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinApplication::class.java, *args)
}
