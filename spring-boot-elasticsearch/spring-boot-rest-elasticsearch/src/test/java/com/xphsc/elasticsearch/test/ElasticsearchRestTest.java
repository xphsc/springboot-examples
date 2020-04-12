package com.xphsc.elasticsearch.test;


import com.alibaba.fastjson.JSON;
import com.github.xtool.date.DateFormat;
import com.xphsc.elasticsearch.core.ElasticsearchTemplate;
import com.xphsc.elasticsearch.core.entity.aggregate.DateHistogramEntity;
import com.xphsc.elasticsearch.core.query.QueryCriteria;
import com.xphsc.elasticsearch.core.query.SearchQuery;
import com.xphsc.elasticsearch.core.query.aggregations.AggregateBuilder;
import com.xphsc.elasticsearch.page.Page;
import com.xphsc.rest.elasticsearch.ElasticsearchRestApplication;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * {@link }
 * @author <a href="xiongpeih@163.com">huipei.x</a>
 * @description:
 * @date:
 * @since 0.1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ElasticsearchRestApplication.class)
@Slf4j
public class ElasticsearchRestTest {
@Autowired
private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void add(){
        SysTest vapLog=new SysTest();
        vapLog.setDescription("你好");
        vapLog.setUserName("小王");
        vapLog.setRequestTime(DateTime.now().plusDays(-2).toDate());
        List<SysTest> sysTests= new ArrayList<SysTest>();
        sysTests.add(vapLog);
        System.out.println("----asd----:"+  JSON.toJSONString( elasticsearchTemplate.save(vapLog).toString()) );
    }




    @Test
    public void searchQuery(){
        AggregationBuilder aggregationBuilder= AggregationBuilders.count("count").field("_uid");
        aggregationBuilder.subAggregation(
                AggregationBuilders
                        .dateHistogram("time")
                        .field("requestTime")
                        .dateHistogramInterval(DateHistogramInterval.DAY)
                        .format(DateFormat.DATE_FORMAT_DAY));
        SearchQuery searchQuery=SearchQuery
                .builder().indices("sys_test").aggregationBuilder(aggregationBuilder).build();
        List<Map<String,Object>> mapList=elasticsearchTemplate.queryForList(searchQuery);
        System.out.println("----COUNT----:"+mapList.toString());
    }


    @Test
    public void agg(){

        DateHistogramEntity dateHistogramEntity=DateHistogramEntity
                .builder()
                .name("time")
                .field("requestTime")
                .format(DateFormat.DATE_FORMAT_DAY)
                .dateHistogramInterval(DateHistogramInterval.DAY)
                .build();

        QueryCriteria queryCriteria=new QueryCriteria();
        AggregateBuilder agg = new AggregateBuilder();
        agg.dateHistogram(dateHistogramEntity);
        queryCriteria.startPage(0,3);
        queryCriteria.mapping("docCount","count");
        queryCriteria.entityClass(SysTestDTO.class);
        queryCriteria.aggregationCriteria(agg);
        queryCriteria.createCriteria().lessThanEqual(SysTest::getRequestTime,DateTime.now().toDate());

        Page<SysTestDTO> threDTOS= elasticsearchTemplate.aggregateForPage(queryCriteria,SysTest.class);


        System.out.println("----COUNT----:"+JSON.toJSONString(threDTOS));

    }


}
