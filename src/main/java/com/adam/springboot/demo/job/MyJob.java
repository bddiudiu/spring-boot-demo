package com.adam.springboot.demo.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * Created by adam on 7/11/16.
 */
@Component
public class MyJob {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    /**
     * fixedRate = 2000    从上次开始执行时间之后2秒开始执行
     * fixedDelay = 2000   从上次执行结束时间之后2秒开始执行
     * initialDelay = 1000 延迟启动1秒
     * cron= ""            cron表达式
     */

    @Scheduled(fixedRate = 2000)
    public void reportTime(){
        //System.out.println(sdf.format(new Date()));
    }
}
