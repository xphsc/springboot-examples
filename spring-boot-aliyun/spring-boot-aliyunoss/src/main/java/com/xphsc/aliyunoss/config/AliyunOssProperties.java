package com.xphsc.aliyunoss.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Data
@ConfigurationProperties(AliyunOssProperties.PREFIX)
public class AliyunOssProperties {
    public static final String PREFIX = "aliyun.oss";

    /**
     */
    private String endpoint;
    /**
     */
    private String accessKey;
    /**
     */
    private String secretKey;
    /**
     */
    private String securityToken;



}
