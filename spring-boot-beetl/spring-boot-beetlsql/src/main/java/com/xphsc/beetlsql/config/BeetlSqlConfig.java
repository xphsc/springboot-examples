package com.xphsc.beetlsql.config;

import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.sql.DataSource;


/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Configuration
@EnableTransactionManagement
public class BeetlSqlConfig {
   /*@Autowired
    private  DataSource datasource;*/

    @Bean(name = "beetlSqlScannerConfigurer")
    public BeetlSqlScannerConfigurer getBeetlSqlScannerConfigurer() {
    BeetlSqlScannerConfigurer conf = new BeetlSqlScannerConfigurer();
    conf.setBasePackage("com.xphsc");//扫描那些类可以自动注入
    conf.setSqlManagerFactoryBeanName("sqlManager");
    return conf;
}

    //@Primary//sqlManager工厂(核心)
    @Bean(name = "sqlManager")
    public SqlManagerFactoryBean getSqlManagerFactoryBean( @Qualifier("datasource") DataSource datasource) {
        SqlManagerFactoryBean factory = new SqlManagerFactoryBean();
        BeetlSqlDataSource source = new BeetlSqlDataSource();
        source.setMasterSource(datasource);
        factory.setCs(source);
        //数据库类型
        factory.setDbStyle(new MySqlStyle());
        //debug模式 开发时使用
        //factory.setInterceptors(new Interceptor[]{new DebugInterceptor()});
        //命名转换方式
        factory.setNc(new UnderlinedNameConversion());
        return factory;
    }

    @Bean(name = "txManager")//开启事务管理
    public DataSourceTransactionManager getDataSourceTransactionManager(@Qualifier("datasource") DataSource datasource) {
        DataSourceTransactionManager dstm = new DataSourceTransactionManager();
        dstm.setDataSource(datasource);
        return dstm;
    }
}
