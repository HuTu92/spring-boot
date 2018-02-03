package com.github.fnpac.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by liuchunlong on 2018/2/2.
 * <p>
 * Spring自定义事件
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
