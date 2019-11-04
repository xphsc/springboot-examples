package com.xphsc.scheduler.config.quartz;


import com.xphsc.scheduler.service.RuleRunnerService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class RuleRunner implements Job {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE);
    @Autowired
    private RuleRunnerService ruleRunnerService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String runnerTag = simpleDateFormat.format(System.currentTimeMillis());
            ruleRunnerService.execute();
       System.out.println("Rule-Runner[{}] ---> end at {}"+simpleDateFormat.format(System.currentTimeMillis()));
    }
}
