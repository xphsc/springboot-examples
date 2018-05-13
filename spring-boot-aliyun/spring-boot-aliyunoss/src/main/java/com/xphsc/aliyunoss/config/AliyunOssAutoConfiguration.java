package com.xphsc.aliyunoss.config;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.Credentials;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.common.auth.DefaultCredentials;
import com.github.xphsc.util.StringUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ${huipei.x} on 2017-2-25
 */
@Configuration
@ConditionalOnClass(OSSClient.class)
@EnableConfigurationProperties(AliyunOssProperties.class)
public class AliyunOssAutoConfiguration {

    @Bean
    public Credentials creds(AliyunOssProperties properties) {
        if (StringUtil.isNotEmpty(properties.getSecurityToken())) {
            return new DefaultCredentials(properties.getAccessKey(), properties.getSecretKey());
        }

        return new DefaultCredentials(properties.getAccessKey(), properties.getSecretKey());
    }

    @Bean
    public CredentialsProvider credsProvider(Credentials creds) {
        return new DefaultCredentialProvider(creds);
    }

    @Bean
    public OSSClientBuilder clientBuilder(AliyunOssProperties properties, CredentialsProvider credsProvider) {
        return new OSSClientBuilder();
    }

    @Bean
    public OSSClient ossClient(AliyunOssProperties properties) {
        OSSClient client = new OSSClient(properties.getEndpoint(), properties.getAccessKey(), properties.getSecretKey());
        return client;
    }
}
