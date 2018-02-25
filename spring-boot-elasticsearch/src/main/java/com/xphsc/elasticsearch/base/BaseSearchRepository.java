package com.xphsc.elasticsearch.base;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by ${huipei.x} on 2017-2-25
 * qq群593802274
 */
public interface BaseSearchRepository <T, ID extends Serializable>
       extends ElasticsearchRepository<T, ID>, PagingAndSortingRepository<T, ID> {
}
