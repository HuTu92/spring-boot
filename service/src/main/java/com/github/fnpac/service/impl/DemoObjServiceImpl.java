package com.github.fnpac.service.impl;

import com.github.fnpac.service.DemoObjService;
import com.github.fnpac.pojo.DemoObj;
import org.springframework.stereotype.Service;

/**
 * Created by 刘春龙 on 2018/4/1.
 */
@Service
public class DemoObjServiceImpl implements DemoObjService {

    @Override
    public DemoObj findOne() {
        DemoObj demoObj = new DemoObj("@", "liucl");
        return demoObj;
    }
}
