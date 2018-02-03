package com.github.fnpac.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by liuchunlong on 2018/2/2.
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    private static final Logger logger = Logger.getLogger(DemoListener.class.getName());

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(DemoEvent event) {
        logger.info("捕获到DemoEvent, 事件内容：" + event.getMsg());
    }
}
