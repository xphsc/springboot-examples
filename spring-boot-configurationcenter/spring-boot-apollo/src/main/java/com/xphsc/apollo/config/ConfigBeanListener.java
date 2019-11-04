package com.xphsc.apollo.config;

import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.stereotype.Component;

@Component
public class ConfigBeanListener {

    @ApolloConfigChangeListener("application")
    private void anotherOnChange(ConfigChangeEvent changeEvent) {

        System.out.println("namespace:"+changeEvent.getNamespace());
        ConfigChange change = changeEvent.getChange("baidu.url");
        if (null != change) {
            System.out.println(String.format("Found change - key: %s, oldValue: %s," + "newValue: %s, changeType: %s",
                    change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType()));
        }


    }


}
