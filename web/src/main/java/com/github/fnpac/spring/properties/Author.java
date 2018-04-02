package com.github.fnpac.spring.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by 刘春龙 on 2018/2/28.
 *
 * {@link EnableConfigurationProperties}启用对{@link ConfigurationProperties}所注释的bean的支持。
 *
 * ConfigurationProperties bean可以以标准的方式注册（eg，@Bean、@Component）,
 * 或者为了方便起见，可以直接在@EnableConfigurationProperties中指定。
 */
@ConfigurationProperties(prefix = "author")
public class Author {

    private String username;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
