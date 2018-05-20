package com.xphsc.test;

import com.xphsc.logback.LogbackApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *  Created by ${huipei.x} on 2017-2-25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= LogbackApplication.class)
public class LogTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void log() {
        logger.info("log4j2{}");
    }



}
