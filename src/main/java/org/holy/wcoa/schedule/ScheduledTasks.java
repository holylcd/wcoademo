package org.holy.wcoa.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Scheduled(cron = "* * * * * ?")
    public void evenyDay(){
        System.out.println(System.currentTimeMillis());
    }

}
