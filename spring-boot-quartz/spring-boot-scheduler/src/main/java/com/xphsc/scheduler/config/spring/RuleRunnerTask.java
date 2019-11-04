package com.xphsc.scheduler.config.spring;


import com.xphsc.scheduler.service.RuleRunnerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@Component
@Configurable
@EnableScheduling
public class RuleRunnerTask {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE);

    @Autowired
    private RuleRunnerService ruleRunnerService;

    @Scheduled(fixedRate = 1000 * 30)
    public void reportCurrentTime(){
        System.out.println("Scheduling Tasks Examples: The time is now " + simpleDateFormat.format(new Date()));
    }

    @Scheduled(cron = "* */15 * * * *")
    public void ruleRunner() {
        String runnerTag = simpleDateFormat.format(System.currentTimeMillis());
       System.out.println("Rule-Runner[{}] ---> begin at {}"+runnerTag);
        ruleRunnerService.execute();
        System.out.println("Rule-Runner[{}] ---> end at {}"+ simpleDateFormat.format(System.currentTimeMillis()));
    }
}
