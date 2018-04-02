package com.github.fnpac.spring.task;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by liuchunlong on 2018/2/3.
 *
 * 通过{@link AsyncConfigurer}配置异步线程池
 */
@Configuration
@EnableAsync // 开启异步支持
public class TaskExecutorConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.setThreadNamePrefix("workor-");
        // 如果采用@Bean方式注册，则可以省略initialize
        // 因为ThreadPoolTaskExecutor实现了InitializingBean接口，并重写了afterPropertiesSet方法，
        // 在其中对initialize进行了调用。
        // 即：如果ThreadPoolTaskExecutor的创建交给Spring，则initialize由Spring自动调用
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
