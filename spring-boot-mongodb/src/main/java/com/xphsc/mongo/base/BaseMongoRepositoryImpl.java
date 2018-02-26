package com.xphsc.mongo.base;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.io.Serializable;



/**
 * Created by ${huipei.x} on 2017-2-25
 */
@NoRepositoryBean
public class BaseMongoRepositoryImpl<T, ID extends Serializable> extends SimpleMongoRepository<T,ID>  implements BaseMongoRepository<T, ID> {

    private  Logger logger =  LoggerFactory.getLogger(this.getClass());
    protected final MongoOperations mongoTemplate;
    protected final MongoEntityInformation<T, ID> entityInformation;
    public BaseMongoRepositoryImpl(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
        this.mongoTemplate=mongoOperations;
        this.entityInformation = metadata;
    }
    protected Class<T> getEntityClass(){
        return entityInformation.getJavaType();
    }


}
