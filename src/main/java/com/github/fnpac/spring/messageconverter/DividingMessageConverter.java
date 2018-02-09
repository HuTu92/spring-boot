package com.github.fnpac.spring.messageconverter;

import com.github.fnpac.pojo.DemoObj;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by 刘春龙 on 2018/2/8.
 */
public class DividingMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

    public DividingMessageConverter() {
        // 设置支持的mediatype
        // primary type, subtype, character set
        super(new MediaType("application", "x-fnpac", Charset.forName("utf-8")));
    }

    /**
     * 设置支持的类类型
     * @param clazz
     * @return
     */
    @Override
    protected boolean supports(Class<?> clazz) {
        return DemoObj.class.isAssignableFrom(clazz);
    }

    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = IOUtils.toString(inputMessage.getBody(), Charset.forName("utf-8"));
        String[] tempArr = temp.split("-");
        return new DemoObj(tempArr[0], tempArr[1]);
    }

    @Override
    protected void writeInternal(DemoObj demoObj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        outputMessage.getBody().write(("hello, " + demoObj.getName()).getBytes(Charset.forName("utf-8")));
    }
}
