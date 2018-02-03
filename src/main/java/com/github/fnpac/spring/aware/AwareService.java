package com.github.fnpac.spring.aware;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by liuchunlong on 2018/2/3.
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private static final Logger logger = Logger.getLogger(AwareService.class.getName());

    private String beanName;
    private ResourceLoader resourceLoader;

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 输出
     *
     * @throws IOException
     */
    public void out() throws IOException {
        logger.info("Bean 的名称：" + beanName);

        Resource resource = resourceLoader.getResource("classpath:aware.txt");
        // commons io 提供了简便的读取文件流的方式
        String text = IOUtils.toString(resource.getInputStream(), Charsets.toCharset("utf-8"));
        logger.info("ResourceLoader 加载的文件内容：" + text);
    }
}
