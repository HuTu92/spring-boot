package com.github.fnpac.config;

import com.github.fnpac.spring.messageconverter.DividingMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
     *
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
}
