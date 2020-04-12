package com.xphsc.elasticsearch.base;



import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.repository.support.ElasticsearchEntityInformation;
import org.springframework.data.elasticsearch.repository.support.SimpleElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by ${huipei.x} on 2017-2-25
 * qq群593802274
 */
@NoRepositoryBean
public class BaseSearchRepositoryImpl <T, ID  extends Serializable> extends SimpleElasticsearchRepository<T> implements BaseSearchRepository<T,String>  {

    protected final ElasticsearchOperations elasticsearchTemplate;
    protected final ElasticsearchEntityInformation<T, ID> entityInformation;
    public BaseSearchRepositoryImpl(ElasticsearchEntityInformation<T, ID> metadata, ElasticsearchOperations ElasticsearchOperations) {
       super((ElasticsearchEntityInformation<T, String>) metadata, ElasticsearchOperations);
        this.elasticsearchTemplate=ElasticsearchOperations;
        this.entityInformation = metadata;
    }
    @Override
    public Class<T> getEntityClass(){
        return entityInformation.getJavaType();
    }

}
