package org.holy.wcoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WcoaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WcoaApplication.class, args);
    }

}

