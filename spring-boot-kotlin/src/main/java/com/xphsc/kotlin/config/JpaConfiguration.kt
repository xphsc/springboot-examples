package com.xphsc.kotlin.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.JpaVendorAdapter
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.stereotype.Component
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.util.*
import javax.naming.NamingException
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource


/**
 * Created by ${huipei.x} on 2017-2-25.
 * qq群593802274
 */
//@Configuration
//@Component
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager",
        basePackages = arrayOf("com.xphsc.*.repository.dao"))
class JpaConfiguration {

    @Autowired
    private val dataSource: DataSource? = null

    @Bean
    @Primary
    @Throws(NamingException::class)
    fun entityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        val factoryBean = LocalContainerEntityManagerFactoryBean()
        factoryBean.dataSource = dataSource!!
        factoryBean.setPackagesToScan(*arrayOf("com.xphsc.kotlin.model"))
        factoryBean.jpaVendorAdapter = jpaVendorAdapter()
        factoryBean.setJpaProperties(jpaProperties())

        return factoryBean;
    }


    @Bean
    fun jpaVendorAdapter(): JpaVendorAdapter {
        val hibernateJpaVendorAdapter = HibernateJpaVendorAdapter()
        return hibernateJpaVendorAdapter;
    }


    private fun jpaProperties(): Properties {
        val properties = Properties()
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
        properties.put("hibernate.show_sql", "hibernate.show_sql=true")
        properties.put("hibernate.format_sql", "hibernate.format_sql=true")
        return properties
    }

    @Bean
    fun transactionManager(emf: EntityManagerFactory): PlatformTransactionManager {
        val txManager = JpaTransactionManager()
        txManager.entityManagerFactory = emf
        return txManager
    }
}