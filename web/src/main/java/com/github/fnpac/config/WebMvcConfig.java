package com.github.fnpac.config;

import com.github.fnpac.pojo.DemoObj;
import com.github.fnpac.spring.messageconverter.DividingMessageConverter;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(new DividingMessageConverter());
//    }

    /**
     * {@link HttpMessageConvertersAutoConfiguration#HttpMessageConvertersAutoConfiguration(ObjectProvider)}注入{@link DividingMessageConverter} bean
     *
     * @return
     */
    @Bean
    public DividingMessageConverter dividingMessageConverter() {
        return new DividingMessageConverter();
    }

    /**
     * spring boot customize config for HttpMessageConverter
     * <p>
     * WebMvcAutoConfiguration will lazy autowires HttpMessageConverters
     * Autowire logic:
     * first by id;
     * then by type;
     * so the bean name of HttpMessageConverters should be messageConverters，
     * if not, there should be only one bean of HttpMessageConverters type.
     * <p>
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

    //////////////////////////////////////
    //      ssl
    //      redirect 8080 to 8443
    //////////////////////////////////////
    @Bean
    public EmbeddedServletContainerFactory servletContainerFactory() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        factory.addAdditionalTomcatConnectors(createHttpConnector());
        return factory;
    }

    @Bean
    public Connector createHttpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setSecure(false);
        connector.setPort(8080);
        connector.setRedirectPort(8443);
        return connector;
    }
}
