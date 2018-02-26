package com.xphsc.mongo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Document(collection="mongo_user")
@Data
public class MongoUser {

    @Id
    private String id;
    private Integer userId;


}
