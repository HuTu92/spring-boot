package com.github.fnpac.spring.aware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class SpringCoreApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringCoreApplication.class, args);

        AwareService service = context.getBean("awareService", AwareService.class);
        service.out();
    }
}
