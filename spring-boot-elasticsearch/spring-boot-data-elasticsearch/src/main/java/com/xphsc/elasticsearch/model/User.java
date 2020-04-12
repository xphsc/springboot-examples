package com.xphsc.elasticsearch.model;


import com.xphsc.elasticsearch.common.Global;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.stereotype.Component;
import java.io.Serializable;

/**
 * Created by ${huipei.x} on 2017-2-25.
 * qq群593802274
 */
@Component
@Document(indexName = Global.INDEX_USER, type = Global.TYPE_USER)
@Data
public class User implements Serializable{

    @Id
    private Integer id;
    @Field(store = true, analyzer = Global.IK_MAX_WORD, searchAnalyzer = Global.IK_MAX_WORD, type = FieldType.String)
    private String uname;
    private String age;
    private String password;






}

