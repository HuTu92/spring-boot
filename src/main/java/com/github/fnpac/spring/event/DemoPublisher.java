package com.github.fnpac.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by liuchunlong on 2018/2/2.
 *
 * 1。 通过{@link ApplicationContext#publishEvent(ApplicationEvent)}发布事件；
 * 2。 通过{@link org.springframework.context.ApplicationEventPublisherAware#setApplicationEventPublisher(ApplicationEventPublisher)}
 *      获取{@link org.springframework.context.ApplicationEventPublisher}发布事件
 */
@Component
public class DemoPublisher implements ApplicationEventPublisherAware {

    final ApplicationContext context;

    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public DemoPublisher(ApplicationContext context) {
        this.context = context;
    }

    /**
     * 通过ApplicationContext发布DemoEvent事件
     *
     * @param msg
     */
    public void publishEventViaContext(String msg) {
        DemoEvent event = new DemoEvent(this, msg);
        context.publishEvent(event);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishEventViaEventPublisher(String msg) {
        DemoEvent event = new DemoEvent(this, msg);
        applicationEventPublisher.publishEvent(event);
    }
}
