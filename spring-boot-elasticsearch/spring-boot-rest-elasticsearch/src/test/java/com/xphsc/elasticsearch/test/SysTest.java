package com.xphsc.elasticsearch.test;

import com.xphsc.elasticsearch.annotations.Document;
import com.xphsc.elasticsearch.annotations.Field;
import com.xphsc.elasticsearch.annotations.Id;
import com.xphsc.elasticsearch.annotations.Index;
import lombok.Data;
import org.elasticsearch.common.text.Text;

import java.util.Date;

/**
 * {@link }
 * @author <a href="xiongpeih@163.com">huipei.x</a>
 * @description:
 * @date:
 * @since 0.1.0
 */
@Data
@Document(indexName = "sys_test", type = "detail",maxResult = 2)
@Index
public class SysTest    {

    @Id
    @Field(keyword=true)
    private String id;@Field(keyword=true)
    private String requestIp;        //操作IP
    @Field(keyword=true)
    private String type;            //  操作类型 1 操作记录 2异常记录
    @Field(keyword=true)
    private String userId;          // 操作人ID
    @Field(keyword = true,name="user_name")
    private String userName;          // 操作人
    @Field(keyword = true)
    private  String description;// 操作ue描述
    @Field(keyword=true)

    private String requestUrl;   // 请求路径@Field(keyword=true,docValues=true)
    private Date requestTime;        // 操作时间

    private String requestMethod; // 请求方式
    @Field(keyword=true)

    private String methodName;  // 请求方法名
    @Field(keyword=true)
    private String beanName;



}

