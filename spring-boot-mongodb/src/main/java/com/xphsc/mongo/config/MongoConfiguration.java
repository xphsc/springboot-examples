
package com.xphsc.mongo.config;




import com.xphsc.mongo.base.BaseMongoRepositoryImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


/** mongodb基础配置
 * Created by ${huipei.x} on 2016/9/5.
 */

@Configuration
@ComponentScan({"com.xphsc"})
@EnableMongoRepositories(repositoryBaseClass =BaseMongoRepositoryImpl.class,
        basePackages ="com.xphsc.mongo.repository.dao")
public class MongoConfiguration {

}

