package com.github.fnpac.spring.objectprovider;

import com.github.fnpac.pojo.DemoObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by 刘春龙 on 2018/3/2.
 */
@Component
public class ObjectProviderDemo {

    private static final Logger logger = LoggerFactory.getLogger(ObjectProviderDemo.class);

    private List<DemoObj> demoObjs;

    public ObjectProviderDemo(
            ObjectProvider<List<DemoObj>> demoObjsProvider) {
        this.demoObjs = demoObjsProvider.getIfAvailable();
    }

    @PostConstruct
    public void log() {
        String info = "[";
        info = demoObjs.stream().reduce(info,
                (s, demoObj) -> s + ("(" + demoObj.getId() + ", " + demoObj.getName() + "), "),
                (s, s2) -> null);
//        2018-03-02 16:49:34.963  INFO 19804 --- [           main] c.g.f.s.o.ObjectProviderDemo             : [(001, liucl), (002, lana)]
        info = info.subSequence(0, info.length() - 2).toString() + "]";
        logger.info(info);
    }

}
