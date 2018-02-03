package com.github.fnpac.spring.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class SpringCoreApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringCoreApplication.class, args);

        AsyncTaskService service = context.getBean("asyncTaskService", AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            service.executeAsyncTask(i);
        }
    }
}
