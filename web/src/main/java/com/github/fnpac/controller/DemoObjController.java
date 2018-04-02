package com.github.fnpac.controller;

import com.github.fnpac.pojo.DemoObj;
import com.github.fnpac.service.DemoObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 刘春龙 on 2018/4/1.
 */
@Controller
public class DemoObjController {

    private final DemoObjService demoObjService;

    @Autowired
    public DemoObjController(DemoObjService demoObjService) {
        this.demoObjService = demoObjService;
    }

    @RequestMapping(value = "/demoObj", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    DemoObj demoObj() {
        return demoObjService.findOne();
    }
}
