package com.cheky.springboot.demo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author cheky
 * @date 2020-12-24
 */
@Component
public class ScheduleTask {
    /**
     * 每五秒执行一次
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void executeFileDownLoadTask() {
        System.out.println("定时任务启动: 每五秒执行一次");
    }
}
