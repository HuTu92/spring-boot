package com.github.fnpac.spring.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringCoreApplication.class, args);

		DemoPublisher demoPublisher = context.getBean("demoPublisher", DemoPublisher.class);
//		demoPublisher.publishEventViaContext("hello spring event");
		demoPublisher.publishEventViaEventPublisher("hello spring event");
	}
}
