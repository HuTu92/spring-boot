package com.github.fnpac.spring.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by 刘春龙 on 2018/2/28.
 */
@Component
@ConfigurationProperties(prefix = "config")
@PropertySource("classpath:config.properties")
public class Description {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
