package com.github.fnpac;

import com.github.fnpac.spring.properties.Author;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
@EnableConfigurationProperties(value = Author.class)
public class SpringCoreApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringCoreApplication.class, args);

        //////////////////////////////////////
        //      aware
        //////////////////////////////////////
//        AwareService service = context.getBean("awareService", AwareService.class);
//        service.out();

        //////////////////////////////////////
        //      event
        //////////////////////////////////////
//		DemoPublisher demoPublisher = context.getBean("demoPublisher", DemoPublisher.class);
////		demoPublisher.publishEventViaContext("hello spring event");
//		demoPublisher.publishEventViaEventPublisher("hello spring event");

        //////////////////////////////////////
        //      task
        //////////////////////////////////////
//        AsyncTaskService service = context.getBean("asyncTaskService", AsyncTaskService.class);
//        for (int i = 0; i < 10; i++) {
//            service.executeAsyncTask(i);
//        }
    }
}
