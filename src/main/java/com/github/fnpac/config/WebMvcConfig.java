package com.github.fnpac.config;

import com.github.fnpac.pojo.DemoObj;
import com.github.fnpac.spring.messageconverter.DividingMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 刘春龙 on 2018/2/8.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    //////////////////////////////////////
    //      advice
    //////////////////////////////////////
    /**
     * spring boot 自动配置
     *
     * @return
     */
//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//        viewResolver.setViewClass(JstlView.class);
//        return viewResolver;
//    }


    //////////////////////////////////////
    //      fileupload
    //////////////////////////////////////

    /**
     * 配置ViewController，用于视图跳转
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/toConvert").setViewName("/converter");
    }

    /**
     * spring boot 自动配置
     * <p>
     * 用于Apache Commons FileUpload 1.2或更高版本的基于Servlet的MultipartResolver实现
     *
     * @return
     */
//    @Bean
//    public MultipartResolver multipartResolver() {
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(1000000);
//        return multipartResolver;
//    }

    //////////////////////////////////////
    //      messageconverter
    //////////////////////////////////////
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new DividingMessageConverter());
    }

    /**
     * spring boot customize config for HttpMessageConverter
     *
     * WebMvcAutoConfiguration will lazy autowires HttpMessageConverters
     *      Autowire logic:
     *          first by id;
     *          then by type;
     * so the bean name of HttpMessageConverters should be messageConverters，
     * if not, there should be only one bean of HttpMessageConverters type.
     *
     * 配置HttpMessageConverters bean，会导致丢弃HttpMessageConvertersAutoConfiguration自动配置中通过构造函数注入的converters
     */
//    @Bean
//    public HttpMessageConverters stringMessageConverters() {
//        List<HttpMessageConverter<?>> converters = new ArrayList<>();
//        StringHttpMessageConverter converter = new StringHttpMessageConverter();
//        converter.setDefaultCharset(Charset.forName("utf-8"));
//        converters.add(converter);
//        // HttpMessageConverters 默认会添加 默认的HttpMessageConverter
//        return new HttpMessageConverters(converters);
//    }

    //////////////////////////////////////
    //      ObjectProvider demo
    //////////////////////////////////////
    @Bean
    public DemoObj liucl() {
        return new DemoObj("001", "liucl");
    }

    @Bean
    public DemoObj lana() {
        return new DemoObj("002", "lana");
    }
}
