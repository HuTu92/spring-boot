package com.github.fnpac.spring.messageconverter;

import com.github.fnpac.pojo.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 刘春龙 on 2018/2/8.
 */
@Controller
public class DividingController {

    @RequestMapping(value = "/convert", produces = "application/x-fnpac", method = RequestMethod.POST)
    @ResponseBody
    public DemoObj doSomething(@RequestBody DemoObj demoObj) {
        return demoObj;
    }
}
