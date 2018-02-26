package com.xphsc.mongo.base;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.io.Serializable;


/**
 *Created by ${huipei.x} on 2017-2-25
 */
@NoRepositoryBean
public interface BaseMongoRepository<T, ID extends Serializable> extends MongoRepository<T,ID> {


}