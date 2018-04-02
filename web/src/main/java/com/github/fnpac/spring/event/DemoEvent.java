package com.github.fnpac.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * Created by liuchunlong on 2018/2/2.
 * <p>
 * Spring自定义事件
 * <p>
 * 此外，{@link ApplicationContextEvent} 继承自 {@link ApplicationEvent} ，用于表示spring容器相关事件。
 * 而 {@link ApplicationEvent} 继承自 java.util.EventObject
 * <p>
 * {@link ApplicationEvent}只有一个入参为Object类型的构造函数{@link ApplicationEvent#ApplicationEvent(Object)}，
 * 入参表示事件最初发生的对象
 */
public class DemoEvent extends ApplicationEvent {

    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
